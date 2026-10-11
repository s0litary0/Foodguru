package com.example.foodguru.ui.features.search

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.foodguru.FoodguruApplication
import com.example.foodguru.data.RecipeRepository
import com.example.foodguru.data.source.network.NetworkRecipe
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds


class SearchViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    val textFieldState = TextFieldState()
    private val _recipes = MutableStateFlow<List<NetworkRecipe>>(emptyList())
    private val _tags = MutableStateFlow<List<Tag>>(emptyList())
    private val _selectedTags = MutableStateFlow<List<Tag>>(emptyList())
    private val _isLoaded = MutableStateFlow<Boolean>(false)
    private val _uiState = MutableStateFlow<SearchUiState>(SearchUiState.Loading)
    val uiState = _uiState.asStateFlow()

    @OptIn(FlowPreview::class)
    private val _debouncedQuery = snapshotFlow { textFieldState.text.toString().trim() }
        .debounce(300.milliseconds)
        .distinctUntilChanged()

    init {
        getRecipesAndTags()
        observeSearch()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val recipeRepository = (this[APPLICATION_KEY] as FoodguruApplication).recipeRepository
                SearchViewModel(
                    recipeRepository = recipeRepository
                )
            }
        }
    }

    private fun getRecipesAndTags() {
        viewModelScope.launch {
            _uiState.update { SearchUiState.Loading }
            try {
                coroutineScope {
                    val recipesDeferred = async {
                        recipeRepository.getRecipes()
                    }
                    val tagsDeferred = async {
                        recipeRepository.getTags()
                    }
                    val recipes = recipesDeferred.await()
                    val tags = tagsDeferred.await()

                    _recipes.value = recipes
                    _tags.value = tags
                    _isLoaded.value = true
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.update { SearchUiState.Error(message = e.message) }
            }
        }
    }


    private fun observeSearch() {
        viewModelScope.launch {
            combine(
                _recipes,
                _debouncedQuery,
                _selectedTags,
                _isLoaded
            ) { recipes, query, selectedTags, isLoaded ->

                if (!isLoaded) {
                    return@combine SearchUiState.Loading
                }

                val filteredRecipes = recipes.filter { recipe ->
                    val matchesQuery =
                        query.isEmpty() ||
                        recipe.name.contains(query, ignoreCase = true)
                    val matchesTags =
                        selectedTags.isEmpty() ||
                        selectedTags.all { tag -> tag.label in recipe.tags}

                    matchesQuery && matchesTags
                }

                SearchUiState.Success(
                    recipes = filteredRecipes,
                    tags = _tags.value,
                    selectedTags = selectedTags,
                    searchResults = filteredRecipes.map { recipe -> recipe.name }
                )
            }.collect { state ->
                _uiState.update { state }
            }

        }
    }

    fun toggleTag(tag: Tag) {
       _selectedTags.update { selected ->
           if (tag in selected) selected - tag else selected + tag
       }
    }

    fun onSearch(query: String): Unit {
        if (query.trim().isEmpty()) {
            return
        }
        textFieldState.edit { replace(0, length, query.trim()) }
    }
}