package com.example.foodguru.ui.features.home

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.foodguru.ui.features.details.Meal



class HomeViewModel : ViewModel() {
    private var _randomMeal by mutableStateOf<Meal>(getRandomMeal())
    private var _textFieldState = TextFieldState()

    val randomMeal: Meal
        get() = _randomMeal

    val textFieldState: TextFieldState
        get() = _textFieldState

    fun search() {

    }
}

private fun getRandomMeal() = Meal(
    "53225",
    "Yemeni Lahsa (Elite Shakshuka)",
    "Breakfast",
    "Saudi Arabian",
    "Saudi Arabia",
    "1\r\nFirst, On medium heat, heat the olive oil and add the diced onion until it wethers. Next, add the tomatoes and cook for another 4-5 min. Lastly, add the all spice, salt, and cracked pepper.\r\n2\r\nAdd the eggs and mix throughly for 2 minutes and cover to cook 5-6 minutes until top is solidified. Lastly, spread the liquid cheese and have it covered for a minute.\r\n3\r\nI served mine Mediterranean style with hash-browns, Egyptian fava beans, Turkish salami and olives, cheese wedges, and greek feta.",
    "https://www.themealdb.com/images/media/meals/30s7vf1763741844.jpg",
    null,
    "https://www.youtube.com/shorts/1QX-KBX6tmM",
)