@file:OptIn(ExperimentalTvMaterial3Api::class)

package fr.nexhub.homedia.features.home.presentation.components.carousel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyListScope
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text

@Composable
fun HorizontalCarouselItem(
    text: String,
    content:  TvLazyListScope.() -> Unit) {
    Column(Modifier.height(150.dp)) {
        Text(text = text, modifier = Modifier.padding(horizontal = 24.dp))
        TvLazyRow(
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 8.dp,
                bottom = 8.dp,
                end = 100.dp,
            ),
            content = content
        )
    }
}
