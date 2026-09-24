package com.example.cherepeninpr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cherepeninpr01.ui.theme.CherepeninPR01Theme
import androidx.activity.viewModels
import com.example.cherepeninpr01.viewmodel.RecipeViewModel
import com.example.cherepeninpr01.viewmodel.UserViewModel
import com.example.cherepeninpr01.viewmodel.ProductViewModel
class MainActivity : ComponentActivity() {

    private val viewModelRecipes: RecipeViewModel by viewModels()
    private val viewModelUsers: UserViewModel by viewModels()
    private val viewModelProduct: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CherepeninPR01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        // viewModelRecipes.loadRecipes()
        // viewModelUsers.addUser()
        viewModelProduct.changeProduct()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CherepeninPR01Theme {
        Greeting("Android")
    }
}