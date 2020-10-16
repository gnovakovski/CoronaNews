package io.gnovakovski.coronanews.ui.news

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.gnovakovski.coronanews.R
import io.gnovakovski.coronanews.data.NewsRepository
import io.gnovakovski.coronanews.model.Article
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsListViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val newsList: MutableLiveData<List<Article>> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadNews() }

    private lateinit var subscription: Disposable

    init {
        loadNews()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadNews() {
        subscription = newsRepository.getNews()
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

    private fun onRetrieveNewsListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveNewsListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveNewsListSuccess(articleList: List<Article>) {
        newsList.value = articleList

        viewModelScope.launch {
            newsRepository.saveArticleList(articleList)
        }
    }

    private fun onRetrieveNewsListError() {
        errorMessage.value = R.string.post_error
    }
}