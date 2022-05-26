package com.irfan.challenge6.di.core

import android.content.Context
import com.irfan.challenge6.data.MovieRepository
import com.irfan.challenge6.data.UserRepository
import com.irfan.challenge6.storage.Storage
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class, StorageModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideMovieRepository() : MovieRepository
    fun provideUserRepository() : UserRepository
    fun provideStorage() : Storage
}