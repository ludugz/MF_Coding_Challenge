package com.example.admin.mfvtest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import com.example.admin.mfvtest.Adapter.ListViewAdapter
import com.example.admin.mfvtest.Model.Article
import com.example.admin.mfvtest.Model.ArticleContent
import com.example.admin.mfvtest.RetrofitAPI.IMyAPI
import com.example.admin.mfvtest.RetrofitAPI.RetrofitClient
import com.example.admin.mfvtest.Utilities.AppUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by TRUONG NHAT TAN on 10/19/2018.
 */

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener{
    internal lateinit var jsonAPI: IMyAPI
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var articleContentList: MutableList<ArticleContent> = mutableListOf()
    lateinit var mListView: ListView
    lateinit var mArrayAdapter: ListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initApi()
    }

    fun initApi() {
        val retrofit = RetrofitClient.instance
        jsonAPI = retrofit.create(IMyAPI::class.java)
        compositeDisposable.add(jsonAPI.getArticle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { article -> fetchData(article) }
        )
    }

    fun fetchData(article: Article) {
        articleContentList.clear()
        articleContentList.addAll(article.articles)
        mArrayAdapter.notifyDataSetChanged()
    }

    fun initView() {
        mListView = findViewById<ListView>(R.id.list_view)
        mArrayAdapter = ListViewAdapter(this, articleContentList)
        mListView.adapter = mArrayAdapter
        mListView.setOnItemClickListener(this)
    }

    fun launchNextScreen(context: Context, articleContent: ArticleContent, view: View?) {
        val intent = Intent(context, DetailActivity::class.java)
        var imageViewItem = view?.findViewById<ImageView>(R.id.image_view_item)
        var options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageViewItem!!, AppUtils.ARTICLE_LIST)
        intent.putExtra(AppUtils.ARTICLE_LIST, articleContent)
        startActivity(intent, options.toBundle())
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        launchNextScreen(this, articleContentList[position], view)
    }



}
