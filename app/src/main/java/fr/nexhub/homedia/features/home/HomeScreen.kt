package fr.nexhub.homedia.features.home

import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    onItemFocus: (parent: Int, child: Int) -> Unit,
) {
    HomeScreenContent(onItemFocus)
}
