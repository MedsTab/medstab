package io.github.jerrymatera.medstab.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jerrymatera.medstab.data.localdatasource.dao.MedicationDao
import io.github.jerrymatera.medstab.data.repository.MedicationsRepositoryImpl
import io.github.jerrymatera.medstab.domain.repository.MedicationsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMedicationRepository(medicationDao: MedicationDao): MedicationsRepository {
        return MedicationsRepositoryImpl(medicationDao)
    }
}