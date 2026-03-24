package com.ss.learningfromudemy.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil3.compose.rememberAsyncImagePainter
import com.ss.learningfromudemy.home.models.Product
import com.ss.learningfromudemy.ui.theme.PrimaryColor

@Composable
fun FeaturedProductCard(product: Product, onProductClick: () -> Unit) {
    Card(
        onClick = onProductClick,
        modifier = Modifier.width(280.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box {
            DiscountBadge(
                discountPrice = 5,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
                    .zIndex(2f)
            )
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .zIndex(1f)
        ) {
            Image(
                painter = rememberAsyncImagePainter(product.image),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit,
                contentDescription = "Product Image",
                colorFilter = ColorFilter.tint(Color.White)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "$${product.price}",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Row(horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = PrimaryColor,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(Modifier.width(4.dp))

                    Text(text = product.id, style = MaterialTheme.typography.bodySmall)
                }
            }

        }

    }
}