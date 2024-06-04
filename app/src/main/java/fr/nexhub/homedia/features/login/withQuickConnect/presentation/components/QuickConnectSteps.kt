package fr.nexhub.homedia.features.login.withQuickConnect.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text

@Composable
fun QuickConnectSteps(first: String, second: String, third: String, spaceBetweenSteps: Dp) {
    Column {
        QuickConnectStep(text = first, spaceBetweenSteps)
        QuickConnectStep(text = second, spaceBetweenSteps)
        QuickConnectStep(text = third, spaceBetweenSteps)
    }
}

@Composable
@OptIn(ExperimentalTvMaterial3Api::class)
fun QuickConnectStep(text: String, spaceBetweenSteps: Dp) {
    Spacer(Modifier.size(spaceBetweenSteps))
    Text(
        text = text,
        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
    )
}