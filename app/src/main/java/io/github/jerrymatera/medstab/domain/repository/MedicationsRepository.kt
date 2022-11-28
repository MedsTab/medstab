package io.github.jerrymatera.medstab.domain.repository

import io.github.jerrymatera.medstab.data.localdatasource.entities.Medication
import io.github.jerrymatera.medstab.data.localdatasource.entities.MedicationWithPrescriptions
import io.github.jerrymatera.medstab.data.localdatasource.entities.Prescription
import kotlinx.coroutines.flow.Flow


interface MedicationsRepository {

    suspend fun createMedicationWithPrescription(medication: Medication, prescription: Prescription)

    suspend fun createMedication(medication: Medication)

    suspend fun createPrescription(prescription: Prescription)

    suspend fun getMedicationsWithPrescription() : Flow<List<MedicationWithPrescriptions>>

    suspend fun getMedicationWithPrescription(medicationId: Int) : Flow<MedicationWithPrescriptions>

    suspend fun deleteMedicationWithPrescription(medicationId: Int)
}