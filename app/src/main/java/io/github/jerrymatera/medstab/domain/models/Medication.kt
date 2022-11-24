package io.github.jerrymatera.medstab.domain.models

import com.google.type.DateTime

data class Medication(
    val id: Int,
    val title: String,
    val create: DateTime,
    val description: String,
    val prescriptions: List<Prescription>
)
