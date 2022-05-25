package id.ac.umn.app.mvvm_di

import androidx.lifecycle.*
import com.binar.retrofit.data.Repository
import com.binar.retrofit.data.Resource
import com.binar.retrofit.data.model.GetAllPostsResponseItem
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivityViewModel(private val repository: Repository) : ViewModel() {

    private val _posts = MutableLiveData<Resource<List<GetAllPostsResponseItem>>>()
    val posts: LiveData<Resource<List<GetAllPostsResponseItem>>>
    get() = _posts

    fun getAllPosts(){
        viewModelScope.launch {
            _posts.postValue(Resource.loading())
            try {
                _posts.postValue(Resource.success(repository.getPosts()))
            }catch (exception: Exception){
                _posts.postValue(Resource.error(exception.message ?: "Error Occurred"))
            }
        }
    }
}