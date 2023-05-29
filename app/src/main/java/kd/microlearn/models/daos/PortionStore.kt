package kd.microlearn.models.daos

import androidx.room.*
import kd.microlearn.models.entities.PortionModel

@Dao
interface PortionStore {

    @Query("SELECT * FROM portions ORDER BY id_theme ASC")
    fun findAll(): List<PortionModel>
    @Upsert
    fun upsert(portion: PortionModel)
}