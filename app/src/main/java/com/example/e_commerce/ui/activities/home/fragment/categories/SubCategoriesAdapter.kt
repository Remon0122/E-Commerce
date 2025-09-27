package com.example.e_commerce.ui.activities.home.fragment.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.databinding.ItemSubcategoryBinding
import com.example.e_commerce.domain.models.SubCategory.SubCategoryDomain


class SubCategoriesAdapter(
    private val onSubCategoryClick: (SubCategoryDomain) -> Unit
) : ListAdapter<SubCategoryDomain, SubCategoriesAdapter.SubCategoryViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<SubCategoryDomain>() {
            override fun areItemsTheSame(oldItem: SubCategoryDomain, newItem: SubCategoryDomain): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: SubCategoryDomain, newItem: SubCategoryDomain): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val binding = ItemSubcategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SubCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onSubCategoryClick)
    }

    class SubCategoryViewHolder(
        private val binding: ItemSubcategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SubCategoryDomain, onSubCategoryClick: (SubCategoryDomain) -> Unit) {
            binding.subcategoryName.text = item.name
            binding.root.setOnClickListener {
                onSubCategoryClick(item)
            }
        }
    }
}
