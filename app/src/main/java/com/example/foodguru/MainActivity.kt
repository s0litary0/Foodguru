package com.example.foodguru

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.example.foodguru.ui.components.ScreenLayout
import com.example.foodguru.ui.features.home.HomeScreen
import com.example.foodguru.ui.theme.FoodguruTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodguruTheme {
                ScreenLayout() {
                    HomeScreen()
                }
            }
        }
    }
}
