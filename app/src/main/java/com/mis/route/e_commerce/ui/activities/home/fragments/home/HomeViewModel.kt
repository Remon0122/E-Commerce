package com.mis.route.e_commerce.ui.activities.home.fragments.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mis.route.e_commerce.domain.model.category.Category
import com.mis.route.e_commerce.domain.model.product.Product
import com.mis.route.e_commerce.domain.usecases.GetCategoriesUseCase
import com.mis.route.e_commerce.domain.usecases.GetProductUseCase
import com.mis.route.e_commerce.domain.utils.ApiResult
import com.mis.route.e_commerce.ui.utils.Resource
import com.mis.route.e_commerce.ui.utils.Resource.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getProductUseCase: GetProductUseCase
): ViewModel(){
    val categoryApi = MutableLiveData<Resource<List<Category>>>(Resource.IdleState())
    val productApi = MutableLiveData<Resource<List<Product>>>(Resource.IdleState())

    fun loadCategories(){
        categoryApi.value = Resource.LoadingState()
        viewModelScope.launch {
            when (val result = getCategoriesUseCase.execute()){
                is ApiResult.ErrorApiResult -> categoryApi.postValue(ErrorState(result.error))
                is ApiResult.SuccessApiResult -> categoryApi.postValue(SuccessState(result.data))
            }

        }
    }
    fun loadProductApi(){
        productApi.value = Resource.LoadingState()
        viewModelScope.launch {
            when (val result = getProductUseCase.execute()){
                is ApiResult.ErrorApiResult -> productApi.postValue(ErrorState(result.error))
                is ApiResult.SuccessApiResult -> productApi.postValue(SuccessState(result.data))
            }
        }
    }
}