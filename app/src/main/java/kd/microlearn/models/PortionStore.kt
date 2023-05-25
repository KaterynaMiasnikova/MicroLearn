package kd.microlearn.models

import androidx.room.*

@Dao
interface PortionStore {

    @Query("SELECT * FROM portions ORDER BY id_theme ASC")
    fun findAll(): List<PortionModel>
    @Insert
    fun create(portion: PortionModel)
    @Update
    fun update(portion: PortionModel)
}