package kd.microlearn.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudiedPortionDao {

    @Insert
    fun create(studiedPortion: StudiedPortion)
    @Query("SELECT id_portion, title_portion, text_portion, id_theme FROM portions \n" +
            "join studied_portion using (id_portion)\n" +
            "where id_user = (:id_user)")
    fun getPortionsOfUser(id_user: Long): List<PortionModel>
    @Query("SELECT id_portion, title_portion, text_portion, id_theme FROM portions \n" +
            "join studied_portion using (id_portion)\n" +
            "where id_user = (:id_user) and id_theme = (:id_theme)")
    fun getPortionsOfUserOfTheme(id_user: Long, id_theme: Long): List<PortionModel>
}