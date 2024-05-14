package fr.nexhub.homedia.features.common.components

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
import fr.nexhub.homedia.features.common.item.domain.model.Item
import java.util.UUID

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun CardCarouselForItem(item: Item, onItemFocus: (itemId: UUID) -> Unit) {
    BorderedFocusableItem(
        onClick = {
            onItemFocus(item.id)
        },
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(0.6f),
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            if (item.image == null) {
                Text(text = item.title, textAlign = TextAlign.Center)
            } else {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(80.dp),
                    bitmap = item.image.asImageBitmap(),
                    contentScale = ContentScale.Crop,
                    contentDescription = ""
                )
                Image(bitmap = item.image.asImageBitmap(), contentDescription = "")
            }
        }
    }
}