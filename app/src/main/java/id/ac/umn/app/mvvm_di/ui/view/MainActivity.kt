package id.ac.umn.app.mvvm_di

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection


import id.ac.umn.app.mvvm_di.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private lateinit var progressDialog: ProgressDialog
    private lateinit var adapter: MainAdapter
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel :MainActivityViewModel by viewModels{viewModelFactory}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




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