package kd.microlearn.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ThemeModel(var id_theme: Long = 0, var title_theme: String = "", var descr_theme: String = "", var id_area: Long = 0) : Parcelable
