package com.islam.cleannavigationcompose.di

import com.islam.cleannavigationcompose.navigation_utils.AppNavigator
import com.islam.cleannavigationcompose.navigation_utils.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Singleton
    @Binds
    fun bindAppNavigator(appNavigatorImpl: AppNavigatorImpl): AppNavigator
}