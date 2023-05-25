package kd.microlearn.models

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(
    entities = [AreaModel::class, UserModel::class, PortionModel::class, ThemeModel::class, LearnsTheme::class, StudiedPortion::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun portionDao(): PortionStore
    abstract fun themeDao(): ThemeStore
    abstract fun areaDao(): AreaStore
    abstract fun userDao(): UserStore
    abstract fun learnsThemeDao(): LearnsThemeDao
    abstract fun studiedPortionDao(): StudiedPortionDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "microlearn.db").allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}