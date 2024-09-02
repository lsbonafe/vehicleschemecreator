package com.anatideo.vehicleschemegenerator.presentation

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.anatideo.vehicleschemegenerator.R
import com.anatideo.vehicleschemegenerator.data.GetVehicleSchemeRepositoryImpl
import com.anatideo.vehicleschemegenerator.data.datasource.mock.VehicleSchemeMockDataSourceImpl
import com.anatideo.vehicleschemegenerator.data.model.Slot
import com.anatideo.vehicleschemegenerator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }

        // TODO temp
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}