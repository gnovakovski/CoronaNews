package io.gnovakovski.coronanews.network

import io.gnovakovski.coronanews.model.Article
import io.gnovakovski.coronanews.model.News
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * The interface which provides methods to get result of webservices
 */
interface NewsApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("v2/everything")
    fun getNews(@Query("q") q: String,
                @Query("language") language: String,
                @Query("sortBy") sortBy: String,
                @Query("page") page: String,
                @Query("apiKey") apiKey: String): Observable<News>
}