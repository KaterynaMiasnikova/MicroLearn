package kd.microlearn.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(
    entities = [AreaModel::class, UserModel::class, PortionModel::class, ThemeModel::class, LearnsTheme::class, StudiedPortion::class, FeedbackModel::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun portionDao(): PortionStore
    abstract fun themeDao(): ThemeStore
    abstract fun areaDao(): AreaStore
    abstract fun userDao(): UserStore
    abstract fun learnsThemeDao(): LearnsThemeDao
    abstract fun studiedPortionDao(): StudiedPortionDao
    abstract fun feedbackDao(): FeedbackStore


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "microlearn.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}