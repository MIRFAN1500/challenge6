package com.irfan.challenge6.domain.usecase.movie

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.irfan.challenge6.data.MovieRepository
import com.irfan.challenge6.domain.model.Movie
import javax.inject.Inject

class GetPopularMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): LiveData<PagingData<Movie>> {
        return movieRepository.getPopularMovies()
    }
}