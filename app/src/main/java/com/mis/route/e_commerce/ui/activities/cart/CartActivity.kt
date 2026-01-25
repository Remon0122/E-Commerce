package com.mis.route.e_commerce.ui.activities.cart


import android.view.LayoutInflater
import android.view.ViewGroup
import com.mis.route.e_commerce.databinding.ActivityCartBinding
import com.mis.route.e_commerce.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartActivity : BaseFragment<ActivityCartBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ActivityCartBinding {
        return ActivityCartBinding.inflate(inflater,container,false)
    }
}