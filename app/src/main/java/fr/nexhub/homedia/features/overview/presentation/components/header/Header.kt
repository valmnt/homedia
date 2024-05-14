package fr.nexhub.homedia.features.overview.presentation.components.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import fr.nexhub.homedia.R
import fr.nexhub.homedia.features.common.components.TvButton
import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.features.overview.presentation.ANIMATION_DELAY
import kotlinx.coroutines.delay
import org.jellyfin.sdk.model.api.BaseItemKind

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun Header(item: Item, selectHeader: (HeaderItems) -> Unit) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(key1 = Unit) {
        delay(ANIMATION_DELAY)
        focusRequester.requestFocus()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Spacer(modifier = Modifier.width(280.dp))
        TvButton(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp),
            onClick = {},
        ) {
            Text(stringResource(R.string.play))
        }
        TvButton(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .focusRequester(focusRequester),
            onClick = { selectHeader(HeaderItems.OVERVIEW) },
        ) {
            Text(stringResource(R.string.overview))
        }
        if (item.details?.type == BaseItemKind.SERIES) {
            TvButton(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                onClick = { selectHeader(HeaderItems.SEASONS) },
            ) {
                Text(stringResource(R.string.seasons))
            }
        }
    }
}