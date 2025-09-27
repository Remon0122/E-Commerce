package com.example.e_commerce.data.RDB.DAO

import androidx.room.*
import com.example.e_commerce.data.RDB.Entity.AccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(account: AccountEntity)

    @Update
    suspend fun updateAccount(account: AccountEntity)

    @Query("SELECT * FROM account LIMIT 1")
    fun getAccount(): Flow<AccountEntity?>

    @Delete
    suspend fun deleteAccount(account: AccountEntity)
}