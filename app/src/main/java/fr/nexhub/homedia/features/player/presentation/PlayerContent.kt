package fr.nexhub.homedia.features.player.presentation

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import fr.nexhub.exoplayer.PlayerFactory
import fr.nexhub.homedia.features.player.presentation.components.PlayerControls
import fr.nexhub.homedia.features.player.presentation.components.rememberVideoPlayerState
import fr.nexhub.homedia.utils.handleDPadKeyEvents
import fr.nexhub.player.domain.state.PlayerState
import fr.nexhub.player.domain.state.PlayerStateListener
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber


@SuppressLint("UnsafeOptInUsageError")
@Composable
fun PlayerContent(
    modifier: Modifier,
    title: String,
    mediaUrl: String,
    onBackPressed: () -> Unit) {
    val context = LocalContext.current

    val player = remember {
        PlayerFactory.create(context)
    }

    val coroutineScope = rememberCoroutineScope()
    var contentCurrentPosition: Long by remember { mutableLongStateOf(0L) }
    val videoPlayerState = rememberVideoPlayerState(hideSeconds = 4, coroutineScope)

    val stateListener = remember {
        object : PlayerStateListener {
            override fun on(state: PlayerState) {
                Timber.d("State $state")
            }
        }
    }

    BackHandler(onBack = onBackPressed)

    LaunchedEffect(Unit) {
        player.prepare(mediaUrl, true)
        player.setPlaybackEvent(callback = stateListener)
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(300)
            contentCurrentPosition = player.currentPosition
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black),
        contentAlignment = Alignment.Center) {
        DisposableEffect(Unit) {
            onDispose { player.release() }
        }
        AndroidView(
            modifier = Modifier
                .handleDPadKeyEvents(
                    onEnter = {
                        if (!videoPlayerState.isDisplayed) {
                            coroutineScope.launch {
                                videoPlayerState.showControls()
                            }
                        }
                    },
                )
                .focusable(),
            factory = {
                player.getView()
            },
        )
        PlayerControls(
            modifier = Modifier.align(Alignment.BottomCenter),
            isPlaying = player.isPlaying,
            onPlayPauseToggle = { shouldPlay ->
                if (shouldPlay) {
                    player.play()
                } else {
                    player.pause()
                }
            },
            contentProgressInMillis = contentCurrentPosition,
            contentDurationInMillis = player.duration,
            state = videoPlayerState,
            onSeek = { seekProgress ->
                player.seekTo(player.duration.times(seekProgress).toLong())
            },
            title = title
        )
    }
}