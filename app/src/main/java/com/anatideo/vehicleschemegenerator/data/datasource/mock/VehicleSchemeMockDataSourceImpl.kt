package com.anatideo.vehicleschemegenerator.data.datasource.mock

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.anatideo.vehicleschemegenerator.data.datasource.VehicleSchemeDataSource
import com.anatideo.vehicleschemegenerator.data.model.Slot
import com.anatideo.vehicleschemegenerator.data.model.VehicleScheme
import com.squareup.moshi.Moshi.Builder
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

class VehicleSchemeMockDataSourceImpl(
    private val moshiBuilder: Builder,
    private val context: Context
) : VehicleSchemeDataSource {
    override fun getVehicleScheme(): VehicleScheme? {
        val moshi = moshiBuilder.add(
            PolymorphicJsonAdapterFactory.of(Slot::class.java, "type")
                .withSubtype(Slot.Seat::class.java, "seat")
                .withSubtype(Slot.Element::class.java, "element")
        ).build()

        return moshi
            .adapter(VehicleScheme::class.java)
            .fromJson(readJsonFromAssets(context, "bus_scheme_mock.json"))
    }

    @VisibleForTesting
    fun readJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }
}