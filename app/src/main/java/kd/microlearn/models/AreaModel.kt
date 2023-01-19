package kd.microlearn.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AreaModel(var id_area: Long = 0, var name_area: String = "") : Parcelable
