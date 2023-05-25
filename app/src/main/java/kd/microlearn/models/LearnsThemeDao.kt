package kd.microlearn.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LearnsThemeDao {

    @Insert
    fun create(learnsTheme: LearnsTheme)
    @Query("SELECT id_theme, title_theme, description_theme, id_area FROM themes \n" +
            "join learns_theme using (id_theme)\n" +
            "where id_user = (:id_user)")
    fun getThemeOfUser(id_user: Long): List<ThemeModel>
}