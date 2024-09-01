package com.anatideo.vehicleschemegenerator.domain

import com.anatideo.vehicleschemegenerator.data.model.VehicleScheme

interface VehicleSchemeRepository {
    fun getVehicleScheme(): VehicleScheme // TODO must use a proper domain model
}