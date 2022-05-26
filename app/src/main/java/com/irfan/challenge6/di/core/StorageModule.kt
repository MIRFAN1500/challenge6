package com.irfan.challenge6.di.core

import com.irfan.challenge6.storage.SharedPreferencesStorage
import com.irfan.challenge6.storage.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class StorageModule {

    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}