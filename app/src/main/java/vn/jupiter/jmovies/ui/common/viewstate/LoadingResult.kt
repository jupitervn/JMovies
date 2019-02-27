package vn.jupiter.jmovies.ui.common.viewstate

import java.lang.Exception

data class LoadingResult<T>(val data: T, val isLoading: Boolean, val exception: Exception)
