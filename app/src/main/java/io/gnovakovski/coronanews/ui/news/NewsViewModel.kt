package io.gnovakovski.coronanews.ui.news

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import io.gnovakovski.coronanews.base.BaseViewModel
import io.gnovakovski.coronanews.model.Article


class NewsViewModel: BaseViewModel() {
    private val articleTitle = MutableLiveData<String>()
    private val articleDomain = MutableLiveData<String>()
    private val resultImageUrl = ObservableField<String>()

    fun bind(article: Article){
        articleTitle.value = article.title
        articleDomain.value = article.source!!.name
        resultImageUrl.set(article.urlToImage);
    }

    fun getArticleTitle():MutableLiveData<String>{
        return articleTitle
    }

    fun getArticleDomain():MutableLiveData<String>{
        return articleDomain
    }

    fun getResultImageUrl():ObservableField<String>{
        return resultImageUrl
    }
}