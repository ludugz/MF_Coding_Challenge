package com.example.admin.mfvtest.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.admin.mfvtest.Helper.GlideHelper
import com.example.admin.mfvtest.Model.Article
import com.example.admin.mfvtest.Model.ArticleContent
import com.example.admin.mfvtest.R

/**
 * Created by admin on 10/19/2018.
 */

class ListViewAdapter (var context: Context, var article : MutableList<ArticleContent> ) : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        var layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.article_item_list,viewGroup,false);
        var title = view.findViewById<TextView>(R.id.text_view_title)
        var description = view.findViewById<TextView>(R.id.text_view_description)
        var image = view.findViewById<ImageView>(R.id.image_view_item)
        title.text = article[position].title
        description.text = article[position].description
        GlideHelper.loadUrl(context,image,article[position].image)
        return view
    }

    override fun getItem(position: Int): Any {
        return article.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return article.count()
    }


}