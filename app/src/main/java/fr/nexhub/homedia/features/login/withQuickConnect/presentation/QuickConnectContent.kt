package fr.nexhub.homedia.features.login.withQuickConnect.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import fr.nexhub.homedia.R
import fr.nexhub.homedia.features.common.components.TvButton
import fr.nexhub.homedia.features.login.withQuickConnect.presentation.components.QuickConnectSteps
import fr.nexhub.homedia.features.login.withQuickConnect.presentation.components.QuickConnectTitle

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun QuickConnectContent(status: Int, code: String?) {
    Box (
        modifier =  Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(start = 50.dp, top = 40.dp)
        ) {
            when (status) {
                in 200..299 -> code?.let { QuickConnectEnabled(code = it) }
                401 -> QuickConnectDisabled()
                else -> QuickConnectError()
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "${stringResource(R.string.other_options)}:",
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    TvButton(
                        colors = ButtonDefaults.colors(
                            contentColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                            focusedContentColor = MaterialTheme.colorScheme.surface
                        ),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = stringResource(R.string.use_password)
                        )
                    }
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalTvMaterial3Api::class)
fun QuickConnectEnabled(code: String) {
    QuickConnectTitle(text = stringResource(R.string.please_sign_in), fontSize = 30.sp)
    QuickConnectSteps(
        first = stringResource(R.string.quick_connect_enabled_first_step),
        second = stringResource(R.string.quick_connect_enabled_second_step),
        third = stringResource(R.string.quick_connect_enabled_third_step),
        spaceBetweenSteps = 20.dp
    )
    Spacer(Modifier.size(30.dp))
    Text(
        text = code,
        color = MaterialTheme.colorScheme.primary,
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun QuickConnectDisabled() {
    QuickConnectTitle(text = stringResource(R.string.quick_connect_disabled), fontSize = 30.sp)
    Spacer(Modifier.size(20.dp))
    QuickConnectSteps(
        first = stringResource(R.string.quick_connect_disabled_first_step),
        second = stringResource(R.string.quick_connect_disabled_second_step),
        third = stringResource(R.string.quick_connect_disabled_third_step),
        spaceBetweenSteps = 20.dp
    )
}

@Composable
fun QuickConnectError() {
    QuickConnectTitle(text = stringResource(R.string.an_error_has_occurred_with_quick_connect), fontSize = 30.sp)
    Spacer(Modifier.size(20.dp))
    QuickConnectSteps(
        first = stringResource(R.string.quick_connect_error_first_step),
        second = stringResource(R.string.quick_connect_error_second_step),
        third = stringResource(R.string.quick_connect_error_third_step),
        spaceBetweenSteps = 20.dp
    )
}