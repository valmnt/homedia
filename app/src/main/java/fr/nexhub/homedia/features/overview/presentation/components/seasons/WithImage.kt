package fr.nexhub.homedia.features.overview.presentation.components.seasons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun WithImage(bitmap: ImageBitmap, text: String) {
    Image(bitmap = bitmap, contentDescription = "")
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(10.dp))
}