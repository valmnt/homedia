package fr.nexhub.homedia.features.wiw

import androidx.compose.runtime.Composable
import fr.nexhub.homedia.features.wiw.data.Avatar

@Composable
fun WhoIsWatchingScreen(onProfileSelection: (avatar: Avatar) -> Unit) {
    WhoIsWatchingContent(onProfileSelection)
}
