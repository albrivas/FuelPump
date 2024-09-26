package com.albrivas.fuelpump.auto

import android.content.Intent
import androidx.car.app.CarAppService
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.car.app.validation.HostValidator

class FuelPumpAutomotiveService : CarAppService() {
    override fun createHostValidator(): HostValidator {
        return HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
    }

    override fun onCreateSession(): Session {
        return FuelPumpSession()
    }
}

class FuelPumpSession : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return FuelStationScreen(carContext)
    }
}
