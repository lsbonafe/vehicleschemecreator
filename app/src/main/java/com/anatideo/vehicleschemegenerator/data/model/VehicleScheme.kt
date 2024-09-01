package com.anatideo.vehicleschemegenerator.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VehicleScheme(
    @Json(name = "vehicleType") val vehicleType: String,
    @Json(name = "decks") val decks: List<Deck>
)

@JsonClass(generateAdapter = true)
data class Deck(
    @Json(name = "baseDeckLevel") val baseDeckLevel: Int,
    @Json(name = "levels") val levels: List<Level>
)

@JsonClass(generateAdapter = true)
data class Level(
    @Json(name = "columns") val columns: Int,
    @Json(name = "rows") val rows: Int,
    @Json(name = "slots") val slots: List<Slot>
)

sealed class Slot {
    @JsonClass(generateAdapter = true)
    data class Seat(
        @Json(name = "row") val row: Int,
        @Json(name = "column") val column: Int,
        @Json(name = "seatInfo") val seatInfo: String?,
        @Json(name = "isTaken") val isTaken: Boolean,
        @Json(name = "category") val category: String?,
        @Json(name = "color") val color: String,
        @Json(name = "icon") val icon: String
    ) : Slot()

    @JsonClass(generateAdapter = true)
    data class Element(
        @Json(name = "row") val row: Int,
        @Json(name = "column") val column: Int,
        @Json(name = "contentDescription") val contentDescription: String,
        @Json(name = "icon") val icon: String
    ) : Slot()
}