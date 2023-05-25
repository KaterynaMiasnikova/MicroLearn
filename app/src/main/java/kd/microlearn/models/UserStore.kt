package kd.microlearn.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserStore {

    @Insert
    fun create(user: UserModel)
    @Query("SELECT * FROM users WHERE id_user = (:id)")
    fun getById(id: Long): UserModel
    @Query("SELECT * FROM users WHERE email_user = (:email) and password_user = (:pass)")
    fun getLogin(email: String, pass: String):UserModel
    @Query("SELECT id_theme, title_theme, description_theme, id_area FROM themes \n" +
            "join learns_theme using (id_theme)\n" +
            "where id_user = (:id_user)")
    fun getThemesOfUser(id_user: Long): List<ThemeModel>
    @Query("SELECT id_portion, title_portion, text_portion, id_theme FROM portions \n" +
            "join studied_portion using (id_portion)\n" +
            "where id_user = (:id_user)")
    fun getPortionsOfUser(id_user: Long): List<PortionModel>
    @Query("SELECT id_portion, title_portion, text_portion, id_theme FROM portions \n" +
            "join studied_portion using (id_portion)\n" +
            "where id_user = (:id_user) and id_theme = (:id_theme)")
    fun getPortionsOfUserOfTheme(id_user: Long, id_theme: Long): List<PortionModel>
}