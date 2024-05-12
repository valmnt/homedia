package fr.nexhub.homedia.features.server_registration.presentation.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IPorDomainTextField(
    modifier: Modifier,
    value: String,
    label: String,
    mutableInteractionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        textStyle = TextStyle(color = androidx.compose.material3.MaterialTheme.colorScheme.surface),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = androidx.compose.material3.MaterialTheme.colorScheme.surface,
            cursorColor = androidx.compose.material3.MaterialTheme.colorScheme.surface,
            focusedLabelColor = androidx.compose.material3.MaterialTheme.colorScheme.surface,
        ),
        interactionSource = mutableInteractionSource,
        label = { Text(text = label, color = androidx.compose.material3.MaterialTheme.colorScheme.surface) },
        value = value,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        onValueChange = onValueChange,
    )
}

@Preview
@Composable
fun TvTextFieldPrev() {
    IPorDomainTextField(Modifier,"Test", "Enter Test") {}
}