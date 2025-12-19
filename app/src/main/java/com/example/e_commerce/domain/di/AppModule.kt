package com.example.e_commerce.domain.di

import com.example.e_commerce.data.repositories.auth_repository.AuthRepositoryImpl
import com.example.e_commerce.data.repositories.auth_repository.datasources.auth_remote_data_source.AuthRemoteDataSource
import com.example.e_commerce.data.repositories.auth_repository.datasources.auth_remote_data_source.AuthRemoteDataSourceImpl
import com.example.e_commerce.domain.repositories.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun bindsAuthRepo(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    fun bindsAuthRemoteDataSource(authRemoteDataSource: AuthRemoteDataSourceImpl): AuthRemoteDataSource
}