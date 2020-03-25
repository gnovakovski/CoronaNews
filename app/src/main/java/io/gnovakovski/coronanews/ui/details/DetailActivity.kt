package io.gnovakovski.coronanews.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.gnovakovski.coronanews.R
import io.gnovakovski.coronanews.databinding.ActivityDetailBinding
import io.gnovakovski.coronanews.injection.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(this, intent.getStringExtra("title"),
            intent.getStringExtra("url"), intent.getStringExtra("source"))).get(DetailViewModel(intent.getStringExtra("title"),
            intent.getStringExtra("url"), intent.getStringExtra("source"))::class.java)
        binding.viewModel = viewModel
    }
}
