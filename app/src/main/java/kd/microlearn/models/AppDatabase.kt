package kd.microlearn.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kd.microlearn.models.daos.*
import kd.microlearn.models.entities.*

@Database(
    entities = [AreaModel::class,
        UserModel::class,
        PortionModel::class,
        ThemeModel::class,
        FeedbackModel::class,
        FactModel::class,
        LikedFactModel::class,
        LearnsThemeModel::class,
        StudiedPortionModel::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun portionDao(): PortionStore
    abstract fun themeDao(): ThemeStore
    abstract fun areaDao(): AreaStore
    abstract fun userDao(): UserStore
    abstract fun factDao(): FactStore
    abstract fun feedbackDao(): FeedbackStore
    abstract fun likedFactDao(): LikedFactStore
    abstract fun learnsThemeDao(): LearnsThemeStore
    abstract fun studiedPortionDao(): StudiedPortionStore

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