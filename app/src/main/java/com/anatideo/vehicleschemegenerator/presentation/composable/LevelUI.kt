package com.anatideo.vehicleschemegenerator.presentation.composable

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.anatideo.vehicleschemegenerator.data.model.Level
import com.anatideo.vehicleschemegenerator.data.model.Slot

@Composable
fun LevelUI(
    level: Level,
    levelIndex: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // Level header
        Text(
            text = "Level ${levelIndex + 1} (Columns: ${level.columns}, Rows: ${level.rows})",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Grid visualization
        val grid = remember(level) {
            Array(level.rows) { Array(level.columns) { " " } }.apply {
                level.slots.forEach { slot ->
                    when (slot) {
                        is Slot.Seat -> this[slot.row][slot.column] = slot.icon
                        is Slot.Element -> this[slot.row][slot.column] = slot.icon
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f))
                .padding(4.dp)
        ) {
            grid.forEach { row ->
                Row {
                    row.forEach { cell ->
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .border(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = cell,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontFamily = FontFamily.Monospace
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
