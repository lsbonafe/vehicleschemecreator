package com.anatideo.vehicleschemegenerator.presentation.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.anatideo.vehicleschemegenerator.presentation.composable.SlotUI
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anatideo.vehicleschemegenerator.core.data.mock.VehicleSchemeMock
import com.anatideo.vehicleschemegenerator.data.model.Level
import com.anatideo.vehicleschemegenerator.data.model.Slot

@Composable
fun LevelUI(
    level: Level,
    levelIndex: Int,
    modifier: Modifier = Modifier
) {
    // Build a Map<(row, col) → icon> once per level
    val iconByPosition: Map<Pair<Int, Int>, String> = remember(level) {
        level.slots.associate { slot ->
            when (slot) {
                is Slot.Seat    -> (slot.row to slot.column) to slot.icon
                is Slot.Element -> (slot.row to slot.column) to slot.icon
            }
        }
    }

    // Level header
    Column(modifier = modifier) {
        Text(
            text = "Level ${levelIndex.inc()} (Columns: ${level.columns}, Rows: ${level.rows})",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Column(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f))
                .padding(4.dp)
        ) {
            repeat(level.rows) { rowIndex ->
                Row {
                    repeat(level.columns) { colIndex ->
                        val cellIcon = iconByPosition[rowIndex to colIndex].orEmpty()
                        SlotUI(slotIcon = cellIcon)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun levelUIPreview() {
    LevelUI(
        level = VehicleSchemeMock.mockBus().decks[0].levels[0],
        levelIndex = 0
    )
}
