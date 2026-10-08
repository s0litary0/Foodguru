package com.example.foodguru.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.foodguru.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchBar(
    modifier: Modifier = Modifier,
    textFieldState: TextFieldState = rememberTextFieldState(
        initialText = ""
    ),
    placeholder: String? = null,
    onSearch: (String) -> Unit = {},
    searchResults: List<String>
) {
    var expanded by rememberSaveable { mutableStateOf(false)}

    SearchBar(
        modifier = modifier,
        inputField = {
            SearchBarDefaults.InputField(
                query = textFieldState.text.toString(),
                onQueryChange = {
                    textFieldState.edit {
                        replace(0, length, it)
                    }
                },
                onSearch = {
                    onSearch(textFieldState.text.toString())
                    expanded = false

                },
                expanded = expanded,
                onExpandedChange = { newValue -> expanded = newValue},
                placeholder = placeholder?.let { { Text(placeholder) } },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            onSearch(textFieldState.text.toString())
                            expanded = false
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.search_24px),
                            contentDescription = stringResource(R.string.search)
                        )
                    }
                }
            )
        },
        expanded = expanded,
        onExpandedChange = { newValue -> expanded = newValue}
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            searchResults.forEach { result ->
                ListItem(
                    headlineContent = { Text(result) },
                    modifier = Modifier
                        .clickable {
                            textFieldState.edit {
                                replace(0, length, result)
                            }
                        }
                        .fillMaxWidth()
                )
            }
        }
    }
}

//
//class AppSearchBarState(
//    val initialText: String
//) {
//    var text by mutableStateOf(initialText)
//        private set
//
//    fun updateText(newText: String) {
//        text = newText
//    }
//
//    companion object {
//        val Saver: Saver<AppSearchBarState, *> = listSaver(
//            save = { state -> listOf(state.initialText) },
//            restore = { stateList ->
//                AppSearchBarState(
//                    initialText = stateList[0]
//                )
//            }
//        )
//    }
//}
//
//
//@Composable
//fun rememberAppSearchBarState(initialText: String) : AppSearchBarState =
//    rememberSaveable(initialText, saver = AppSearchBarState.Saver) {
//        AppSearchBarState(initialText = "")
//    }
