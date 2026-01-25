package com.mis.route.data.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object AdaptersModule {
    // TODO: Circular dependency
//    @Provides
//    fun provideCategoriesAdapter(): CategoriesRecyclerAdapter {
//        return CategoriesRecyclerAdapter(null)
//    }
//
//    @Provides
//    fun provideProductsAdapter(): ProductsRecyclerAdapter {
//        return ProductsRecyclerAdapter(null)
//    }
}