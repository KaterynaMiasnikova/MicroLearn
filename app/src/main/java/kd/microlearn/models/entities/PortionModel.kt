package kd.microlearn.models.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("portions")
data class PortionModel(
    @PrimaryKey(autoGenerate = true)
    var id_portion: Long = 0,
    var title_portion: String = "",
    var text_portion: String = "",
    var id_theme: Long = 0,
    var id_in_theme: Long = 0
) : Parcelable