package kd.microlearn.models

import timber.log.Timber.i

var lastIdPortion: Long = 0L

internal fun getPortionId(): Long {
    return lastIdPortion++
}

class PortionMemStore : PortionStore {

    private val portions = ArrayList<PortionModel>()

    override fun findAll(): List<PortionModel> {
        return portions
    }

    override fun create(portion: PortionModel) {
        portion.id_portion = getPortionId()
        portions.add(portion)
        logAll()
    }

    override fun update(portion: PortionModel) {
        val foundPlacemark: PortionModel? = portions.find { p -> p.id_portion == portion.id_portion }
        if (foundPlacemark != null) {
            foundPlacemark.title_portion = portion.title_portion
            foundPlacemark.text_portion = portion.text_portion
            logAll()
        }
    }

    private fun logAll() {
        portions.forEach { i("$it") }
    }
}