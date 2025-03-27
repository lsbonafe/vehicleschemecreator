package com.anatideo.vehicleschemegenerator.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anatideo.vehicleschemegenerator.data.GetVehicleSchemeRepositoryImpl
import com.anatideo.vehicleschemegenerator.data.datasource.mock.VehicleSchemeMockDataSourceImpl
import com.anatideo.vehicleschemegenerator.data.model.Deck
import com.anatideo.vehicleschemegenerator.data.model.Level
import com.anatideo.vehicleschemegenerator.data.model.Slot
import com.anatideo.vehicleschemegenerator.data.model.VehicleScheme
import com.anatideo.vehicleschemegenerator.presentation.composable.theme.AppTheme
import com.google.gson.GsonBuilder

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vehicleScheme = getData()
        printVehicleSchemeTextArt(vehicleScheme)

        setContent {
            AppTheme {
                MyApp(vehicleScheme, modifier = Modifier.fillMaxSize())
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

    @Composable
    fun MyApp(
        vehicleScheme: VehicleScheme,
        modifier: Modifier = Modifier
    ) {
        Surface(modifier, color = MaterialTheme.colorScheme.background) {
            VehicleSchemeUI(vehicleScheme)
        }
    }

    @Composable
    fun VehicleSchemeUI(vehicleScheme: VehicleScheme) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Vehicle Type header
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

    @Composable
    private fun DeckUI(
        deck: Deck,
        deckIndex: Int,
        modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier) {
            // Deck header
            Text(
                text = "Deck ${deckIndex + 1} (Base Deck Level: ${deck.baseDeckLevel})",
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

    @Composable
    private fun LevelUI(
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

    @Preview(showBackground = true, widthDp = 320)
    @Composable
    fun GreetingPreview() {
        AppTheme {
//            Greeting()
        }
    }
}