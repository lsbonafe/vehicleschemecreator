package com.anatideo.vehicleschemegenerator.core.data.mock

import com.anatideo.vehicleschemegenerator.data.model.Deck
import com.anatideo.vehicleschemegenerator.data.model.Level
import com.anatideo.vehicleschemegenerator.data.model.Slot
import com.anatideo.vehicleschemegenerator.data.model.VehicleScheme

object VehicleSchemeMock {
    fun mockCar(): VehicleScheme {
        return VehicleScheme(
            vehicleType = "car",
            decks = listOf(
                Deck(
                    baseDeckLevel = 0,
                    levels = listOf(
                        Level(
                            columns = 3,
                            rows = 2,
                            slots = listOf(
                                Slot.Element(
                                    type = "element",
                                    row = 0,
                                    column = 0,
                                    contentDescription = "Wheel",
                                    icon = "⚙️"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 0,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 0,
                                    column = 2,
                                    seatInfo = "Passenger",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#000000",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 1,
                                    column = 0,
                                    seatInfo = "Rear Left",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#000000",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 1,
                                    column = 1,
                                    seatInfo = "Rear Center",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#000000",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 1,
                                    column = 2,
                                    seatInfo = "Rear Right",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#000000",
                                    icon = "🪑",
                                    price = null
                                )
                            )
                        )
                    )
                )
            )
        )
    }

    fun mockBus(): VehicleScheme {
        return VehicleScheme(
            vehicleType = "bus",
            decks = listOf(
                Deck(
                    baseDeckLevel = 0,
                    levels = listOf(
                        Level(
                            columns = 3,
                            rows = 7,
                            slots = listOf(
                                // Level 0
                                Slot.Element(
                                    type = "element",
                                    row = 0,
                                    column = 0,
                                    contentDescription = "Wheel",
                                    icon = "⚙️"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 0,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 0,
                                    column = 2,
                                    contentDescription = "Bus Door",
                                    icon = "🚪"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 1,
                                    column = 0,
                                    seatInfo = "1A",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 1,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 1,
                                    column = 2,
                                    seatInfo = "1C",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 2,
                                    column = 0,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 2,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 2,
                                    column = 2,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 3,
                                    column = 0,
                                    seatInfo = "2A",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 3,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 3,
                                    column = 2,
                                    seatInfo = "2C",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 4,
                                    column = 0,
                                    contentDescription = "Stairs",
                                    icon = "🪜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 4,
                                    column = 1,
                                    contentDescription = "Stairs",
                                    icon = "🪜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 4,
                                    column = 2,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 5,
                                    column = 0,
                                    seatInfo = "3A",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 5,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 5,
                                    column = 2,
                                    contentDescription = "Toilet",
                                    icon = "🚻"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 6,
                                    column = 0,
                                    seatInfo = "4A",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 6,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 6,
                                    column = 2,
                                    contentDescription = "Toilet",
                                    icon = "🚻"
                                )
                            )
                        ),
                        Level(
                            columns = 3,
                            rows = 7,
                            slots = listOf(
                                // Level 1
                                Slot.Seat(
                                    type = "seat",
                                    row = 0,
                                    column = 0,
                                    seatInfo = "5A",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 0,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 0,
                                    column = 2,
                                    seatInfo = "5C",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 1,
                                    column = 0,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 1,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 1,
                                    column = 2,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 2,
                                    column = 0,
                                    seatInfo = "6A",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 2,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 2,
                                    column = 2,
                                    seatInfo = "6C",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 3,
                                    column = 0,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 3,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 3,
                                    column = 2,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 4,
                                    column = 0,
                                    contentDescription = "Stairs",
                                    icon = "🪜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 4,
                                    column = 1,
                                    contentDescription = "Stairs",
                                    icon = "🪜"
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 4,
                                    column = 2,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 5,
                                    column = 0,
                                    seatInfo = "7A",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 5,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 5,
                                    column = 2,
                                    seatInfo = "7C",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 6,
                                    column = 0,
                                    seatInfo = "8A",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                ),
                                Slot.Element(
                                    type = "element",
                                    row = 6,
                                    column = 1,
                                    contentDescription = "Gap",
                                    icon = "⬜"
                                ),
                                Slot.Seat(
                                    type = "seat",
                                    row = 6,
                                    column = 2,
                                    seatInfo = "8C",
                                    isTaken = false,
                                    category = "standard",
                                    color = "#0000FF",
                                    icon = "🪑",
                                    price = null
                                )
                            )
                        )
                    )
                )
            )
        )
    }
}