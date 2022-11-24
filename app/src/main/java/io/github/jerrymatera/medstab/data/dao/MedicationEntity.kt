package io.github.jerrymatera.medstab.data.dao

import com.google.type.DateTime


data class MedicationEntity(
    val id: Int,
    val title: String,
    val create: DateTime,
    val description: String,
    val prescriptions: List<PrescriptionEntity>
)
