package io.gnovakovski.coronanews.ui.news


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.gnovakovski.coronanews.R
import io.gnovakovski.coronanews.databinding.ItemNewsBinding
import io.gnovakovski.coronanews.model.Article

class NewsListAdapter: RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {
    private lateinit var newsList:List<Article>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_news, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return if(::newsList.isInitialized) newsList.size else 0
    }

    fun updateNewsList(postList:List<Article>){
        this.newsList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemNewsBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = NewsViewModel()

        fun bind(article: Article){
            viewModel.bind(article)
            binding.viewModel = viewModel
        }
    }
}