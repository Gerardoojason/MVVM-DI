package id.ac.umn.app.mvvm_di

import androidx.lifecycle.*

import id.ac.umn.app.mvvm_di.data.GetAllPostsResponseItem
import id.ac.umn.app.mvvm_di.data.Repository
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private  val repository: Repository
) : ViewModel() {

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