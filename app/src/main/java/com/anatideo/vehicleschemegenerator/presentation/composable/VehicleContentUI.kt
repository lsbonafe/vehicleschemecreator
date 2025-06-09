package com.anatideo.vehicleschemegenerator.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anatideo.vehicleschemegenerator.core.data.mock.VehicleSchemeMock
import com.anatideo.vehicleschemegenerator.data.model.VehicleScheme

@Composable
fun VehicleContentUI(vehicleScheme: VehicleScheme) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Vehicle header
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
}

@Preview
@Composable
fun vehicleContentUIPreview() {
    VehicleContentUI(VehicleSchemeMock.mockCar())
}

