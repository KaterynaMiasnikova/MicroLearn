package kd.microlearn.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PortionModel(var id: Long = 0, var p_title: String = "", var p_text: String = "", var p_theme: String = "") : Parcelable