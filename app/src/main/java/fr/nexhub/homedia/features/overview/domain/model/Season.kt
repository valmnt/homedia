package fr.nexhub.homedia.features.overview.domain.model

import android.graphics.Bitmap
import java.util.UUID

data class Season (
    val id: UUID,
    val title: String,
    val image: Bitmap?,
)