package kd.microlearn.models

import timber.log.Timber

var lastIdTheme = 0L

internal fun getThemeId(): Long {
    return lastIdTheme++
}

class ThemeMemStore : ThemeStore {
    private val themes = ArrayList<ThemeModel>()

    override fun findAll(): List<ThemeModel> {
        return themes
    }

    override fun create(theme: ThemeModel) {
        theme.id_theme = getThemeId()
        themes.add(theme)
        logAll()
    }

    override fun getThemesNames(): List<String> {
        val list = ArrayList<String>()
        for (theme in themes) {
            list.add(theme.title_theme)
        }
        return list
    }

    override fun getThemesNamesOfArea(id_area: Long): List<String> {
        val list = ArrayList<String>()
        for (theme in themes) {
            if (theme.id_area == id_area) {
                list.add(theme.title_theme)
            }
        }
        return list
    }

    override fun findThemeByName(name: String): ThemeModel {
        for (theme in themes) {
            if (theme.title_theme == name) {
                return theme
            }
        }
        return ThemeModel(-1)
    }

    override fun getById(id: Long): ThemeModel {
        for (theme in themes) {
            if (theme.id_theme == id) {
                return theme
            }
        }
        return ThemeModel(-1)
    }

    private fun logAll() {
        themes.forEach { Timber.i("$it") }
    }
}