package com.ss.learningfromudemy.home.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(){
    var selectedRoute by rememberSaveable { mutableStateOf("Home") }

    val items = listOf(
        BottomNavItem("Home", Icons.Default.Home, route = selectedRoute),
        BottomNavItem("Categories", Icons.Default.Search),
        BottomNavItem(title = "Wishlist", icon = Icons.Default.Favorite, route = "Favourite", 5),
        BottomNavItem(title = "Cart", icon = Icons.Default.ShoppingCart, route = "Cart", 3),
        BottomNavItem(title ="Profile", icon = Icons.Default.Person, route = "Profile")
    )

    NavigationBar(
        modifier = Modifier.height(120.dp),
        containerColor = Color.White,
        contentColor = Color.Black,
        tonalElevation = 8.dp
    ){
        items.forEach { item ->
           NavigationBarItem(
                selected = item.route == selectedRoute,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    selectedTextColor = Color.Black,
                    indicatorColor = Color.White,

                ),
                onClick = { /*TODO*/ },
                icon = {
                    if (item.badgeCount > 0){
                        BadgedBox(badge = {
                            Badge(containerColor = Color.Red,
                                contentColor = Color.White) {
                                Text(text = item.badgeCount.toString())
                            }
                        }) {
                            Icon(imageVector = item.icon,
                                contentDescription = item.title)
                        }
                    }else{
                        Icon(imageVector = item.icon,
                            contentDescription = item.title)
                    }

                },
               label = {Text(item.title)}
            )

        }
    }
}

data class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String = "",
    val badgeCount: Int = 0
)