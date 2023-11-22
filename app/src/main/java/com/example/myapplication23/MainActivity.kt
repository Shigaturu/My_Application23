package com.example.myapplication23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication23.exo.pictureList
import com.example.myapplication23.ui.screens.PictureRowItem
import com.example.myapplication23.ui.screens.SearchScreen
import com.example.myapplication23.ui.theme.MyApplication23Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication23Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.LightGray) {
                    Column {
                        SearchScreen()
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication23Theme {
        Column {
            repeat(4) {
                PictureRowItem(pictureList[it])
            }
        }
    }
}