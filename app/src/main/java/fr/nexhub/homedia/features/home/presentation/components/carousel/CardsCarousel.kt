@file:OptIn(ExperimentalTvMaterial3Api::class)

package fr.nexhub.homedia.features.home.presentation.components.carousel

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import fr.nexhub.homedia.features.common.components.BorderedFocusableItem
import java.util.UUID

@Composable
fun CardCarouselForLibrary(
    modifier: Modifier = Modifier,
    id: UUID,
    text: String,
    onItemClick: (HorizontalRowType, List<String>) -> Unit,
) {
    BorderedFocusableItem(
        onClick = { onItemClick(HorizontalRowType.LIBRARIES, listOf(id.toString(), text)) },
        borderRadius = 12.dp,
        modifier = modifier
            .padding(horizontal = 8.dp)
            .aspectRatio(1.8f)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = text, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun CardCarouselForRecentItemInLibrary(
    modifier: Modifier = Modifier,
    id: UUID,
    text: String,
    bitmap: Bitmap?,
    onItemClick: (HorizontalRowType, List<String>) -> Unit,
) {
    BorderedFocusableItem(
        onClick = { onItemClick(HorizontalRowType.RECENT_ITEMS, listOf(id.toString())) },
        borderRadius = 12.dp,
        modifier = modifier
            .padding(horizontal = 8.dp)
            .aspectRatio(1.8f)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            if (bitmap == null) {
                Text(text = text, textAlign = TextAlign.Center)
            } else {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(80.dp),
                    bitmap = bitmap.asImageBitmap(),
                    contentScale = ContentScale.Crop,
                    contentDescription = ""
                )
                Image(bitmap = bitmap.asImageBitmap(), contentDescription = "")
            }
        }
    }
}