package com.example.admin.mfvtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.example.admin.mfvtest.Adapter.ListViewAdapter
import com.example.admin.mfvtest.Model.Article
import com.example.admin.mfvtest.Model.ArticleContent
import com.example.admin.mfvtest.RetrofitAPI.IMyAPI
import com.example.admin.mfvtest.RetrofitAPI.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    internal lateinit var jsonAPI: IMyAPI
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var articleList: List<Article> = ArrayList()
    lateinit var mListView: ListView
    lateinit var mArrayAdapter: ListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mListView = findViewById<ListView>(R.id.list_view)
        initView()
//        initRetrofit()
        initApi()
    }

    fun initApi() {
        val retrofit = RetrofitClient.instance
        jsonAPI = retrofit.create(IMyAPI::class.java)
        compositeDisposable.add(jsonAPI.getArticle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { article -> displayData(article) }
        )
    }


    fun displayData(article: Article?) {
        Log.i("tntan", article.toString())
        mArrayAdapter.notifyDataSetChanged()
    }

    fun initView() {
        mArrayAdapter = ListViewAdapter(this, articleList)
        mListView.adapter = mArrayAdapter
        mListView.setOnItemClickListener(this)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, "abc", Toast.LENGTH_SHORT).show()
    }


//    fun initRetrofit(){
//        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl("https://moneyforwardvietnam.github.io/")
//                .build()
//        val api = retrofit.create(IMyAPI::class.java)
//        val response = api.getArticles()
//        response.observeOn(IoScheduler()).subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        // WE GET API RESPONSE HERE
//                )
//    }


}
