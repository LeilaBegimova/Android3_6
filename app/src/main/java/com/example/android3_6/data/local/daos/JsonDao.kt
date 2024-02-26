package com.example.android3_6.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android3_6.data.remote.models.Post

@Dao
interface JsonDao {
 @Query("SELECT * FROM Post")
 fun getAllPost(): List<Post>

 @Insert(onConflict = OnConflictStrategy.REPLACE)
 fun addPost(post: Post)
}