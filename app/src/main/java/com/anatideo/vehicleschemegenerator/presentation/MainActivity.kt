package com.anatideo.vehicleschemegenerator.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.anatideo.vehicleschemegenerator.R
import com.anatideo.vehicleschemegenerator.data.GetVehicleSchemeRepositoryImpl
import com.anatideo.vehicleschemegenerator.data.datasource.mock.VehicleSchemeMockDataSourceImpl
import com.anatideo.vehicleschemegenerator.data.model.VehicleScheme
import com.anatideo.vehicleschemegenerator.core.ui.theme.AppTheme
import com.anatideo.vehicleschemegenerator.data.model.Slot
import com.anatideo.vehicleschemegenerator.presentation.composable.VehicleSchemeUI
import com.anatideo.vehicleschemegenerator.presentation.composable.VehicleScheme3DUI
import com.google.gson.GsonBuilder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vehicleScheme = getData()
        printVehicleSchemeTextArt(vehicleScheme)

        setContent {
            AppTheme {
                VehicleSchemeApp(vehicleScheme)
            }
        }
    }

    private fun getData(): VehicleScheme {
        val vehicleSchemeMockDataSourceImpl = VehicleSchemeMockDataSourceImpl(
            assetManager = assets,
            gsonBuilder = GsonBuilder()
        )
        val repository = GetVehicleSchemeRepositoryImpl(vehicleSchemeMockDataSourceImpl)
        return repository.getVehicleScheme()
    }

    // todo for testing
    private fun printVehicleSchemeTextArt(vehicleScheme: VehicleScheme) {
        Log.d("VehicleScheme", "Vehicle Type: ${vehicleScheme.vehicleType}")

        vehicleScheme.decks.forEachIndexed { deckIndex, deck ->
            Log.d("VehicleScheme", "Deck ${deckIndex + 1} (Base Deck Level: ${deck.baseDeckLevel})")

            deck.levels.forEachIndexed { levelIndex, level ->
                Log.d("VehicleScheme", "  Level ${levelIndex + 1} (Columns: ${level.columns}, Rows: ${level.rows})")

                val grid = Array(level.rows) { Array(level.columns) { " " } }

                level.slots.forEach { slot ->
                    when (slot) {
                        is Slot.Seat -> {
                            grid[slot.row][slot.column] = slot.icon
                        }
                        is Slot.Element -> {
                            grid[slot.row][slot.column] = slot.icon
                        }
                    }
                }

                grid.forEach { row ->
                    Log.d("VehicleScheme", "    " + row.joinToString(" "))
                }

                Log.d("VehicleScheme", "") // Add a space between levels for clarity
            }

            Log.d("VehicleScheme", "") // Add a space between decks for clarity
        }
    }
}

@Composable
private fun VehicleSchemeApp(vehicleScheme: VehicleScheme) {
    var show3D = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_name)) },
                actions = {
                    val label = if (show3D.value) R.string.view_2d else R.string.view_3d
                    TextButton(onClick = { show3D.value = !show3D.value }) {
                        Text(stringResource(id = label))
                    }
                }
            )
        }
    ) { padding ->
        val modifier = Modifier
            .fillMaxSize()
            .padding(padding)

        if (show3D.value) {
            VehicleScheme3DUI(vehicleScheme, modifier)
        } else {
            VehicleSchemeUI(vehicleScheme, modifier)
        }
    }
}