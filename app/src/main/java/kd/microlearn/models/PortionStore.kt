package kd.microlearn.models

interface PortionStore {
    fun findAll(): List<PortionModel>
    fun create(portion: PortionModel)
    fun update(portion: PortionModel)
}