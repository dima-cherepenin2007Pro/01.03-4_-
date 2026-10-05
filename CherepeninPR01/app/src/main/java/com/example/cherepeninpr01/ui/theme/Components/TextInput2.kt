package com.example.cherepeninpr01.ui.theme.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cherepeninpr01.R

@Composable
fun TextInput2(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: Painter? = null,
    trailingIconContentDescription: String? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    trailingIconSize: Int = 24
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(label) },
        trailingIcon = {
            if (trailingIcon != null) {
                val icon: @Composable () -> Unit = {
                    Image(
                        painter = trailingIcon,
                        contentDescription = trailingIconContentDescription,
                        modifier = Modifier.size(trailingIconSize.dp)
                    )
                }

                if (onTrailingIconClick != null) {
                    IconButton(onClick = onTrailingIconClick) { icon() }
                } else {
                    icon()
                }
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedLabelColor = Color.Gray,
            unfocusedLabelColor = Color.Gray
        )
    )
}

@Preview
@Composable
private fun TextInputPreview() {
    var text by remember { mutableStateOf("") }

    TextInput2(
        label = "Введите текст",
        value = text,
        onValueChange = { text = it },
        trailingIcon = painterResource(id = R.drawable.eye),
        trailingIconContentDescription = "Очистить",
        onTrailingIconClick = { text = "" },
        modifier = Modifier.size(width = 335.dp, height = 48.dp)
    )
}