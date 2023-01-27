package kd.microlearn.models

interface PortionStore {
    fun findAll(): List<PortionModel>
    fun findAllOfTheme(theme : ThemeModel): List<PortionModel>
    fun findAllOfTheme(themes : ThemeMemStore): List<PortionModel>
    fun create(portion: PortionModel)
    fun update(portion: PortionModel)
}