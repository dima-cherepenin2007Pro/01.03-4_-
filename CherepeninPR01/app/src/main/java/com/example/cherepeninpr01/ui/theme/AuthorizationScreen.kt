package com.example.cherepeninpr01.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.cherepeninpr01.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cherepeninpr01.ui.theme.Components.TextButton
import com.example.cherepeninpr01.ui.theme.Components.TextInput
import com.example.cherepeninpr01.ui.theme.Components.TextInput2
import com.example.cherepeninpr01.ui.theme.Components.PrimaryButton
@Composable
fun AuthorizationScreen(
    modifier: Modifier = Modifier,
    onNextClick: () -> Unit
) {
    var emailText by remember { mutableStateOf("") }
    var pssswordText by remember { mutableStateOf("") }
    val isEmailValid = emailText.isNotBlank()

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
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
            ) {
                Image(
                    painter = painterResource(R.drawable.line),
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.width(29.dp))
            Box() {
                Image(
                    painter = painterResource(R.drawable.circle_idk),
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.width(29.dp))
            Box() {
                Image(
                    painter = painterResource(R.drawable.line),
                    contentDescription = ""
                )
            }
        }
        Spacer(modifier = Modifier.height(30.17.dp))
        Box(
            modifier = Modifier
                .padding(
                    start = 30.dp,
                ),
        ) {
            Text(
                text = "Hello !",
                color = pailColor,
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .padding(
                    start = 30.dp,
                ),
        ) {
            Text(
                text = "WELCOME BACK !",
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(
                    start = 30.dp,
                    end = 30.dp
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "E-mail",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                )
            }
            TextInput(
                " ",
                modifier = Modifier
                    .fillMaxWidth(),
                value = emailText,
                onValueChange = { emailText = it },
            )
            Spacer(modifier = Modifier.height(35.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Password",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                )
            }
            TextInput2(
                " ",
                modifier = Modifier
                    .fillMaxWidth(),
                value = pssswordText,
                trailingIcon = painterResource(id = R.drawable.eye),
                onValueChange = { pssswordText = it },
            )
            Spacer(modifier = Modifier.height(35.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                TextButton("Forgot Password", 20)
            }
            Spacer(modifier = Modifier.height(40.dp))
            PrimaryButton(
                true,
                "Log in",
                17,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                onClick = onNextClick,
            )
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                TextButton("Sign up", 18)
            }
        }
    }
}

@Preview
@Composable
private fun AuthorizationScreenPreview() {
    AuthorizationScreen(onNextClick = {})
}