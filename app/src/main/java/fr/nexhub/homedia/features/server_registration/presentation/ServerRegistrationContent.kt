package fr.nexhub.homedia.features.server_registration.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import fr.nexhub.homedia.R
import fr.nexhub.homedia.features.server_registration.presentation.components.IPorDomainTextField
import fr.nexhub.homedia.features.common.components.TvButton

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ServerRegistrationContent(state: ServerRegistrationViewState, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(320.dp)
    ) {
        val textField = remember { mutableStateOf("") }

        IPorDomainTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            value = textField.value,
            label = stringResource(id = R.string.ip_or_domain_name),
        ) {
            textField.value = it
            state.textFieldValue = TextFieldValue(it)
        }

        Spacer(modifier = Modifier.size(10.dp))

        TvButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onClick = onClick,
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = stringResource(id = R.string.submit),
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center,
                    ),
                )
            }
        }

        if (state.error != null) {
            Toast.makeText(
                LocalContext.current, stringResource(state.error.details.messageId),
                Toast.LENGTH_SHORT).show()
        }
    }
}