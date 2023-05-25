package kd.microlearn.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("users")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    var id_user: Long = 0,
    var name_user: String = "",
    var surname_user: String = "",
    var email_user: String = "",
    var password_user: String = ""
) : Parcelable