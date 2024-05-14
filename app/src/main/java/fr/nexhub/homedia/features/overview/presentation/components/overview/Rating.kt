package fr.nexhub.homedia.features.overview.presentation.components.overview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.LocalContentColor
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import fr.nexhub.homedia.R

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun Rating(rating: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            modifier = Modifier.size(18.dp),
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "search",
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            modifier = Modifier,
            color = LocalContentColor.current,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyLarge,
            text = rating,
        )
    }
}