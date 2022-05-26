package com.irfan.challenge6.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irfan.challenge6.domain.usecase.favorite.GetFavoriteMovieUseCase
import com.irfan.challenge6.domain.usecase.favorite.SetFavoriteMovieUseCase
import com.irfan.challenge6.domain.usecase.login.LoginUseCase
import com.irfan.challenge6.domain.usecase.profile.GetUserUseCase
import com.irfan.challenge6.domain.usecase.login.SetIsAuthorizedUseCase
import com.irfan.challenge6.domain.usecase.movie.GetPopularMovieUseCase
import com.irfan.challenge6.domain.usecase.profile.DeleteAllMovieUseCase
import com.irfan.challenge6.domain.usecase.profile.DeleteAllUserUseCase
import com.irfan.challenge6.domain.usecase.profile.UpdateUserUseCase
import com.irfan.challenge6.domain.usecase.register.RegisterUserUseCase
import com.irfan.challenge6.ui.favorite.FavoriteViewModel
import com.irfan.challenge6.ui.home.HomeViewModel
import com.irfan.challenge6.ui.login.LoginViewModel
import com.irfan.challenge6.ui.profile.ProfileViewModel
import com.irfan.challenge6.ui.register.RegisterViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val getPopularMovieUseCase: GetPopularMovieUseCase,
    private val registerUserUseCase: RegisterUserUseCase,
    private val loginUseCase: LoginUseCase,
    private val setIsAuthorizedUseCase: SetIsAuthorizedUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val deleteAllUserUseCase: DeleteAllUserUseCase,
    private val deleteAllMovieUseCase: DeleteAllMovieUseCase,
    private val getFavoriteMovieUseCase: GetFavoriteMovieUseCase,
    private val setFavoriteMovieUseCase: SetFavoriteMovieUseCase
) : ViewModelProvider.NewInstanceFactory() {
//    companion object {
//        @Volatile
//        private var instance: ViewModelFactory? = null
//
//        fun getInstance(context: Context): ViewModelFactory =
//            instance ?: synchronized(this) {
//                instance ?: ViewModelFactory(
//                    Injection.provideGetPopularMovieUseCase(context.applicationContext),
//                    Injection.provideRegisterUserUseCase(context.applicationContext),
//                    Injection.provideDoLoginUserUseCase(context.applicationContext),
//                    Injection.provideSetIsAuthorizedUseCase(context.applicationContext),
//                    Injection.provideGetUserUseCase(context.applicationContext),
//                    Injection.provideUpdateUserUseCase(context.applicationContext),
//                    Injection.provideDeleteAllUserUseCase(context.applicationContext),
//                    Injection.provideDeleteAllMovieUseCase(context.applicationContext),
//                    Injection.provideGetFavoriteMovieUseCase(context.applicationContext),
//                    Injection.provideSetFavoriteMovieUseCase(context.applicationContext)
//                )
//            }
//
//    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(getPopularMovieUseCase) as T
            }
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(registerUserUseCase) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(loginUseCase, setIsAuthorizedUseCase) as T
            }
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                ProfileViewModel(getUserUseCase, updateUserUseCase,
                deleteAllUserUseCase, deleteAllMovieUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(getFavoriteMovieUseCase, setFavoriteMovieUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}