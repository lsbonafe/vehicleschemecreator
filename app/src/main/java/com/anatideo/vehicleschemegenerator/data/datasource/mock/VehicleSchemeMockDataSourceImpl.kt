package com.anatideo.vehicleschemegenerator.data.datasource.mock

import android.content.res.AssetManager
import androidx.annotation.VisibleForTesting
import com.anatideo.vehicleschemegenerator.data.datasource.VehicleSchemeDataSource
import com.anatideo.vehicleschemegenerator.data.model.Slot
import com.anatideo.vehicleschemegenerator.data.model.VehicleScheme
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type

class VehicleSchemeMockDataSourceImpl(
    private val gsonBuilder: GsonBuilder,
    private val assetManager: AssetManager
) : VehicleSchemeDataSource {
    override fun getVehicleScheme(): VehicleScheme {
        val gson = gsonBuilder
            .registerTypeAdapter(Slot::class.java, SlotDeserializer())
            .create()

//        return readJsonFromAssets("rocket_scheme_mock.json")
//        return readJsonFromAssets("submarine_scheme_mock.json")
        return readJsonFromAssets("bus_scheme_mock.json")
            .let { gson.fromJson(it, VehicleScheme::class.java) }
    }

    @VisibleForTesting
    fun readJsonFromAssets(fileName: String): String {
        return assetManager.open(fileName).bufferedReader().use { it.readText() }
    }

    @VisibleForTesting
    class SlotDeserializer : JsonDeserializer<Slot> {
        override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Slot? {
            val jsonObject = json?.asJsonObject ?: throw JsonParseException("Json is null")
            val type = jsonObject.get("type").asString

            return when (type) {
                "seat" -> context?.deserialize(json, Slot.Seat::class.java)
                "element" -> context?.deserialize(json, Slot.Element::class.java)
                else -> throw JsonParseException("Unknown type: $type")
            }
        }
    }
}