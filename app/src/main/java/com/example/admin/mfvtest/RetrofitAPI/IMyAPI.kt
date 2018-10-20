package com.example.admin.mfvtest.RetrofitAPI

import com.example.admin.mfvtest.Model.Article
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by admin on 10/19/2018.
 */
interface IMyAPI {
    //    fun getArticles(): Observable<Article>

    @GET("example-feed/feed.json")
    fun getArticle(): Observable<Article>
}