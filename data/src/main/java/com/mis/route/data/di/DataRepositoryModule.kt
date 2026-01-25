package com.mis.route.data.di

import com.mis.route.domain.repositories.data.DataRepositoryContract
import com.mis.route.data.repositories.data.DataRepositoryImpl
import com.mis.route.data.repositories.source.OnlineDataSourceImpl
import com.mis.route.domain.repositories.source.OnlineDataSourceContract
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataRepositoryModule {
    @Binds
    abstract fun bindOnlineDataSource(onlineDataSourceImpl: OnlineDataSourceImpl): OnlineDataSourceContract

    @Binds
    abstract fun bindDataRepository(dataRepositoryImpl: DataRepositoryImpl): DataRepositoryContract
}