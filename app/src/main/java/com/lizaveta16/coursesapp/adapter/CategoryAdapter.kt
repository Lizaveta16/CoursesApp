package com.lizaveta16.coursesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lizaveta16.coursesapp.R
import com.lizaveta16.coursesapp.model.Category

class CategoryAdapter(private var context: Context, private var categories : List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var categoryTitle : TextView = itemView.findViewById(R.id.categoryTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val categoryItems : View = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(categoryItems)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.categoryTitle.text = categories[position].title
    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}