package com.lizaveta16.coursesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lizaveta16.coursesapp.MainActivity
import com.lizaveta16.coursesapp.R
import com.lizaveta16.coursesapp.databinding.CategoryItemBinding
import com.lizaveta16.coursesapp.model.Category

class CategoryAdapter(private var context: Context, private var categories : List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CategoryItemBinding.bind(itemView)

        fun bind(category : Category) = with( binding){
            categoryTitle.text = category.title
            itemView.setOnClickListener(View.OnClickListener { view ->
                MainActivity.showCoursesByCategory(category.id)
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val categoryItemView : View = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(categoryItemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}