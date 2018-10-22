package com.example.admin.mfvtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import com.example.admin.mfvtest.Helper.GlideHelper
import com.example.admin.mfvtest.Model.ArticleContent
import com.example.admin.mfvtest.Utilities.AppUtils

/**
 * Created by TRUONG NHAT TAN on 10/20/2018.
 */

class DetailActivity : AppCompatActivity() {

    private lateinit var mTextView: TextView
    private lateinit var mImageView: ImageView
    private lateinit var articleContent: ArticleContent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
        GlideHelper.loadUrl(this, mImageView, articleContent.image)
    }

    fun initView() {
        articleContent = intent.extras.getParcelable<ArticleContent>(AppUtils.ARTICLE_LIST)
        mTextView = findViewById(R.id.text_view_description)
        mImageView = findViewById(R.id.image_view_description)
        mTextView.text = articleContent.detail
        mTextView.movementMethod = object : ScrollingMovementMethod(){}
    }
}
