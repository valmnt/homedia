package fr.nexhub.homedia.features.home.domain.model

import android.graphics.Bitmap
import java.util.UUID

data class RecentItem (
    val id: UUID,
    val title: String,
    val image: Bitmap?
)