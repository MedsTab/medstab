package io.github.jerrymatera.medstab.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.jerrymatera.medstab.data.MedicationDatabase
import io.github.jerrymatera.medstab.data.dao.MedicationDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideMedicationDatabase(@ApplicationContext context: Context): MedicationDatabase {
        return MedicationDatabase.getInstance(context)
    }

    @Provides
    fun provideMedicationDao(medicationDatabase: MedicationDatabase): MedicationDao {
        return medicationDatabase.medicationDao()
    }
}