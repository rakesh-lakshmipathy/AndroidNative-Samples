package com.ss.learningfromudemy.home.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.ss.learningfromudemy.home.models.Category
import com.ss.learningfromudemy.home.models.Product
import com.ss.learningfromudemy.home.screens.CategoryChip

@Preview(showBackground = true)
@Composable
fun ShowPreview() {
    HomeScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() }
    ) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White)) {
            val searchQuery = rememberSaveable { mutableStateOf("") }
            val focusManager = LocalFocusManager.current
            val categories = listOf(
                Category(
                    id = 0, name = "Garden",
                    image = "https://cdn-icons-png.flaticon.com/512/5968/5968864.png",
                    description = "This is a garden"
                ),
                Category(
                    id = 1,
                    name = "Electronics",
                    image = "https://cdn-icons-png.flaticon.com/512/5968/5968864.png",
                    description = "This is a electronics"
                ),
                Category(
                    id = 2,
                    name = "Home",
                    image = "https://cdn-icons-png.flaticon.com/512/5968/5968864.png",
                    description = "This is a home products"
                ),
                Category(
                    id = 3,
                    name = "Cloth",
                    image = "https://cdn-icons-png.flaticon.com/512/5968/5968864.png",
                    description = "This is a Clothes"
                )
            )

            val products = listOf(
                Product(
                    id = "product_one",
                    name = "Product 1",
                    image = "https://cdn-icons-png.flaticon.com/512/5968/5968864.png",
                    description = "This is product one",
                    price = 500.04,
                    categoryId = 0
                ),
                Product(
                    id = "product_two",
                    name = "Product 2",
                    image = "https://cdn-icons-png.flaticon.com/512/5968/5968864.png",
                    description = "This is product two",
                    price = 700.00,
                    categoryId = 1
                ),
                Product(
                    id = "product_three",
                    name = "Product 3",
                    image = "https://cdn-icons-png.flaticon.com/512/5968/5968864.png",
                    description = "This is product three",
                    price = 600.04,
                    categoryId = 2
                ),
                Product(
                    id = "product_four",
                    name = "Product 4",
                    image = "https://cdn-icons-png.flaticon.com/512/5968/5968864.png",
                    description = "This is product four",
                    price = 999.00,
                    categoryId = 3
                )
            )

            SearchBar(
                query = searchQuery.value,
                onQueryChange = { searchQuery.value = it },
                onSearch = { focusManager.clearFocus() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)

            )

            SectionTitle("Categories", "See all") {
                // TODO() - Add navigation
            }
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(categories) { category ->
                    CategoryChip(category.name, category.image, true) {
                        // TODO() - Handle onClick()
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(products) {
                    FeaturedProductCard(it) { }
                }
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
