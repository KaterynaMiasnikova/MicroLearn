package kd.microlearn.models.entities

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("studied_portion", primaryKeys = ["id_user", "id_portion"])
data class StudiedPortionModel (
    var id_user: Long = 0,
    var id_portion: Long = 0
) : Parcelable