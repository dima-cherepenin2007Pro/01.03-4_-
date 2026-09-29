package com.example.cherepeninpr01.ui.theme.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cherepeninpr01.ui.theme.ButtonColor1
@Composable
fun SecondaryButton(
    ifable: Boolean,
    text: String,
    text_size: Int,
    modifier: Modifier = Modifier
) {
    OutlinedButton (
        onClick = {},
        enabled = ifable,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = ButtonColor1,
        ),
        border = BorderStroke(2.dp, ButtonColor1),
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = text_size.sp,
        )
    }
}

@Preview
@Composable
private fun SecondaryButtonPreview() {
    SecondaryButton(
        true,
        "Еще одна кнопка",
        20,
        modifier = Modifier
            .size(width = 335.dp, height = 56.dp)
    )
}