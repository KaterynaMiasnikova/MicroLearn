package kd.microlearn.models.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kd.microlearn.models.entities.FactModel
import kd.microlearn.models.entities.LikedFactModel

@Dao
interface LikedFactStore {

    @Upsert
    fun upsert(likedFactModel: LikedFactModel)
    @Query("SELECT id_fact, text_fact, link_fact FROM facts \n" +
            "join liked_fact using (id_fact)\n" +
            "where id_user = (:id_user)")
    fun getFactsOfUser(id_user: Long): List<FactModel>
}