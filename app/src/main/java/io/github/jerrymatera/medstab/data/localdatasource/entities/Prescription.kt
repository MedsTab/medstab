package io.github.jerrymatera.medstab.data.localdatasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prescriptions")
data class Prescription(
    @PrimaryKey(autoGenerate = true)
    val id:String,
    @ColumnInfo(name = "medication_id")
    val medicationId: Int,
    val name: String,
    val dosage: String
)
