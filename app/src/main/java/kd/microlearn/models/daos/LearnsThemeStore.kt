package kd.microlearn.models.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kd.microlearn.models.entities.LearnsThemeModel
import kd.microlearn.models.entities.ThemeModel

@Dao
interface LearnsThemeStore {

    @Upsert
    fun upsert(learnsThemeModel: LearnsThemeModel)
    @Query("SELECT id_theme, title_theme, description_theme, id_area FROM themes \n" +
            "join learns_theme using (id_theme)\n" +
            "where id_user = (:id_user)")
    fun getThemeOfUser(id_user: Long): List<ThemeModel>
}