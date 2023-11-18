package com.ferdialif.vehicleseller.core.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay

@Composable
fun LazyGridItemScope.AnimateItemsAfterCertainSeconds(seconds: Long, content: @Composable () -> Unit) {
    val isItemShown = remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = Unit, block = {
        delay(seconds)
        isItemShown.value = true
    })
    AnimatedVisibility(
        visible = isItemShown.value,
        enter = fadeIn(tween(400)) + slideInHorizontally(tween(200))
    ) {
        content()
    }
}