package io.github.jerrymatera.medstab.data.localdatasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import io.github.jerrymatera.medstab.data.localdatasource.entities.Medication
import io.github.jerrymatera.medstab.data.localdatasource.entities.MedicationWithPrescriptions
import io.github.jerrymatera.medstab.data.localdatasource.entities.Prescription
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicationDao {

    suspend fun insertMedicationWithPrescription(
        medication: Medication,
        prescription: Prescription
    ) {
        insertMedication(medication)
        insertPrescription(prescription)
    }

    @Insert
    suspend fun insertMedication(vararg medication: Medication)

    @Insert
    suspend fun insertPrescription(vararg prescription: Prescription)

    @Transaction
    @Query("SELECT * FROM medications")
    suspend fun getMedicationsWithPrescription(): Flow<List<MedicationWithPrescriptions>>

    @Transaction
    @Query("SELECT * FROM medications WHERE medication_id = :medicationId")
    suspend fun getMedicationWithPrescription(medicationId: Int): Flow<MedicationWithPrescriptions>

    @Transaction
    @Query("DELETE FROM medications WHERE medication_id = :medicationId")
    suspend fun deleteMedicationWithPrescription(medicationId: Int)

}