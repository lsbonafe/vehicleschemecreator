package com.anatideo.vehicleschemegenerator.presentation.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anatideo.vehicleschemegenerator.data.model.Deck

@Composable
fun DeckUI(
    deck: Deck,
    deckIndex: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // Deck header
        Text(
            text = "Deck ${deckIndex.inc()} (Base Deck Level: ${deck.baseDeckLevel})",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Levels
        deck.levels.forEachIndexed { levelIndex, level ->
            LevelUI(
                level = level,
                levelIndex = levelIndex,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun deckUIPreview() {
    DeckUI(
        deck = VehicleSchemeMock.mockBus().decks[0],
        deckIndex = 0
    )
}
