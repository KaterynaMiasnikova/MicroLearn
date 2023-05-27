package kd.microlearn.models

import androidx.room.*

@Dao
interface FeedbackStore {
    @Insert
    fun create(feedback: FeedbackModel)
    @Query("SELECT * FROM feedbacks WHERE id_feedback = (:id)")
    fun getById(id: Long): FeedbackModel

}