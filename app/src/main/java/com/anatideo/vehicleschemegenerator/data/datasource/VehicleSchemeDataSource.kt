package com.anatideo.vehicleschemegenerator.data.datasource

import com.anatideo.vehicleschemegenerator.data.model.VehicleScheme

interface VehicleSchemeDataSource {
    fun getVehicleScheme(): VehicleScheme
}
