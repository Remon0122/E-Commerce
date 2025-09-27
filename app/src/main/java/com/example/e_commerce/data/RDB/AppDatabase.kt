package com.example.e_commerce.data.RDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.e_commerce.data.RDB.DAO.AccountDao
import com.example.e_commerce.data.RDB.Entity.AccountEntity

@Database(entities = [AccountEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun accountDao(): AccountDao
}