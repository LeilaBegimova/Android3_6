package com.example.android3_6.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android3_6.data.local.daos.JsonDao
import com.example.android3_6.data.remote.models.Post

@Database(entities = [Post::class], version = 3, exportSchema = false)

abstract class Database:RoomDatabase() {
    abstract val dao:JsonDao
}