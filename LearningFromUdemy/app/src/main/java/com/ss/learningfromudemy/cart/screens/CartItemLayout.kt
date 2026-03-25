package com.ss.learningfromudemy.cart.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import com.ss.learningfromudemy.home.models.Product

@Composable
fun CartItemLayout(product: Product, onProductDeleted: () -> Unit) {
    Card(

        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth().padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(product.image),
                "Product image",
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = product.name)
                Text(text = product.price.toString())
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = product.name, fontSize = 12.sp)
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(24.dp)
                ) {
                    Icon(
                       imageVector = Icons.Default.Delete,
                        contentDescription = "Delete product"
                    )
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCartItemLayout() {
    CartItemLayout(
        Product(
            id = "product_one",
            name = "Product 1",
            image = "https://codeskulptor-demos.commondatastorage.googleapis.com/pang/HfReHl5.jpg",
            categoryId = 0,
            price = 500.00,
            description = "This is product one"
        )
    ) {}

}