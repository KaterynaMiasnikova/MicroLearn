package kd.microlearn.models

interface ThemeStore {
    fun findAll(): List<ThemeModel>
    fun findAllBut(themeMemStore: ThemeMemStore): ThemeMemStore
    fun create(theme: ThemeModel)
    fun getThemesNames(): List<String>
    fun getThemesNamesOfArea(id_area: Long): List<String>
    fun findThemeByName(name: String): ThemeModel
    fun getById(id: Long): ThemeModel
    fun isThemeId(theme : ThemeModel): Boolean
}