package com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mis.route.domain.models.offer.Offer
import com.mis.route.e_commerce.databinding.ItemOfferLeftBinding
import com.mis.route.e_commerce.databinding.ItemOfferRightBinding

class OfferViewPagerAdapter(var offersList: List<Offer?>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolderLeft(val binding: ItemOfferLeftBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ViewHolderRight(val binding: ItemOfferRightBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) OfferViewType.LeftOfferView.value else OfferViewType.RightOfferView.value
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

    override fun getItemCount() = offersList?.size ?: 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderLeft -> holder.binding.offer = offersList!![position]
            is ViewHolderRight -> holder.binding.offer = offersList!![position]
        }
    }
}