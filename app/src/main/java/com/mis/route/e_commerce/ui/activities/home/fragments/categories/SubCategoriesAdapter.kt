package com.mis.route.e_commerce.ui.activities.home.fragments.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mis.route.e_commerce.databinding.ItemSubcategoryBinding
import com.mis.route.e_commerce.domain.model.category.Category

class SubCategoriesAdapter(
    private var data: List<Category> = emptyList() ,
) : RecyclerView.Adapter<SubCategoriesAdapter.ViewHolder>() {

    fun setSubCategories(subcategory: List<Category>) {
        data = subcategory
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSubcategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    class ViewHolder(
        private val binding: ItemSubcategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {
            binding.subCategory = item
        }
    }
}


