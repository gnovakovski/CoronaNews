package io.gnovakovski.coronanews.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import io.gnovakovski.coronanews.CustomApplication
import io.gnovakovski.coronanews.R
import io.gnovakovski.coronanews.databinding.ActivityDetailBinding
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    @Inject
    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as CustomApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val id = intent.getStringExtra("id")
        viewModel.loadInformation(id)

        binding.viewModel = viewModel
    }
}
