package kd.microlearn.models.entities

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("liked_fact", primaryKeys = ["id_user", "id_fact"])
data class LikedFactModel (
    var id_user: Long = 0,
    var id_fact: Long = 0
) : Parcelable