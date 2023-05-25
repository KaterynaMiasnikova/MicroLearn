package kd.microlearn.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("learns_theme", primaryKeys = ["id_user", "id_theme"])
data class LearnsTheme (
    var id_user: Long = 0,
    var id_theme: Long = 0
) : Parcelable