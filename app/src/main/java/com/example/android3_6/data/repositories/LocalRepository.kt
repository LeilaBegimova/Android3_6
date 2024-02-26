package com.example.android3_6.data.repositories

import com.example.android3_6.data.local.App
import com.example.android3_6.data.remote.models.Post

class LocalRepository {
    fun fatchData() = App.db.dao.getAllPost()

    fun addData(post: Post) {
        App.db.dao.addPost(post)
    }
}