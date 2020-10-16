package io.gnovakovski.coronanews.data

import io.gnovakovski.coronanews.model.Article
import io.gnovakovski.coronanews.model.ArticlesDao
import io.gnovakovski.coronanews.model.News
import io.gnovakovski.coronanews.network.NewsApi
import io.gnovakovski.coronanews.utils.API_TOKEN
import io.reactivex.Observable
import javax.inject.Inject

interface NewsRepository {
    fun getNews(): Observable<News>
    suspend fun saveArticleList(articleList: List<Article>)
    suspend fun getArticle(title: String): Article
}

class NewsDefaultRepository @Inject constructor(
    private val newsApi: NewsApi,
    private val articlesDao: ArticlesDao
) : NewsRepository {
    override fun getNews() = newsApi.getNews("covid", "pt", "publishedAt", "1", API_TOKEN)

    override suspend fun saveArticleList(articleList: List<Article>) {
        articlesDao.insertAll(articleList)
    }

    override suspend fun getArticle(title: String) = articlesDao.getArticle(title)
}
