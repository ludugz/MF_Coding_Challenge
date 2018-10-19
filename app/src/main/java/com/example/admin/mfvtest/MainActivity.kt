package com.example.admin.mfvtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.example.admin.mfvtest.Adapter.ListViewAdapter
import com.example.admin.mfvtest.Model.Article

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {


    private var articleArrayList: ArrayList<Article> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFakeData()
        var mListView = findViewById<ListView>(R.id.list_view)
        mListView.adapter = ListViewAdapter(this,articleArrayList)
        mListView.setOnItemClickListener(this)

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this,"abc",Toast.LENGTH_SHORT).show()
    }

    fun initFakeData() {
        articleArrayList.add(Article("1", "abc", "abc", "abc"))
        articleArrayList.add(Article("2", "abc", "abc", "abc"))
        articleArrayList.add(Article("3", "abc", "abc", "abc"))
        articleArrayList.add(Article("4", "abc", "abc", "abc"))

    }
}
