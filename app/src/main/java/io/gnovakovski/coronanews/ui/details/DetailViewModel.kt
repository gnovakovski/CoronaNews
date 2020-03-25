package io.gnovakovski.coronanews.ui.details

import androidx.lifecycle.MutableLiveData
import io.gnovakovski.coronanews.base.BaseViewModel

class DetailViewModel(title: String, url: String, source: String) : BaseViewModel() {

    val titleText: MutableLiveData<String> = MutableLiveData()
    val urlText: MutableLiveData<String> = MutableLiveData()
    val sourceText: MutableLiveData<String> = MutableLiveData()

    companion object{

    }

    init{
        loadInformation(title, url, source)
    }

    private fun loadInformation(title: String, url: String, source: String) {
        titleText.value = title
        urlText.value = url
        sourceText.value = source
    }

}