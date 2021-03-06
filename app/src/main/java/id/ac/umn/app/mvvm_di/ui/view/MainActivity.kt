package id.ac.umn.app.mvvm_di

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.binar.retrofit.data.service.ApiClient
import com.binar.retrofit.data.service.ApiHelper



import id.ac.umn.app.mvvm_di.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var repository: Repository
    private lateinit var progressDialog: ProgressDialog
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = Repository(ApiHelper(ApiClient.getInstance()))
        viewModel = ViewModelProvider(this, ViewModelFactory(repository))[MainActivityViewModel::class.java]

        progressDialog = ProgressDialog(this)
        adapter = MainAdapter()
        binding.rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvData.adapter = adapter

        binding.btnGetAllPosts.setOnClickListener {
            viewModel.getAllPosts()
        }

        setupObservers()
    }

    fun setupObservers(){
        viewModel.posts.observe(this){ resource ->
            when(resource.status){
                Status.LOADING -> {
                    progressDialog.setMessage("Loading...")
                    progressDialog.show()
                }

                Status.SUCCESS -> {
                    adapter.submitData(resource.data)
                    Toast.makeText(this, "Response Sukses : ${resource.data?.get(0)?.title}", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
                Status.ERROR -> {
                    Toast.makeText(this, "Error get Data : ${resource.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}