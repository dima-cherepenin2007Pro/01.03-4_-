package com.example.cherepeninpr01.ui.theme.Components


import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cherepeninpr01.ui.theme.ButtonColor1
import com.example.cherepeninpr01.ui.theme.DisButtonColor1

@Composable
fun PrimaryButton(
    ifable: Boolean,
    text: String,
    text_size: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        enabled = ifable,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = ButtonColor1,
            contentColor = Color.White,
            disabledContainerColor = DisButtonColor1,
            disabledContentColor = Color.White
        ),
        modifier = modifier
    ){
        Text(
            text = text,
            fontSize = text_size.sp,
        )
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    PrimaryButton(
        true,
        "Кнопка",
        17,
        modifier = Modifier
            .size(width = 335.dp, height = 56.dp)
    )
}