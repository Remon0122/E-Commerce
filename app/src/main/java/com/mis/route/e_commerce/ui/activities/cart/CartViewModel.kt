package com.mis.route.e_commerce.ui.activities.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mis.route.e_commerce.domain.model.Cart.Cart
import com.mis.route.e_commerce.domain.model.category.Category
import com.mis.route.e_commerce.domain.usecases.GetCartUseCase
import com.mis.route.e_commerce.domain.utils.ApiResult
import com.mis.route.e_commerce.domain.utils.AppErrors
import com.mis.route.e_commerce.ui.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class CartViewModel @Inject constructor(val getCartUseCase: GetCartUseCase ) : ViewModel(){

    private val _cartState = MutableStateFlow<Resource<Cart>>(Resource.IdleState())
    val cartState: MutableStateFlow<Resource<Cart>> = _cartState

     fun getCart(){
        viewModelScope.launch {
            getCartUseCase.invoke()
                .collect {

                }
        }
    }
}