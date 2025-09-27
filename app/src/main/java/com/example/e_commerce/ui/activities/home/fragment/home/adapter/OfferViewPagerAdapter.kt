package com.example.e_commerce.ui.activities.home.fragment.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.databinding.ItemOfferLeftBinding
import com.example.e_commerce.databinding.ItemOfferRightBinding
import com.example.e_commerce.data.api.model.offer.Offer
import com.example.e_commerce.ui.activities.home.fragment.home.OfferViewType

class OfferViewPagerAdapter(
    var offersList: List<Offer> = emptyList()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // ViewHolder لليستة اليسرى
    class ViewHolderLeft(val binding: ItemOfferLeftBinding) :
        RecyclerView.ViewHolder(binding.root)

    // ViewHolder لليستة اليمنى
    class ViewHolderRight(val binding: ItemOfferRightBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0)
            OfferViewType.LeftOfferView.value
        else
            OfferViewType.RightOfferView.value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == OfferViewType.LeftOfferView.value) {
            val binding = ItemOfferLeftBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            ViewHolderLeft(binding)
        } else {
            val binding = ItemOfferRightBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            ViewHolderRight(binding)
        }
    }

    override fun getItemCount(): Int = offersList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val offer = offersList[position]
        when (holder) {
            is ViewHolderLeft -> holder.binding.offer = offer
            is ViewHolderRight -> holder.binding.offer = offer
        }
    }
}
