package com.ss.learningfromudemy.home.screens

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    val context = LocalContext.current

    TopAppBar(
        title = { Text(text ="Home" , style = MaterialTheme.typography.titleLarge)},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF1565C0),
            titleContentColor = Color.White
        ),

        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Selected Shopping cart", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Cart",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "Selected Profile", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile",
                    tint = Color.White
                )
            }
        }

    )
}
