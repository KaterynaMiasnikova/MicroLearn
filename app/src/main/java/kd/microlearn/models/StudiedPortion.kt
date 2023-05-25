package kd.microlearn.models

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("studied_portion", primaryKeys = ["id_user", "id_portion"])
data class StudiedPortion (
    var id_user: Long = 0,
    var id_portion: Long = 0
) : Parcelable