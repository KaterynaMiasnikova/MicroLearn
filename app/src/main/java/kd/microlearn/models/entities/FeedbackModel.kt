package kd.microlearn.models.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("feedbacks")
data class FeedbackModel(
    @PrimaryKey(autoGenerate = true)
    var id_feedback: Long = 0,
    var note_feedback: Long = 0,
    var text_feedback: String = "",
    var id_portion: Long = 0
) : Parcelable