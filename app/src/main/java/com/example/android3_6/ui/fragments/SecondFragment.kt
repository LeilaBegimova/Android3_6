package com.example.android3_6.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android3_6.R
import com.example.android3_6.data.remote.models.Post
import com.example.android3_6.databinding.FragmentSecondBinding
import com.example.android3_6.ui.activity.ViewModels
import com.example.android3_6.ui.adapter.JsonAdapter

class SecondFragment : Fragment() {
    private var _biding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _biding!!
    private val viewModel by activityViewModels<ViewModels>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _biding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createPost()
        updatePst()
        editPost()
        deletePost()
        setupListeners()
    }

    private fun deletePost() = with(binding) {
        btnDelete.setOnClickListener {
            val postId = 19
            val title = editTextTitle.text.toString().trim()
            val body = editTextBody.text.toString().trim()
            val updatedPost = Post(
                userId = 2,
                id = postId,
                title = title,
                body = body
            )
            viewModel.deletePost(
                postId = postId,
                post = updatedPost,
                onSuccess = { post ->
                    viewModel.addData(post)
                    Log.i("CREATE_POST", post.toString())
                    Toast.makeText(requireActivity(), post.toString(), Toast.LENGTH_SHORT).show()
                }

            ) { message ->
                Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun editPost() = with(binding) {
        btnPatch.setOnClickListener {
            val postId = 19
            val title = editTextTitle.text.toString().trim()
            val body = editTextBody.text.toString().trim()
            val updatedPost = Post(
                userId = 2,
                id = postId,
                title = title,
                body = body
            )
            viewModel.editPost(
                title = title,
                onSuccess = { post ->
                    Log.i("EDIT_POST", post.toString())
                    Toast.makeText(requireActivity(), post.toString(), Toast.LENGTH_SHORT).show()
                }

            ) { message ->
                Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun updatePst() = with(binding) {
        btnPut.setOnClickListener {
            val postId = 19
            val title = editTextTitle.text.toString().trim()
            val body = editTextBody.text.toString().trim()
            val updatedPost = Post(
                userId = 2,
                id = postId,
                title = title,
                body = body
            )
            viewModel.updatePost(
                postId = postId,
                post = updatedPost,
                onSuccess = { post ->
                    Log.i("CREATE_POST", post.toString())
                    Toast.makeText(requireActivity(), post.toString(), Toast.LENGTH_SHORT).show()
                }

            ) { message ->
                Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun createPost() = with(binding) {
        btnPost.setOnClickListener {
            val title = editTextTitle.text.toString().trim()
            val body = editTextBody.text.toString().trim()
            val newPost = Post(
                userId = 10,
                id = 101,
                title = title,
                body = body
            )
            viewModel.createPost(
                post = newPost,
                onSuccess = { post ->
                    viewModel.addData(
                        Post(
                            body = post.body,
                            title = post.title,
                            userId = post.userId
                        )
                    )
                    Log.i("CREATE_POST", post.toString())
                    Toast.makeText(requireActivity(), post.toString(), Toast.LENGTH_SHORT).show()
                }

            ) { message ->
                Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.firstFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _biding = null
    }
}