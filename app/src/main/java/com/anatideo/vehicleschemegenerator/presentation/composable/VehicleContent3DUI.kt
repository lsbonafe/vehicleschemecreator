package com.anatideo.vehicleschemegenerator.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun VehicleContent3DUI(vehicleScheme: VehicleScheme) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Vehicle Type: ${'$'}{vehicleScheme.vehicleType}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

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
fun vehicleContent3DUIPreview() {
    VehicleContent3DUI(VehicleSchemeMock.mockCar())
}
