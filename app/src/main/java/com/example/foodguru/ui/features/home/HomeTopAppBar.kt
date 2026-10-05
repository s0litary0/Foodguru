package com.example.foodguru.ui.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.foodguru.R
import com.example.foodguru.ui.components.AppSearchBar


@Composable
fun HomeTopAppBar(
    textFieldState: TextFieldState,
    onSearch: () -> Unit,
    searchResults: List<String>,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        AppSearchBar(
            textFieldState = textFieldState,
            onSearch = { text -> onSearch() },
            searchResults = searchResults,
            modifier = Modifier.weight(1f)
        )
        IconButton(
            modifier = Modifier.size(48.dp),
            onClick = {}
        ) {
            Icon(
                painter = painterResource(R.drawable.settings_32px),
                contentDescription = stringResource(R.string.settings)
            )
        }
    }
}