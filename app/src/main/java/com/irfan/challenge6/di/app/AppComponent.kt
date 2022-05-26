package com.irfan.challenge6.di.app

import com.irfan.challenge6.di.core.CoreComponent
import com.irfan.challenge6.ui.MainActivity
import com.irfan.challenge6.ui.detail.MovieDetailFragment
import com.irfan.challenge6.ui.favorite.FavoriteFragment
import com.irfan.challenge6.ui.home.HomeFragment
import com.irfan.challenge6.ui.login.LoginFragment
import com.irfan.challenge6.ui.profile.UpdateProfileFragment
import com.irfan.challenge6.ui.register.RegisterFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(fragment: MovieDetailFragment)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: UpdateProfileFragment)
    fun inject(fragment: RegisterFragment)
    fun inject(activity: MainActivity)
}