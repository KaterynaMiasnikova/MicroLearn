package kd.microlearn.models.daos

import androidx.room.*
import kd.microlearn.models.entities.FeedbackModel

@Dao
interface FeedbackStore {
    @Upsert
    fun upsert(feedback: FeedbackModel)
    @Query("SELECT * FROM feedbacks WHERE id_feedback = (:id)")
    fun getById(id: Long): FeedbackModel
    @Query("SELECT id_feedback, note_feedback, text_feedback, id_portion FROM feedbacks \n" +
            "join portions using (id_portion)\n" +
            "WHERE id_theme = (:id_theme)")
    fun getAllOfTheme(id_theme: Long): List<FeedbackModel>
}