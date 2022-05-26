package com.irfan.challenge6.domain.usecase.favorite

import com.irfan.challenge6.data.MovieRepository
import com.irfan.challenge6.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<List<Movie>> {
        return movieRepository.getFavoriteMovies()
    }
}