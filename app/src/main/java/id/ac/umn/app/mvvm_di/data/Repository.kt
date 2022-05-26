package id.ac.umn.app.mvvm_di.data


import id.ac.umn.app.mvvm_di.data.service.ApiHelper


//(API, Room)
class Repository(private val apiHelper: ApiHelper) {
    suspend fun getPosts() = apiHelper.getAllPosts()

    //Edit Post

    //Delete Post

    //Login

    //Add Favourite
}