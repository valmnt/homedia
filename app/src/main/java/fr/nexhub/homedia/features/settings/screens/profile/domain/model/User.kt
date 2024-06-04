package fr.nexhub.homedia.features.settings.screens.profile.domain.model

import org.jellyfin.sdk.model.DateTime

data class User (
    val name: String,
    val lastActivityDate: DateTime?
)