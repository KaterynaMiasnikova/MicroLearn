package kd.microlearn.models.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("facts")
data class FactModel (
    @PrimaryKey(autoGenerate = true)
    var id_fact: Long = 0,
    var text_fact: String = "",
    var link_fact: String = ""
) : Parcelable