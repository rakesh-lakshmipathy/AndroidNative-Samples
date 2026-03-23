package com.ss.learningfromudemy.home.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss.learningfromudemy.ui.theme.PrimaryColor


@Composable
fun SectionTitle (title: String, actionLabel: String, onAction: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = title, style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold
        ))
        TextButton(onClick = onAction) {
            Text(text = actionLabel,
                color = PrimaryColor
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun showSectionTitlePreview(){
    SectionTitle(title = "Section Title", actionLabel = "Action Label", onAction = {})

}