package io.github.jerrymatera.medstab.data.localdatasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.type.DateTime


@Entity(
    tableName = "medications"
)
data class Medication(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "medication_id")
    val medicationId: Int,
    val title: String,
    val create: DateTime,
    val institution: String,
    val description: String,
)
