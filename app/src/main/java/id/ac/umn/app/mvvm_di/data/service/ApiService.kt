package id.ac.umn.app.mvvm_di.data.service

import id.ac.umn.app.mvvm_di.data.GetAllPostsResponseItem
import retrofit2.http.*

interface ApiService {
    @GET("posts")
    suspend fun getAllPosts(): List<GetAllPostsResponseItem>
}