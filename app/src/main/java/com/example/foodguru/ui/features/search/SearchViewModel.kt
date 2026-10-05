package com.example.foodguru.ui.features.search

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel


class SearchViewModel : ViewModel() {

    private var _recipes = getRecipesList().toMutableStateList()
    val recipes: List<Recipe>
        get() = _recipes

    private var _tags = getTags().toMutableStateList()
    val tags: List<Tag>
        get() = _tags

    private var _selectedTags = emptyList<Tag>().toMutableStateList()

    val selectedTasks: List<Tag>
        get() = _selectedTags

    fun toggleTag(tag: Tag) {
        if (tag in _selectedTags) {
            _selectedTags.remove(tag)
        } else {
            _selectedTags.add(tag)
        }
    }

    fun isTagSelected(tag: Tag): Boolean {
        return tag in _selectedTags
    }

}

private fun getTags(): List<Tag> = listOf(
    Tag(label = "Pizza"),
    Tag(label = "Italian"),
    Tag(label = "Vegetarian"),
    Tag(label = "Stir-fry"),
    Tag(label = "Asian"),
    Tag(label = "Cookies"),
    Tag(label = "Dessert"),
    Tag(label = "Baking"),
    Tag(label = "Pasta"),
    Tag(label = "Chicken"),
    Tag(label = "Salsa"),
    Tag(label = "Salad"),
    Tag(label = "Quinoa"),
    Tag(label = "Bruschetta"),
    Tag(label = "Beef"),
    Tag(label = "Caprese"),
    Tag(label = "Shrimp")
)

private fun getRecipesList(): List<Recipe> = listOf(
    Recipe(
        id = 1L,
        name = "Classic Margherita Pizza",
        ingredients = listOf(
            "Pizza dough",
            "Tomato sauce",
            "Fresh mozzarella cheese",
            "Fresh basil leaves",
            "Olive oil",
            "Salt and pepper to taste"
        ),
        instructions = listOf(
            "Preheat the oven to 475°F (245°C).",
            "Roll out the pizza dough and spread tomato sauce evenly.",
            "Top with slices of fresh mozzarella and fresh basil leaves.",
            "Drizzle with olive oil and season with salt and pepper.",
            "Bake in the preheated oven for 12-15 minutes or until the crust is golden brown.",
            "Slice and serve hot."
        ),
        prepTimeMinutes = 20L,
        cookTimeMinutes = 15L,
        servings = 4L,
        difficulty = "Easy",
        cuisine = "Italian",
        caloriesPerServing = 300L,
        tags = listOf("Pizza", "Italian"),
        userId = 166L,
        image = "https://cdn.dummyjson.com/recipe-images/1.webp",
        rating = 4.6,
        reviewCount = 98L,
        mealType = listOf("Dinner")
    ),

    Recipe(
        id = 2L,
        name = "Vegetarian Stir-Fry",
        ingredients = listOf(
            "Tofu, cubed",
            "Broccoli florets",
            "Carrots, sliced",
            "Bell peppers, sliced",
            "Soy sauce",
            "Ginger, minced",
            "Garlic, minced",
            "Sesame oil",
            "Cooked rice for serving"
        ),
        instructions = listOf(
            "In a wok, heat sesame oil over medium-high heat.",
            "Add minced ginger and garlic, sauté until fragrant.",
            "Add cubed tofu and stir-fry until golden brown.",
            "Add broccoli, carrots, and bell peppers. Cook until vegetables are tender-crisp.",
            "Pour soy sauce over the stir-fry and toss to combine.",
            "Serve over cooked rice."
        ),
        prepTimeMinutes = 15L,
        cookTimeMinutes = 20L,
        servings = 3L,
        difficulty = "Medium",
        cuisine = "Asian",
        caloriesPerServing = 250L,
        tags = listOf("Vegetarian", "Stir-fry", "Asian"),
        userId = 143L,
        image = "https://cdn.dummyjson.com/recipe-images/2.webp",
        rating = 4.7,
        reviewCount = 26L,
        mealType = listOf("Lunch")
    ),

    Recipe(
        id = 3L,
        name = "Chocolate Chip Cookies",
        ingredients = listOf(
            "All-purpose flour",
            "Butter, softened",
            "Brown sugar",
            "White sugar",
            "Eggs",
            "Vanilla extract",
            "Baking soda",
            "Salt",
            "Chocolate chips"
        ),
        instructions = listOf(
            "Preheat the oven to 350°F (175°C).",
            "In a bowl, cream together softened butter, brown sugar, and white sugar.",
            "Beat in eggs one at a time, then stir in vanilla extract.",
            "Combine flour, baking soda, and salt. Gradually add to the wet ingredients.",
            "Fold in chocolate chips.",
            "Drop rounded tablespoons of dough onto ungreased baking sheets.",
            "Bake for 10-12 minutes or until edges are golden brown.",
            "Allow cookies to cool on the baking sheet for a few minutes before transferring to a wire rack."
        ),
        prepTimeMinutes = 15L,
        cookTimeMinutes = 10L,
        servings = 24L,
        difficulty = "Easy",
        cuisine = "American",
        caloriesPerServing = 150L,
        tags = listOf("Cookies", "Dessert", "Baking"),
        userId = 34L,
        image = "https://cdn.dummyjson.com/recipe-images/3.webp",
        rating = 4.9,
        reviewCount = 13L,
        mealType = listOf("Snack", "Dessert")
    ),

    Recipe(
        id = 4L,
        name = "Chicken Alfredo Pasta",
        ingredients = listOf(
            "Fettuccine pasta",
            "Chicken breast, sliced",
            "Heavy cream",
            "Parmesan cheese, grated",
            "Garlic, minced",
            "Butter",
            "Salt and pepper to taste",
            "Fresh parsley for garnish"
        ),
        instructions = listOf(
            "Cook fettuccine pasta according to package instructions.",
            "In a pan, sauté sliced chicken in butter until fully cooked.",
            "Add minced garlic and cook until fragrant.",
            "Pour in heavy cream and grated Parmesan cheese. Stir until the cheese is melted.",
            "Season with salt and pepper to taste.",
            "Combine the Alfredo sauce with cooked pasta.",
            "Garnish with fresh parsley before serving."
        ),
        prepTimeMinutes = 15L,
        cookTimeMinutes = 20L,
        servings = 4L,
        difficulty = "Medium",
        cuisine = "Italian",
        caloriesPerServing = 500L,
        tags = listOf("Pasta", "Chicken"),
        userId = 136L,
        image = "https://cdn.dummyjson.com/recipe-images/4.webp",
        rating = 4.9,
        reviewCount = 82L,
        mealType = listOf("Lunch", "Dinner")
    ),

    Recipe(
        id = 5L,
        name = "Mango Salsa Chicken",
        ingredients = listOf(
            "Chicken thighs",
            "Mango, diced",
            "Red onion, finely chopped",
            "Cilantro, chopped",
            "Lime juice",
            "Jalapeño, minced",
            "Salt and pepper to taste",
            "Cooked rice for serving"
        ),
        instructions = listOf(
            "Season chicken thighs with salt and pepper.",
            "Grill or bake chicken until fully cooked.",
            "In a bowl, combine diced mango, chopped red onion, cilantro, minced jalapeño, and lime juice.",
            "Dice the cooked chicken and mix it with the mango salsa.",
            "Serve over cooked rice."
        ),
        prepTimeMinutes = 15L,
        cookTimeMinutes = 25L,
        servings = 3L,
        difficulty = "Easy",
        cuisine = "Mexican",
        caloriesPerServing = 380L,
        tags = listOf("Chicken", "Salsa"),
        userId = 26L,
        image = "https://cdn.dummyjson.com/recipe-images/5.webp",
        rating = 4.9,
        reviewCount = 63L,
        mealType = listOf("Dinner")
    ),

    Recipe(
        id = 6L,
        name = "Quinoa Salad with Avocado",
        ingredients = listOf(
            "Quinoa, cooked",
            "Avocado, diced",
            "Cherry tomatoes, halved",
            "Cucumber, diced",
            "Red bell pepper, diced",
            "Feta cheese, crumbled",
            "Lemon vinaigrette dressing",
            "Salt and pepper to taste"
        ),
        instructions = listOf(
            "In a large bowl, combine cooked quinoa, diced avocado, halved cherry tomatoes, diced cucumber, diced red bell pepper, and crumbled feta cheese.",
            "Drizzle with lemon vinaigrette dressing and toss to combine.",
            "Season with salt and pepper to taste.",
            "Chill in the refrigerator before serving."
        ),
        prepTimeMinutes = 20L,
        cookTimeMinutes = 15L,
        servings = 4L,
        difficulty = "Easy",
        cuisine = "Mediterranean",
        caloriesPerServing = 280L,
        tags = listOf("Salad", "Quinoa"),
        userId = 197L,
        image = "https://cdn.dummyjson.com/recipe-images/6.webp",
        rating = 4.4,
        reviewCount = 59L,
        mealType = listOf("Lunch", "Side Dish")
    ),

    Recipe(
        id = 7L,
        name = "Tomato Basil Bruschetta",
        ingredients = listOf(
            "Baguette, sliced",
            "Tomatoes, diced",
            "Fresh basil, chopped",
            "Garlic cloves, minced",
            "Balsamic glaze",
            "Olive oil",
            "Salt and pepper to taste"
        ),
        instructions = listOf(
            "Preheat the oven to 375°F (190°C).",
            "Place baguette slices on a baking sheet and toast in the oven until golden brown.",
            "In a bowl, combine diced tomatoes, chopped fresh basil, minced garlic, and a drizzle of olive oil.",
            "Season with salt and pepper to taste.",
            "Top each toasted baguette slice with the tomato-basil mixture.",
            "Drizzle with balsamic glaze before serving."
        ),
        prepTimeMinutes = 15L,
        cookTimeMinutes = 10L,
        servings = 6L,
        difficulty = "Easy",
        cuisine = "Italian",
        caloriesPerServing = 120L,
        tags = listOf("Bruschetta", "Italian"),
        userId = 137L,
        image = "https://cdn.dummyjson.com/recipe-images/7.webp",
        rating = 4.7,
        reviewCount = 95L,
        mealType = listOf("Appetizer")
    ),

    Recipe(
        id = 8L,
        name = "Beef and Broccoli Stir-Fry",
        ingredients = listOf(
            "Beef sirloin, thinly sliced",
            "Broccoli florets",
            "Soy sauce",
            "Oyster sauce",
            "Sesame oil",
            "Garlic, minced",
            "Ginger, minced",
            "Cornstarch",
            "Cooked white rice for serving"
        ),
        instructions = listOf(
            "In a bowl, mix soy sauce, oyster sauce, sesame oil, and cornstarch to create the sauce.",
            "In a wok, stir-fry thinly sliced beef until browned. Remove from the wok.",
            "Stir-fry broccoli florets, minced garlic, and minced ginger in the same wok.",
            "Add the cooked beef back to the wok and pour the sauce over the mixture.",
            "Stir until everything is coated and heated through.",
            "Serve over cooked white rice."
        ),
        prepTimeMinutes = 20L,
        cookTimeMinutes = 15L,
        servings = 4L,
        difficulty = "Medium",
        cuisine = "Asian",
        caloriesPerServing = 380L,
        tags = listOf("Beef", "Stir-fry", "Asian"),
        userId = 18L,
        image = "https://cdn.dummyjson.com/recipe-images/8.webp",
        rating = 4.7,
        reviewCount = 58L,
        mealType = listOf("Dinner")
    ),

    Recipe(
        id = 9L,
        name = "Caprese Salad",
        ingredients = listOf(
            "Tomatoes, sliced",
            "Fresh mozzarella cheese, sliced",
            "Fresh basil leaves",
            "Balsamic glaze",
            "Extra virgin olive oil",
            "Salt and pepper to taste"
        ),
        instructions = listOf(
            "Arrange alternating slices of tomatoes and fresh mozzarella on a serving platter.",
            "Tuck fresh basil leaves between the slices.",
            "Drizzle with balsamic glaze and extra virgin olive oil.",
            "Season with salt and pepper to taste.",
            "Serve immediately as a refreshing salad."
        ),
        prepTimeMinutes = 10L,
        cookTimeMinutes = 0L,
        servings = 2L,
        difficulty = "Easy",
        cuisine = "Italian",
        caloriesPerServing = 200L,
        tags = listOf("Salad", "Caprese"),
        userId = 128L,
        image = "https://cdn.dummyjson.com/recipe-images/9.webp",
        rating = 4.6,
        reviewCount = 82L,
        mealType = listOf("Lunch")
    ),

    Recipe(
        id = 10L,
        name = "Shrimp Scampi Pasta",
        ingredients = listOf(
            "Linguine pasta",
            "Shrimp, peeled and deveined",
            "Garlic, minced",
            "White wine",
            "Lemon juice",
            "Red pepper flakes",
            "Fresh parsley, chopped",
            "Salt and pepper to taste"
        ),
        instructions = listOf(
            "Cook linguine pasta according to package instructions.",
            "In a skillet, sauté minced garlic in olive oil until fragrant.",
            "Add shrimp and cook until pink and opaque.",
            "Pour in white wine and lemon juice. Simmer until the sauce slightly thickens.",
            "Season with red pepper flakes, salt, and pepper.",
            "Toss cooked linguine in the shrimp scampi sauce.",
            "Garnish with chopped fresh parsley before serving."
        ),
        prepTimeMinutes = 15L,
        cookTimeMinutes = 20L,
        servings = 3L,
        difficulty = "Medium",
        cuisine = "Italian",
        caloriesPerServing = 400L,
        tags = listOf("Pasta", "Shrimp"),
        userId = 114L,
        image = "https://cdn.dummyjson.com/recipe-images/10.webp",
        rating = 4.3,
        reviewCount = 5L,
        mealType = listOf("Dinner")
    )
)