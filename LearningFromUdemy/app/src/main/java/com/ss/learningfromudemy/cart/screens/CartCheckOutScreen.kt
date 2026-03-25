package com.ss.learningfromudemy.cart.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss.learningfromudemy.home.models.Product

@Preview(showBackground = true)
@Composable
fun PreviewCartCheckOutScreen() {
    CartCheckOutScreen(listOf(Product(
        id = "product_one",
        name = "Product 1",
        image = "https://codeskulptor-demos.commondatastorage.googleapis.com/pang/HfReHl5.jpg",
        description = "This is product one",
        price = 500.04,
        categoryId = 0
    ))
    ) {}
}

@Composable
fun CartCheckOutScreen(products: List<Product>, onProductDeleted: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(
            text = "Cart CheckOut Screen",
            style = MaterialTheme.typography.titleLarge.copy(
                color = Color.Black
            )
        )

        if (products.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Your cart is empty")
                Button(onClick = {}) { Text("Continue Shopping") }
            }

        } else {
            LazyColumn(modifier= Modifier.weight(1f)){
              items(products){product->
                  CartItemLayout(product) { }
              }
            }
        }

        Column{
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Total Price")
                Text(text = "500 Rs")
            }
            Button(onClick = {}, modifier= Modifier.fillMaxWidth().padding(horizontal = 16.dp)) { Text("Checkout option") }

        }
    }
}




