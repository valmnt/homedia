package fr.nexhub.homedia.features.settings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.managers.PreferencesManager
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
): ViewModel() {

    fun logout() {
        preferencesManager.reset()
    }
}