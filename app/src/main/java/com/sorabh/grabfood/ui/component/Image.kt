package com.sorabh.grabfood.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun ShowImageFromUrl(modifier: Modifier,url:String) {
    AsyncImage(model = url, contentDescription = "image",modifier = modifier , contentScale = ContentScale.Crop)
}