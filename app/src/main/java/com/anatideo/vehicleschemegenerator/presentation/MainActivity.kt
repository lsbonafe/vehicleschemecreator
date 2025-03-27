package com.anatideo.vehicleschemegenerator.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.anatideo.vehicleschemegenerator.data.GetVehicleSchemeRepositoryImpl
import com.anatideo.vehicleschemegenerator.data.datasource.mock.VehicleSchemeMockDataSourceImpl
import com.anatideo.vehicleschemegenerator.data.model.Slot
import com.google.gson.GsonBuilder

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        printVehicleSchemeArt()
    }

    fun printVehicleSchemeArt() {
        val vehicleSchemeMockDataSourceImpl = VehicleSchemeMockDataSourceImpl(
            assetManager = assets,
            gsonBuilder = GsonBuilder()
        )
        val repository = GetVehicleSchemeRepositoryImpl(vehicleSchemeMockDataSourceImpl)
        val vehicleScheme = repository.getVehicleScheme()

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