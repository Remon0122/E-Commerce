package com.example.e_commerce.domain.di

import com.example.e_commerce.data.api.repository.category.CategoriesRepositoryImpl
import com.example.e_commerce.data.api.repository.SubCategory.SubCategoryRepositoryImpl
import com.example.e_commerce.domain.repositories.Category.CategoriesRepository
import com.example.e_commerce.domain.repositories.Category.ISubCategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCategoriesRepository(
        impl: CategoriesRepositoryImpl
    ): CategoriesRepository

    @Binds
    @Singleton
    abstract fun bindSubCategoryRepository(
        impl: SubCategoryRepositoryImpl
    ): ISubCategoryRepository
}

