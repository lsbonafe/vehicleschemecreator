package com.anatideo.vehicleschemegenerator.data.model

import com.google.gson.annotations.SerializedName

data class VehicleScheme(
    @SerializedName("vehicleType") val vehicleType: String,
    @SerializedName("decks") val decks: List<Deck>
)

data class Deck(
    @SerializedName("baseDeckLevel") val baseDeckLevel: Int,
    @SerializedName("levels") val levels: List<Level>
)

data class Level(
    @SerializedName("columns") val columns: Int,
    @SerializedName("rows") val rows: Int,
    @SerializedName("slots") val slots: List<Slot>
)

sealed class Slot {
    data class Seat(
        @SerializedName("type") val type: String,
        @SerializedName("row") val row: Int,
        @SerializedName("column") val column: Int,
        @SerializedName("seatInfo") val seatInfo: String?,
        @SerializedName("isTaken") val isTaken: Boolean,
        @SerializedName("category") val category: String?,
        @SerializedName("color") val color: String,
        @SerializedName("icon") val icon: String,
        @SerializedName("price") val price: Double?
    ) : Slot()

    data class Element(
        @SerializedName("type") val type: String,
        @SerializedName("row") val row: Int,
        @SerializedName("column") val column: Int,
        @SerializedName("contentDescription") val contentDescription: String,
        @SerializedName("icon") val icon: String
    ) : Slot()
}