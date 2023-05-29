package kd.microlearn.models.entities

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("learns_theme", primaryKeys = ["id_user", "id_theme"])
data class LearnsThemeModel (
    var id_user: Long = 0,
    var id_theme: Long = 0
) : Parcelable