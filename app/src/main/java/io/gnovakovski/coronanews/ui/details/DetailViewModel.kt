package io.gnovakovski.coronanews.ui.details

import androidx.lifecycle.MutableLiveData
import io.gnovakovski.coronanews.base.BaseViewModel
import io.gnovakovski.coronanews.model.ArticlesDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailViewModel(private val articlesDao: ArticlesDao, private val id: String) : BaseViewModel() {

    val titleText: MutableLiveData<String> = MutableLiveData()
    val urlText: MutableLiveData<String> = MutableLiveData()
    val sourceText: MutableLiveData<String> = MutableLiveData()

    init {
        GlobalScope.launch {
            loadInformation(id)
        }
    }
     fun loadInformation(id: String) {
           val article = articlesDao.getArticle(id)
           titleText.postValue(article.title)
           urlText.postValue(article.url)
           sourceText.postValue(article.source!!.name)
     }

}