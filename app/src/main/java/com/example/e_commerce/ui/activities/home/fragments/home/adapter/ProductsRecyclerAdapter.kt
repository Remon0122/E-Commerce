package com.example.e_commerce.ui.activities.home.fragments.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.data.models.product.Product
import com.example.e_commerce.databinding.ItemProductBinding


class ProductsRecyclerAdapter(var productsList: List<Product?>?) :
    RecyclerView.Adapter<ProductsRecyclerAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product?) {
            binding.product = product
            binding.productCover.setBackgroundColor(Color.WHITE)
            binding.addToFavorites.isVisible = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = productsList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productsList!![position]
        holder.bind(product)
        // set click listener later
    }
}