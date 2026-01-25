package com.mis.route.e_commerce.ui.activities.home.fragments.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mis.route.e_commerce.domain.model.category.Category
import com.mis.route.e_commerce.domain.usecases.GetCategoriesUseCase
import com.mis.route.e_commerce.domain.usecases.GetSubCategoryUseCase
import com.mis.route.e_commerce.domain.utils.ApiResult
import com.mis.route.e_commerce.ui.utils.Resource
import com.mis.route.e_commerce.ui.utils.Resource.ErrorState
import com.mis.route.e_commerce.ui.utils.Resource.SuccessState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getSubCategoryUseCase: GetSubCategoryUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {
    val categoryApi = MutableLiveData<Resource<List<Category>>>(Resource.IdleState())
    val SubCategoryApi = MutableLiveData<Resource<List<Category>>>(Resource.IdleState())

    fun loadCategories(){
        categoryApi.value = Resource.LoadingState()
        viewModelScope.launch {
            when (val result = getCategoriesUseCase.execute()){
                is ApiResult.ErrorApiResult -> categoryApi.postValue(ErrorState(result.error))
                is ApiResult.SuccessApiResult -> categoryApi.postValue(SuccessState(result.data))
            }
        }
    }
    fun loadSubCategoryApi(categoryId: String){
        SubCategoryApi.value = Resource.LoadingState()
        viewModelScope.launch {
            when (val result = getSubCategoryUseCase.execute(categoryId)){
                is ApiResult.ErrorApiResult -> SubCategoryApi.postValue(ErrorState(result.error))
                is ApiResult.SuccessApiResult -> SubCategoryApi.postValue(SuccessState(result.data))
            }
        }
    }
}