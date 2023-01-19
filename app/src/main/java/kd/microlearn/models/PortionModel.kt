package kd.microlearn.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PortionModel(var id_portion: Long = 0, var title_portion: String = "", var text_portion: String = "", var id_theme: Long = 0) : Parcelable