package com.anatideo.vehicleschemegenerator.presentation.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SlotUI(
    slotIcon: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(42.dp)
            .border(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = slotIcon,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontFamily = FontFamily.Monospace
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun slotUIPreview() {
    SlotUI(slotIcon = "🪑")
}
