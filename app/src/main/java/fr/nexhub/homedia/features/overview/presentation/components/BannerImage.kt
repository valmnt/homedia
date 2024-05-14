package fr.nexhub.homedia.features.overview.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun BannerImage(modifier: Modifier, image: ImageBitmap) {
    Image(
        modifier = modifier
            .fillMaxSize()
            .blur(100.dp),
        bitmap = image,
        contentScale = ContentScale.Crop,
        contentDescription = ""
    )
}