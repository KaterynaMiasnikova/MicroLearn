package kd.microlearn.models

import timber.log.Timber

var lastIdArea = 0L

internal fun getAreaId(): Long {
    return lastIdArea++
}

class AreaMemStore : AreaStore{
    private val areas = ArrayList<AreaModel>()

    override fun findAll(): List<AreaModel> {
        return areas
    }

    override fun create(area: AreaModel) {
        area.id_area = getAreaId()
        areas.add(area)
        logAll()
    }

    override fun getById(id: Long): AreaModel {
        for (area in areas) {
            if (area.id_area == id) {
                return area
            }
        }
        return AreaModel(-1)
    }

    override fun getAreasNames(): List<String> {
        val list = ArrayList<String>()
        for (area in areas) {
            list.add(area.name_area)
        }
        return list
    }

    override fun findAreaByName(name: String): AreaModel {
        for (area in areas) {
            if (area.name_area == name) {
                return area
            }
        }
        return AreaModel(-1)
    }

    private fun logAll() {
        areas.forEach { Timber.i("$it") }
    }
}