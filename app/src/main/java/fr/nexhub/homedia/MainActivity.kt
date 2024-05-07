package fr.nexhub.homedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.nexhub.homedia.managers.JellyfinManager
import fr.nexhub.homedia.managers.PreferencesManager
import fr.nexhub.homedia.navigation.AppNavigation
import fr.nexhub.homedia.navigation.Screens
import fr.nexhub.homedia.theme.HomediaTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            val displayDialog = remember {
                mutableStateOf(false)
            }

            App(navController = rememberAnimatedNavController())

            registerOnBackPress {
                displayDialog.value = true
            }

            if (displayDialog.value) {
                CustomDialog(openDialogCustom = displayDialog) {
                    finish()
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
                accessToken = accessToken
            )
        }

        HomediaTheme {
            AppNavigation(navController, startDestination)
        }
    }
}
