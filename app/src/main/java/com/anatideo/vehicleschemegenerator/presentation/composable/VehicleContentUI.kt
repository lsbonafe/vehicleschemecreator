package com.anatideo.vehicleschemegenerator.presentation.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anatideo.vehicleschemegenerator.data.model.VehicleScheme

@Composable
fun VehicleContentUI(vehicleScheme: VehicleScheme) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Vehicle Type header2
        Text(
            text = "Vehicle Type: ${vehicleScheme.vehicleType}",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Decks
        vehicleScheme.decks.forEachIndexed { deckIndex, deck ->
            DeckUI(
                deck = deck,
                deckIndex = deckIndex,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }
    }
}
