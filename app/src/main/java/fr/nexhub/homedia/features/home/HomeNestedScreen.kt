package fr.nexhub.homedia.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import fr.nexhub.homedia.features.home.carousel.HomeCarousel

@Composable
fun HomeNestedScreen(
    onItemFocus: (parent: Int, child: Int) -> Unit,
    onItemClick: (parent: Int, child: Int) -> Unit,
) {

    val focusState = remember {
        mutableStateOf(FocusPosition(0, 0))
    }

    Column(Modifier.fillMaxSize()) {
        HomeCarousel(Modifier.weight(1f), onItemFocus = { parent, child ->
            focusState.value = FocusPosition(parent, child)
            onItemFocus(parent, child)
        }, onItemClick = onItemClick)
    }
}

typealias FocusPosition = Pair<Int, Int>
