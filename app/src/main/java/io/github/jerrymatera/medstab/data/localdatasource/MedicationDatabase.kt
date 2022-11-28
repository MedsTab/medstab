package io.github.jerrymatera.medstab.data.localdatasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.jerrymatera.medstab.data.localdatasource.dao.MedicationDao
import io.github.jerrymatera.medstab.data.localdatasource.entities.Medication
import io.github.jerrymatera.medstab.data.localdatasource.entities.Prescription
import io.github.jerrymatera.medstab.utils.DATABASE_NAME

@Database(
    entities = [Medication::class, Prescription::class],
    version = 1,
    exportSchema = false
)
abstract class MedicationDatabase : RoomDatabase() {
    abstract fun medicationDao(): MedicationDao

    companion object {
        @Volatile
        private var instance: MedicationDatabase? = null

        fun getInstance(context: Context): MedicationDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MedicationDatabase {
            return Room.databaseBuilder(
                context,
                MedicationDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}