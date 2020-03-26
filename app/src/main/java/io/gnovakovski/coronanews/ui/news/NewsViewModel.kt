package io.gnovakovski.coronanews.ui.news

import androidx.lifecycle.MutableLiveData
import io.gnovakovski.coronanews.base.BaseViewModel
import io.gnovakovski.coronanews.model.Article


class NewsViewModel: BaseViewModel() {
    private val articleTitle = MutableLiveData<String>()
    private val articleDomain = MutableLiveData<String>()

    fun bind(article: Article){
        articleTitle.value = article.title
        articleDomain.value = article.source!!.name
    }

    fun getArticleTitle():MutableLiveData<String>{
        return articleTitle
    }

    fun getArticleDomain():MutableLiveData<String>{
        return articleDomain
    }
}