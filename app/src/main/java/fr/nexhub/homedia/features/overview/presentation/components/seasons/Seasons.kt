package fr.nexhub.homedia.features.overview.presentation.components.seasons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import fr.nexhub.homedia.features.common.components.BorderedFocusableItem
import fr.nexhub.homedia.features.overview.domain.model.Season
import java.util.UUID

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun Seasons(seasons: List<Season>, selectedSeason: (id: UUID) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Row {
            Spacer(modifier = Modifier.size(220.dp))
            for (season in seasons) {
                BorderedFocusableItem(
                    modifier = Modifier
                        .width(130.dp)
                        .padding(top = 20.dp, end = 10.dp),
                    onClick = { selectedSeason(season.id) }
                ) {
                    val image = season.image
                    Column {
                        if (image == null) {
                            WithoutImage(text = season.title)
                        } else {
                            WithImage(bitmap = season.image.asImageBitmap(), text = season.title)
                        }
                    }
                }
            }
        }
    }
}