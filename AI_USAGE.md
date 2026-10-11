# AI Usage

## SIS 3
- I used **ChatGPT** as an assistant for learning Jetpack Compose, debugging Kotlin code, and improving my app architecture.  
- I mainly used it to understand ViewModels, StateFlow, Navigation, reusable composables, and Compose UI patterns.  
- My three most useful prompts were: **"how to get recipeId arg in viewModel"**, **"how to make composable optional"**, and **"every time i click on single nav bar item several times it rerenders"**.  
- One time, AI incorrectly suggested using a **Scaffold inside another Scaffold** to structure the app layout.  
- I noticed this was unnecessary because the app already had a parent Scaffold responsible for the top and bottom bars, and nested Scaffolds made the layout and padding harder to manage.  
- I fixed it by keeping a single main Scaffold and letting individual screens manage their own content and scrolling.  
- I wrote everything by hand, referring to android documentation and training codelabs.  
- I used AI mainly for explanations, debugging suggestions, and guidance.

## SIS 4
- I used **ChatGPT** to debug kotlin code.
- I mainly used it to understand repository-based filtering, ViewModel lifecycle, coroutine flows, and search state management.
- My three most useful prompts were: **"in the future, when i will have just 1 function to filter recipes based on query params, what would change in my view model?"**, **"doesnt show debug message"**.
- I used AI to understand why `onCleared()` might not execute when navigating between screens.
- I also explored how to simplify my ViewModel when recipe filtering is handled by a single repository function.
- I wrote the code myself and used AI mainly for explanations, debugging suggestions, and architectural guidance.
- AI initially had recipe filtering logic inside the ViewModel instead of delegating it to the repository. I planned to move filtering to the repository/API and keep the ViewModel responsible for search inputs and UI state.