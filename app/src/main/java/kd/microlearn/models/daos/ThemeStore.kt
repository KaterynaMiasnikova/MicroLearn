package kd.microlearn.models.daos

import androidx.room.*
import kd.microlearn.models.entities.ThemeModel

@Dao
interface ThemeStore {

    @Query("SELECT * FROM themes ORDER BY id_theme ASC")
    fun findAll(): List<ThemeModel>
    @Upsert
    fun upsert(theme: ThemeModel)
    @Query("SELECT title_theme FROM themes")
    fun getThemesNames(): List<String>
    @Query("SELECT title_theme FROM themes WHERE id_area = (:id_area)")
    fun getThemesNamesOfArea(id_area: Long): List<String>
    @Query("SELECT * FROM themes WHERE title_theme = (:name)")
    fun findThemeByName(name: String): ThemeModel
    @Query("SELECT * FROM themes WHERE id_theme = (:id)")
    fun getById(id: Long): ThemeModel
}