package com.example.android3_6.data.local

import android.app.Application
import androidx.room.Room

private const val DATABASE_NAME = "post"

class App : Application() {
    companion object {
        lateinit var db: Database
            private set
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            Database::class.java,
            DATABASE_NAME
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}