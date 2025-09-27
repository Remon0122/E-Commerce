package com.example.e_commerce.domain.repositories.Auth

import com.example.e_commerce.data.RDB.DAO.AccountDao
import com.example.e_commerce.data.RDB.Entity.AccountEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AccountRepository @Inject constructor(private val accountDao: AccountDao) {
    fun getAccount(): Flow<AccountEntity?> = accountDao.getAccount()

    suspend fun insertAccount(account: AccountEntity) {
        accountDao.insertAccount(account)
    }

    suspend fun updateAccount(account: AccountEntity) {
        accountDao.updateAccount(account)
    }
    suspend fun deleteAccount(account: AccountEntity){
        accountDao.deleteAccount(account)
    }
}