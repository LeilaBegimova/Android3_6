package com.example.android3_6.data.repositories

import com.example.android3_6.data.remote.RetrofitClient
import com.example.android3_6.data.remote.models.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JsonRepository {
    private val apiService = RetrofitClient.provideApiService


    fun createPosts(
        post: Post,
        onResponse: (post: Post) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        apiService.createPost(post).enqueue(object : Callback<Post> {
            override fun onResponse(
                call: Call<Post>,
                response: Response<Post>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })
    }

    fun updatePost(
        posId: Int,
        post: Post,
        onResponse: (post: Post) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        apiService.updatePost(postId = posId, post = post).enqueue(object : Callback<Post> {
            override fun onResponse(
                call: Call<Post>,
                response: Response<Post>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }

            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })

    }

    fun editPost(
        posId: String,
        onResponse: (post: Post) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        apiService.editPost(posId).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }

            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })
    }

    fun deletePost(
        posId: Int,
        post: Post,
        onResponse: (post: Post) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        apiService.deletePost(postId = posId).enqueue(object : Callback<Post> {
            override fun onResponse(
                call: Call<Post>,
                response: Response<Post>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })
    }
}