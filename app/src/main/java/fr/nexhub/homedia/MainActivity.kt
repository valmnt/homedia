package fr.nexhub.homedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme.colorScheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.nexhub.homedia.managers.JellyfinManager
import fr.nexhub.homedia.managers.PreferencesManager
import fr.nexhub.homedia.navigation.AppNavigation
import fr.nexhub.homedia.navigation.Screens
import fr.nexhub.homedia.theme.HomediaTheme
import java.util.UUID

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class, ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomediaTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorScheme.background)) {
                    App(navController = rememberAnimatedNavController())
                }
            }
        }
    }

    @Composable
    fun App(navController: NavHostController) {
        val preferencesManager = PreferencesManager(context = applicationContext)
        val accessToken = preferencesManager.getData("ACCESS_TOKEN", "")
        val startDestination: String

        if (accessToken.isEmpty()) {
            startDestination = Screens.ServerRegistration.title
        } else {
            startDestination = Screens.Home.title

            JellyfinManager.initSDK(
                currentContext = applicationContext,
                baseUrl = preferencesManager.getData("BASE_URL", ""),
                userId = UUID.fromString(preferencesManager.getData("USER_ID", "")),
                accessToken = accessToken
            )
        }

        AppNavigation(navController, startDestination)
    }
}
