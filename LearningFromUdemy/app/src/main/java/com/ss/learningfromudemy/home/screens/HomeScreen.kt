package com.ss.learningfromudemy.home.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun showPreview(){
    HomeScreen()
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).background(Color.White)) {
            val searchQuery = rememberSaveable { mutableStateOf("") }
            val focusManager = LocalFocusManager.current
            SearchBar(
                query = searchQuery.value,
                onQueryChange = { searchQuery.value = it },
                onSearch = { focusManager.clearFocus() },
                modifier = Modifier.fillMaxWidth().padding(12.dp)

            )

            SectionTitle("Categories", "See all") {
                // TODO() - Add navigation
            }
            Spacer(modifier = Modifier.height(10.dp))

            SectionTitle("Featured", "See all") {
                // TODO() - Add navigation
            }

            CategoryChip(
                "Android",
                "https://cdn-icons-png.flaticon.com/512/5968/5968864.png", true
            ) {}
        }

    }
}
