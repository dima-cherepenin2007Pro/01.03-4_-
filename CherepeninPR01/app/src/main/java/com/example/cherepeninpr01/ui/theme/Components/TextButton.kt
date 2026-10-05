package com.example.cherepeninpr01.ui.theme.Components

import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TextButton(
    text: String,
    size: Int,
    modifier: Modifier = Modifier
){
    TextButton(
        onClick = {},
        modifier = modifier
    ){
        Text(
            text = text,
            color = Color.Black,
            fontSize = size.sp,
        )
    }
}

@Preview
@Composable
private fun TextButtonPreview() {
    TextButton("Текст, на который можно нажать", 20)
}