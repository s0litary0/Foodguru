# AI Usage

- I used **ChatGPT** as an assistant for learning Jetpack Compose, debugging Kotlin code, and improving my app architecture.  
- I mainly used it to understand ViewModels, StateFlow, Navigation, reusable composables, and Compose UI patterns.  
- My three most useful prompts were: **"how to get recipeId arg in viewModel"**, **"how to make composable optional"**, and **"every time i click on single nav bar item several times it rerenders"**.  
- One time, AI incorrectly suggested using a **Scaffold inside another Scaffold** to structure the app layout.  
- I noticed this was unnecessary because the app already had a parent Scaffold responsible for the top and bottom bars, and nested Scaffolds made the layout and padding harder to manage.  
- I fixed it by keeping a single main Scaffold and letting individual screens manage their own content and scrolling.  
- I wrote everything by hand, referring to android documentation and training codelabs.  
- I used AI mainly for explanations, debugging suggestions, and guidance.