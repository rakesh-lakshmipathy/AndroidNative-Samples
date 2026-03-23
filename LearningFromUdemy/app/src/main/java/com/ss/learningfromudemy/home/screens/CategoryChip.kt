package com.ss.learningfromudemy.home.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.ss.learningfromudemy.ui.theme.CategoryChipColor

@Composable
fun CategoryChip(category: String, icon: String, isSelected: Boolean = false, onClick: () -> Unit){
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) CategoryChipColor
            else Color.LightGray.copy(alpha = 0.1f),
    ),
        border = BorderStroke(width = if (isSelected)0.dp else 1.dp,
            color = Color.LightGray.copy(alpha = 0.3f))
    ){
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Icon(painter = rememberAsyncImagePainter(icon), contentDescription = "Category Icon")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = category, color = if (isSelected) Color.White
            else Color.Black)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun previewCategoryChip(){
    CategoryChip("Android", "https://cdn-icons-png.flaticon.com/512/5968/5968864.png", true) {}
}