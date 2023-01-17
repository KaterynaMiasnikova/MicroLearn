package kd.microlearn.models

import timber.log.Timber.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class PortionMemStore : PortionStore {

    val portions = ArrayList<PortionModel>()

    override fun findAll(): List<PortionModel> {
        return portions
    }

    override fun create(portion: PortionModel) {
        portion.id = getId()
        portions.add(portion)
        logAll()
    }

    override fun update(portion: PortionModel) {
        val foundPlacemark: PortionModel? = portions.find { p -> p.id == portion.id }
        if (foundPlacemark != null) {
            foundPlacemark.p_title = portion.p_title
            foundPlacemark.p_text = portion.p_text
            logAll()
        }
    }

    private fun logAll() {
        portions.forEach { i("$it") }
    }
}