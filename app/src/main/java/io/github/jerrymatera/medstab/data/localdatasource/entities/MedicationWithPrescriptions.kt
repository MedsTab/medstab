package io.github.jerrymatera.medstab.data.localdatasource.entities

import androidx.room.Embedded
import androidx.room.Relation

data class MedicationWithPrescriptions(
    @Embedded val medication: Medication,
    @Relation(
        parentColumn = "medication_id",
        entityColumn = "medication_id"
    )
    val prescriptions: List<Prescription>
)
