package com.albrivas.fuelpump.core.data.di

import com.albrivas.fuelpump.core.data.repository.FuelStationRepository
import com.albrivas.fuelpump.core.data.repository.LocationTracker
import com.albrivas.fuelpump.core.data.repository.LocationTrackerRepository
import com.albrivas.fuelpump.core.data.repository.OfflineFuelStationRepository
import com.albrivas.fuelpump.core.data.repository.OfflineRecentSearchRepository
import com.albrivas.fuelpump.core.data.repository.OfflineRecentSearchRepositoryImp
import com.albrivas.fuelpump.core.data.repository.OfflineUserDataRepository
import com.albrivas.fuelpump.core.data.repository.PlacesRepository
import com.albrivas.fuelpump.core.data.repository.PlacesRepositoryImp
import com.albrivas.fuelpump.core.data.repository.UserDataRepository
import com.albrivas.fuelpump.core.network.datasource.PlacesDataSource
import com.albrivas.fuelpump.core.network.datasource.PlacesDataSourceImp
import com.albrivas.fuelpump.core.network.datasource.RemoteDataSource
import com.albrivas.fuelpump.core.network.datasource.RemoteDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsFuelStationRepository(
        fuelStationRepository: OfflineFuelStationRepository
    ): FuelStationRepository

    @Binds
    fun bindRemoteDataSourceImp(
        remoteDataSource: RemoteDataSourceImp
    ): RemoteDataSource

    @Binds
    fun bindUserDataRepository(
        userDataRepository: OfflineUserDataRepository
    ): UserDataRepository

    @Binds
    fun bindLocationTrackerRepository(
        locationTrackerRepository: LocationTrackerRepository
    ): LocationTracker

    @Binds
    fun bindPlacesRepository(
        placesRepository: PlacesRepositoryImp
    ): PlacesRepository

    @Binds
    fun bindPlacesDataSource(
        placesDataSource: PlacesDataSourceImp
    ): PlacesDataSource

    @Binds
    fun bindRecentSearchRepository(
        recentSearchRepository: OfflineRecentSearchRepositoryImp
    ): OfflineRecentSearchRepository
}
