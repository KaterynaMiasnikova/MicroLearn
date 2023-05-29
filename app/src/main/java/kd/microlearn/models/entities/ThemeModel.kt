package kd.microlearn.models.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("themes")
data class ThemeModel(
    @PrimaryKey(autoGenerate = true)
    var id_theme: Long = 0,
    var title_theme: String = "",
    var description_theme: String = "",
    var id_area: Long = 0
) : Parcelable
