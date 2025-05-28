package com.anatideo.vehicleschemegenerator.presentation.composable

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.anatideo.vehicleschemegenerator.data.model.VehicleScheme

@Composable
fun VehicleSchemeUI(
    vehicleScheme: VehicleScheme,
    modifier: Modifier = Modifier
) {
    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        VehicleContentUI(vehicleScheme)
    }
}
