package kd.microlearn.models.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kd.microlearn.models.entities.FactModel

@Dao
interface FactStore {

    @Upsert
    fun upsert(factModel: FactModel)
    @Query("SELECT * FROM facts WHERE id_fact = (:id)")
    fun getById(id: Long): FactModel
}