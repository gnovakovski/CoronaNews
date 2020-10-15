package io.gnovakovski.coronanews.ui.details

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.gnovakovski.coronanews.data.NewsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    val titleText: MutableLiveData<String> = MutableLiveData()
    val urlText: MutableLiveData<String> = MutableLiveData()
    val sourceText: MutableLiveData<String> = MutableLiveData()
    val resultImageUrl = ObservableField<String>()

    fun loadInformation(title: String) {
        viewModelScope.launch {
            val article = newsRepository.getArticle(title)
            titleText.postValue(article.title)
            urlText.postValue(article.url)
            sourceText.postValue(article.source!!.name)
            resultImageUrl.set(article.urlToImage)
        }
    }
}