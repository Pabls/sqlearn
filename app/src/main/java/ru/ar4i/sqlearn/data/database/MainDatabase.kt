package ru.ar4i.sqlearn.data.database

import androidx.room.Database
import ru.ar4i.sqlearn.BuildConfig

@Database(
    entities = arrayOf(CompletedSection::class),
    version = MainDatabase.DATABASE_VERSION,
    exportSchema = false
)
abstract class MainDatabase {

    companion object {
        const val DATABASE_NAME = "${BuildConfig.APPLICATION_ID}.database"
        const val DATABASE_VERSION = 1
    }

    abstract fun getCompletedSectionsDao(): CompletedSectionsDao
}