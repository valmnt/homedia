package fr.nexhub.homedia.features.common.item.domain.model

import android.graphics.Bitmap
import fr.nexhub.homedia.features.overview.domain.model.Details
import java.util.UUID

data class Item (
    val id: UUID,
    val title: String,
    val image: Bitmap?,
    val details: Details?
)