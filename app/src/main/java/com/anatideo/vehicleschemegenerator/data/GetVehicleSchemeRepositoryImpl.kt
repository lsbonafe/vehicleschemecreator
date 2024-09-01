package com.anatideo.vehicleschemegenerator.data

import com.anatideo.vehicleschemegenerator.data.datasource.VehicleSchemeDataSource
import com.anatideo.vehicleschemegenerator.domain.VehicleSchemeRepository

class GetVehicleSchemeRepositoryImpl(
    private val vehicleSchemeDataSource: VehicleSchemeDataSource,
): VehicleSchemeRepository {
    override fun getVehicleScheme(): Any {
        return vehicleSchemeDataSource
            .getVehicleScheme()
    }
}