package id.ac.umn.app.mvvm_di.data.service

class ApiHelper(private val apiService: ApiService) {
    suspend fun getAllPosts() = apiService.getAllPosts()
}