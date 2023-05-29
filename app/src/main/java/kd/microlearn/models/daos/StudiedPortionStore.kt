package kd.microlearn.models.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kd.microlearn.models.entities.PortionModel
import kd.microlearn.models.entities.StudiedPortionModel

@Dao
interface StudiedPortionStore {

    @Upsert
    fun upsert(studiedPortionModel: StudiedPortionModel)
    @Query("SELECT id_portion, title_portion, text_portion, id_theme, id_in_theme FROM portions \n" +
            "join studied_portion using (id_portion)\n" +
            "where id_user = (:id_user)")
    fun getPortionsOfUser(id_user: Long): List<PortionModel>
    @Query("SELECT id_portion, title_portion, text_portion, id_theme, id_in_theme FROM portions \n" +
            "join studied_portion using (id_portion)\n" +
            "where id_user = (:id_user) and id_theme = (:id_theme)")
    fun getPortionsOfUserOfTheme(id_user: Long, id_theme: Long): List<PortionModel>
}