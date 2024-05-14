package fr.nexhub.homedia.features.episodes.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ClickableSurfaceDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import fr.nexhub.homedia.features.common.components.BorderedFocusableItem
import fr.nexhub.homedia.features.episodes.domain.model.Episode

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun EpisodeItem(episode: Episode) {
    BorderedFocusableItem(
        modifier = Modifier.padding(10.dp),
        scale =  ClickableSurfaceDefaults.scale(focusedScale = 1.03f),
        color = ClickableSurfaceDefaults.colors(
            containerColor = MaterialTheme.colorScheme.onSurface,
            focusedContainerColor = MaterialTheme.colorScheme.onSurface
        ),
        onClick = { /*TODO*/ }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(16.dp)
        ) {
            if (episode.image != null) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(0.4F)
                        .fillMaxHeight(),
                    contentScale = ContentScale.None,
                    bitmap = episode.image.asImageBitmap(),
                    contentDescription = "")
            }
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.5F),
                    text = episode.title,
                    fontSize = 16.sp,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = episode.overview ?: "",
                    fontSize = 16.sp,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}