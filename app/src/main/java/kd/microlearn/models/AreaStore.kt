package kd.microlearn.models

interface AreaStore {
    fun findAll(): List<AreaModel>
    fun create(area: AreaModel)
    fun getById(id: Long): AreaModel
    fun getAreasNames(): List<String>
    fun findAreaByName(name: String): AreaModel
}