package fr.nexhub.homedia.common.domain.model

import android.graphics.Bitmap
import java.util.UUID

data class Item (
    val id: UUID,
    val title: String,
    val image: Bitmap?
)