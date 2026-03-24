package com.ss.learningfromudemy.home.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DiscountBadge(discountPrice: Int, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.clip(RoundedCornerShape(4.dp))
        .background(Color(0xFFE91e63)))
    {
     Text (text = "$discountPrice% Off",
         modifier = modifier.padding(
             horizontal = 8.dp,
             vertical = 2.dp
         ),
         color = Color.White,
         fontWeight = FontWeight.Bold
     )

    }
}