package kd.microlearn.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AreaStore {
    @Query("SELECT * FROM areas ORDER BY id_area ASC")
    fun findAll(): List<AreaModel>
    @Insert
    fun create(area: AreaModel)
    @Query("SELECT * FROM areas WHERE id_area = (:id)")
    fun getById(id: Long): AreaModel
    @Query("SELECT name_area FROM areas")
    fun getAreasNames(): List<String>
    @Query("SELECT * FROM areas WHERE name_area = (:name)")
    fun findAreaByName(name: String): AreaModel
}