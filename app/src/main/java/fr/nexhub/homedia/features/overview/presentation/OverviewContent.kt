package fr.nexhub.homedia.features.overview.presentation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import fr.nexhub.homedia.R
import fr.nexhub.homedia.features.common.components.ThumbnailImageCard
import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.features.overview.domain.model.Season
import fr.nexhub.homedia.features.overview.presentation.components.BannerImage
import fr.nexhub.homedia.features.overview.presentation.components.header.Header
import fr.nexhub.homedia.features.overview.presentation.components.header.HeaderItems
import fr.nexhub.homedia.features.overview.presentation.components.overview.Overview
import fr.nexhub.homedia.features.overview.presentation.components.seasons.Seasons
import kotlinx.coroutines.delay
import java.util.UUID

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun OverviewContent(item: Item, seasons: List<Season>, selectedSeason: (id: UUID) -> Unit) {
    val selectedHeader = remember {
        mutableStateOf(HeaderItems.OVERVIEW)
    }

    val isLoaded = remember {
        mutableStateOf(false)
    }

    val animatedPortraitSize = animateDpAsState(targetValue = if (isLoaded.value) 150.dp else 1.dp)

    LaunchedEffect(key1 = Unit) {
        delay(ANIMATION_DELAY)
        isLoaded.value = true
    }

    Box {
        Column(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxSize(),
        ) {
            BannerImage(
                modifier = Modifier
                    .weight(.4f),
                image = item.image?.asImageBitmap() ?: ImageBitmap.imageResource(R.drawable.solid_black)
            )
            Column(modifier = Modifier.weight(.6f)) {
                Header(item = item) {
                    selectedHeader.value = it
                }
                when(selectedHeader.value) {
                    HeaderItems.OVERVIEW -> Overview(item = item)
                    HeaderItems.SEASONS -> Seasons(seasons = seasons, selectedSeason)
                }
            }
        }

        ThumbnailImageCard(
            Modifier
                .align(Alignment.CenterStart)
                .padding(start = 30.dp)
                .width(animatedPortraitSize.value),
        ) {
            if (item.image != null) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(80.dp),
                    bitmap = item.image.asImageBitmap(),
                    contentScale = ContentScale.Crop,
                    contentDescription = ""
                )
                Image(bitmap = item.image.asImageBitmap(), contentDescription = "")
            } else {
                Text(text = item.title, textAlign = TextAlign.Center)
            }
        }
    }
}