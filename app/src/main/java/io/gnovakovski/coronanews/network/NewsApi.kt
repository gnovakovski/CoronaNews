package io.gnovakovski.coronanews.network

import io.gnovakovski.coronanews.model.Article
import io.gnovakovski.coronanews.model.News
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface NewsApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/everything")
    fun getNews(): Observable<News>
}