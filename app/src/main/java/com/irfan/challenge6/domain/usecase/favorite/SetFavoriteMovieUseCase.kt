package com.irfan.challenge6.domain.usecase.favorite

import com.irfan.challenge6.data.MovieRepository
import com.irfan.challenge6.domain.model.Movie
import javax.inject.Inject

class SetFavoriteMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(movie: Movie, newStatus: Boolean) {
        return movieRepository.setFavoriteMovie(movie, newStatus)
    }
}