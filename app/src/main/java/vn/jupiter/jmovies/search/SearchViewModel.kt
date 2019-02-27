package vn.jupiter.jmovies.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import vn.jupiter.jmovies.data.MediaRepo
import vn.jupiter.jmovies.data.model.MovieInfo
import vn.jupiter.jmovies.ui.common.viewstate.LoadingResult
import javax.inject.Inject

class SearchViewModel @Inject constructor(val mediaRepo: MediaRepo) : ViewModel() {
    private val _query = MutableLiveData<String>()
    val query: LiveData<String> = _query
    val moviesList = Transformations.switchMap(_query) { keyword ->
        mediaRepo.searchMovies(keyword, 1)
            .subscribe({ movie ->

            }, { error ->

            })
    }

    private val disposable = CompositeDisposable()

    init {
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}


}
