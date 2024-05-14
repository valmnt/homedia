package fr.nexhub.homedia.features.episodes.domain.model

import android.graphics.Bitmap
import java.util.UUID

data class Episode (
    val id: UUID,
    val title: String,
    val image: Bitmap?,
    val overview: String?,
)