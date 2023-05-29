package kd.microlearn.models.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("areas")
data class AreaModel(
    @PrimaryKey(autoGenerate = true)
    var id_area: Long = 0,
    var name_area: String = ""
) : Parcelable
