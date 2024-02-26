package com.example.android3_6.data.remote.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Post(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)