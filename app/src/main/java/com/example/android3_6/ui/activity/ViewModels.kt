package com.example.android3_6.ui.activity

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.android3_6.data.remote.models.Post
import com.example.android3_6.data.repositories.JsonRepository
import com.example.android3_6.data.repositories.LocalRepository

class ViewModels : ViewModel() {
    private val jsonRepository = JsonRepository()
    private val localRepository = LocalRepository()


    fun createPost(
        post: Post,
        onSuccess: (post: Post) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        jsonRepository.createPosts(
            post = post,
            onResponse = onSuccess
        ) { message, t ->
            val message = t.message ?: "Unknown error!"
            Log.e("createPost", message)
            onFailure(message)

        }
    }

    fun updatePost(
        postId: Int,
        post: Post,
        onSuccess: (post: Post) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        jsonRepository.updatePost(
            posId = postId,
            post = post,
            onResponse = onSuccess
        ) { message, t ->
            val message = t.message ?: "Unknown error!"
            Log.e("createPost", message)
            onFailure(message)


        }
    }

    fun editPost(
        title: String,
        onSuccess: (post: Post) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        jsonRepository.editPost(
            posId = title,
            onResponse = onSuccess
        ) { message, t ->
            val message = t.message ?: "Unknown error!"
            Log.e("createPost", message)
            onFailure(message)

        }
    }

    fun deletePost(
        postId: Int,
        post: Post,
        onSuccess: (post: Post) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        jsonRepository.deletePost(
            posId = postId,
            post = post,
            onResponse = onSuccess
        ) { message, t ->
            val message = t.message ?: "Unknown error!"
            Log.e("createPost", message)
            onFailure(message)
        }
    }

    fun addData(post: Post) {
        localRepository.addData(post)
    }

    //получение с room
    fun fetchData(): List<Post> {
        return localRepository.fatchData()
    }
}