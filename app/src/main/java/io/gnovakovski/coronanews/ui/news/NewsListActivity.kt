package io.gnovakovski.coronanews.ui.news

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.snackbar.Snackbar
import io.gnovakovski.coronanews.CustomApplication
import io.gnovakovski.coronanews.R
import io.gnovakovski.coronanews.databinding.ActivityNewsListBinding
import javax.inject.Inject

class NewsListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: NewsListViewModel

    private lateinit var binding: ActivityNewsListBinding
    private var errorSnackbar: Snackbar? = null
    private val newsListAdapter: NewsListAdapter = NewsListAdapter()
    private val tributeSnapHelper: SnapHelper = PagerSnapHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as CustomApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_list)
        binding.postList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.adapter = newsListAdapter
        binding.viewModel = viewModel
        tributeSnapHelper.attachToRecyclerView(binding.postList)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })

        viewModel.newsList.observe(this, Observer { articleList ->
            newsListAdapter.updateNewsList(articleList)
        })
    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}
