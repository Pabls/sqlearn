package ru.ar4i.sqlearn.application.di.modules

import androidx.room.Room
import ru.ar4i.sqlearn.data.database.MainDatabase

object DatabaseModule {
    private var database: MainDatabase =
        Room.databaseBuilder(
            AppModule.provideContext(),
            MainDatabase::class.java,
            MainDatabase.DATABASE_NAME
        ).build()

    fun provideCompletedSectionsDao() = database.getCompletedSectionsDao()
}