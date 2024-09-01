package com.anatideo.vehicleschemegenerator.data.model

data class VehicleScheme(
    val vehicleType: String,
    val decks: List<Deck>
)

data class Deck(
    val baseDeckLevel: Int,
    val levels: List<Level>
)

data class Level(
    val columns: Int,
    val rows: Int,
    val slots: List<Slot>
)

sealed class Slot {
    data class Seat(
        val row: Int,
        val column: Int,
        val seatInfo: String?,
        val isTaken: Boolean,
        val category: String?,
        val color: String,
        val icon: String
    ) : Slot()

    data class Element(
        val row: Int,
        val column: Int,
        val contentDescription: String,
        val icon: String
    ) : Slot()
}