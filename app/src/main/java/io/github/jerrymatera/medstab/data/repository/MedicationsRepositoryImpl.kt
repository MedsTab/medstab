package io.github.jerrymatera.medstab.data.repository

import io.github.jerrymatera.medstab.data.localdatasource.dao.MedicationDao
import io.github.jerrymatera.medstab.data.localdatasource.entities.Medication
import io.github.jerrymatera.medstab.data.localdatasource.entities.MedicationWithPrescriptions
import io.github.jerrymatera.medstab.data.localdatasource.entities.Prescription
import io.github.jerrymatera.medstab.domain.repository.MedicationsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MedicationsRepositoryImpl @Inject constructor(
    private val medicationDao: MedicationDao
) : MedicationsRepository {
    override suspend fun createMedicationWithPrescription(
        medication: Medication,
        prescription: Prescription
    ) {
        return medicationDao.insertMedicationWithPrescription(medication, prescription)
    }

    override suspend fun createMedication(medication: Medication) {
        return medicationDao.insertMedication(medication)
    }

    override suspend fun createPrescription(prescription: Prescription) {
        medicationDao.insertPrescription(prescription)
    }

    override suspend fun getMedicationsWithPrescription(): Flow<List<MedicationWithPrescriptions>> {
        return medicationDao.getMedicationsWithPrescription()
    }

    override suspend fun getMedicationWithPrescription(medicationId: Int): Flow<MedicationWithPrescriptions> {
        return medicationDao.getMedicationWithPrescription(medicationId)
    }

    override suspend fun deleteMedicationWithPrescription(medicationId: Int) {
        return medicationDao.deleteMedicationWithPrescription(medicationId)
    }
}