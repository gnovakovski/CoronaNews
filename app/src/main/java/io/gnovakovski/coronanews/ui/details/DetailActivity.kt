package io.gnovakovski.coronanews.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import io.gnovakovski.coronanews.R
import io.gnovakovski.coronanews.databinding.ActivityDetailBinding
import io.gnovakovski.coronanews.injection.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val id= intent.getStringExtra("id")
        viewModel = ViewModelProviders.of(this, ViewModelFactory(this, id)).get(DetailViewModel::class.java)
        binding.viewModel = viewModel
    }


}
