package fr.nexhub.homedia.features.overview.presentation.components.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.LocalContentColor
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.features.overview.presentation.components.overview.sections.MovieInfoSection
import fr.nexhub.homedia.features.overview.presentation.components.overview.sections.ShowInfoSection
import org.jellyfin.sdk.model.api.BaseItemKind

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun Overview(item: Item) {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.size(220.dp))
        Column(
            Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier,
                color = LocalContentColor.current,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.headlineLarge,
                text = item.title,
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier,
                color = LocalContentColor.current,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
                text = item.details?.overview ?: "",
            )
            Spacer(modifier = Modifier.size(10.dp))
            when (item.details?.type) {
                BaseItemKind.SERIES -> ShowInfoSection(item = item)
                else -> MovieInfoSection(item = item)
            }
        }
    }
}