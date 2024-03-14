package ru.pyroman.medanalytica.data.token.cache

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.pyroman.medanalytica.domain.token.model.Token
import javax.inject.Inject

internal class TokenCacheDataSource @Inject constructor(
    applicationContext: Context,
) {

    private val masterKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    private val sharedPreferences = EncryptedSharedPreferences.create(
        FILE_NAME,
        masterKey,
        applicationContext,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
    )

    suspend fun setToken(token: Token) {
        withContext(Dispatchers.Main) {
            sharedPreferences.edit()
                .putString(TOKEN_KEY, token)
                .apply()
        }
    }

    suspend fun getToken(): Token? {
        return withContext(Dispatchers.Main) {
            sharedPreferences.getString(TOKEN_KEY, null)
        }
    }

    suspend fun clearToken() {
        return withContext(Dispatchers.Main) {
            sharedPreferences.edit()
                .remove(TOKEN_KEY)
                .apply()
        }
    }

    companion object {
        private const val FILE_NAME = "preferences"
        private const val TOKEN_KEY = "token"
    }
}