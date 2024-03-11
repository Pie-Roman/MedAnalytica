package ru.pyroman.postanalysis.feature.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.pyroman.medanalytica.domain.postanalysis.model.PostAnalysisData
import ru.pyroman.medanalytica.domain.postanalysis.repository.PostAnalysisRepository
import ru.pyroman.postanalysis.feature.state.PostAnalysisState
import java.io.File
import java.io.FileOutputStream

internal class PostAnalysisViewModel(
    application: Application,
    private val postAnalysisRepository: PostAnalysisRepository,
) : AndroidViewModel(application) {

    private val _viewState = MutableStateFlow<PostAnalysisState>(PostAnalysisState.Idle)
    val viewState = _viewState.asStateFlow()

    fun onFileInput(uri: Uri) = viewModelScope.launch {
        if (_viewState.value == PostAnalysisState.Loading) {
            return@launch
        }

        _viewState.emit(PostAnalysisState.Loading)

        val newState = withContext(Dispatchers.IO) {
            try {
                val postAnalysisData = PostAnalysisData(
                    file = readFile(uri),
                )
                val result = postAnalysisRepository.postAnalysis(postAnalysisData)
                PostAnalysisState.Success(
                    result = result,
                )
            } catch (error: Throwable) {
                PostAnalysisState.Error
            }
        }

        _viewState.emit(newState)
    }

    private suspend fun readFile(uri: Uri): File {
        return withContext(Dispatchers.Main) {
            val context = getApplication<Application>().applicationContext
            val file = File(context.cacheDir, "file")
            context.contentResolver.openInputStream(uri)?.use { inputStream ->
                FileOutputStream(file).use { outputStream ->
                    val buffer = ByteArray(1024)
                    var size: Int
                    while (inputStream.read(buffer).also { size = it } != -1) {
                        outputStream.write(buffer, 0, size)
                    }
                }
            }

            file
        }
    }
}