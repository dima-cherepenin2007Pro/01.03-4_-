package com.example.cherepeninpr01.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cherepeninpr01.R

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 49.dp,
                    end = 20.dp,
                    start = 20.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
            ) {
                Image(
                    painter = painterResource(R.drawable.lupa),
                    contentDescription = ""
                )
            }
            Column(
                modifier = Modifier,
            ) {
                Box() {
                    Text(
                        text = "Make home",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(400),
                    )
                }
                Box() {
                    Text(
                        text = "Beatiful",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(500),
                    )
                }
            }
            Box(
            ) {
                Image(
                    painter = painterResource(R.drawable.backet),
                    contentDescription = ""
                )
            }

        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}