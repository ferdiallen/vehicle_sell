package com.ferdialif.vehicleseller.core.ui

import android.content.Context
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.decode.SvgDecoder

fun Context.loadSVGImage(): ImageLoader {
    return ImageLoader.Builder(this).components {
        add(SvgDecoder.Factory())
    }.build()
}