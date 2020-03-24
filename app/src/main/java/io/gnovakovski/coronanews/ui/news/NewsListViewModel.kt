package io.gnovakovski.coronanews.ui.news

import android.view.View
import androidx.lifecycle.MutableLiveData
import io.gnovakovski.coronanews.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.gnovakovski.coronanews.base.BaseViewModel
import io.gnovakovski.coronanews.model.Article
import io.gnovakovski.coronanews.model.ArticlesDao
import io.gnovakovski.coronanews.network.NewsApi
import io.gnovakovski.coronanews.utils.API_TOKEN
import javax.inject.Inject

class NewsListViewModel(private val articlesDao: ArticlesDao): BaseViewModel(){
    @Inject
    lateinit var newsApi: NewsApi
    val newsListAdapter: NewsListAdapter =
        NewsListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadNews() }

    private lateinit var subscription: Disposable

    init{
        loadNews()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadNews(){
        subscription = newsApi.getNews("covid", "pt", "publishedAt", "1", API_TOKEN)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveNewsListStart() }
            .doOnTerminate { onRetrieveNewsListFinish() }
            .subscribe(
                // Add result
                { result -> onRetrieveNewsListSuccess(result.articles) },
                { onRetrieveNewsListError() }
            )
    }

    private fun onRetrieveNewsListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveNewsListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveNewsListSuccess(articleList:List<Article>){
        newsListAdapter.updateNewsList(articleList)
    }

    private fun onRetrieveNewsListError(){
        errorMessage.value = R.string.post_error
    }
}