package com.example.e_commerce.ui.activities.home.fragment.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.data.RDB.Entity.AccountEntity
import com.example.e_commerce.domain.repositories.Auth.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AccountViewModel @Inject constructor(
    private val repository: AccountRepository
) : ViewModel() {

    private val _account = MutableLiveData<AccountEntity?>()
    val account: LiveData<AccountEntity?> = _account

    // الحقول اللي هنعمل لها two-way binding
    val name = MutableLiveData<String>("")
    val email = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")
    val phone = MutableLiveData<String>("")
    val address = MutableLiveData<String>("")

    init {
        viewModelScope.launch {
            repository.getAccount().collect { acc ->
                _account.postValue(acc)
                acc?.let {
                    // اعبي الحقول عند وصول البيانات من الداتا بيز
                    name.postValue(it.name)
                    email.postValue(it.email)
                    password.postValue(it.password)
                    phone.postValue(it.phone)
                    address.postValue(it.address)
                }
            }
        }
    }

    // لحفظ/تحديث الحساب من الحقول الحالية
    fun saveOrUpdateAccount() {
        viewModelScope.launch {
            val currentId = _account.value?.id ?: 0
            val accountEntity = AccountEntity(
                id = currentId,
                name = name.value.orEmpty(),
                email = email.value.orEmpty(),
                phone = phone.value.orEmpty(),
                address = address.value.orEmpty(),
                password = password.value.orEmpty()
            )
            if (currentId == 0) {
                repository.insertAccount(accountEntity)
            } else {
                repository.updateAccount(accountEntity)
            }
            // بعد الحفظ نحدّث الـ LiveData المحلية
            _account.postValue(accountEntity)
        }
    }
}



