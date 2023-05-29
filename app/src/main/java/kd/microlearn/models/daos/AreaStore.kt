package kd.microlearn.models.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kd.microlearn.models.entities.AreaModel

@Dao
interface AreaStore {
    @Upsert
    fun upsert(area: AreaModel)
    @Query("SELECT * FROM areas ORDER BY id_area ASC")
    fun findAll(): List<AreaModel>
    @Query("SELECT * FROM areas WHERE id_area = (:id)")
    fun getById(id: Long): AreaModel
    @Query("SELECT name_area FROM areas")
    fun getAreasNames(): List<String>
    @Query("SELECT * FROM areas WHERE name_area = (:name)")
    fun findAreaByName(name: String): AreaModel
}