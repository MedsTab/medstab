package io.github.jerrymatera.medstab.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.jerrymatera.medstab.data.dao.MedicationDao
import io.github.jerrymatera.medstab.data.entities.Medication
import io.github.jerrymatera.medstab.data.entities.Prescription
import io.github.jerrymatera.medstab.utils.DATABASE_NAME

@Database(
    entities = [Medication::class, Prescription::class],
    version = 1,
    exportSchema = false
)
abstract class MedicineDatabase : RoomDatabase() {
    abstract fun medicationDao(): MedicationDao

    companion object {
        @Volatile
        private var instance: MedicineDatabase? = null

        fun getInstance(context: Context): MedicineDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MedicineDatabase {
            return Room.databaseBuilder(
                context,
                MedicineDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}