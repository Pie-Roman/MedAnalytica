package ru.pyroman.medanalytica.data.uid.cache

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.pyroman.medanalytica.domain.uid.model.Uid
import javax.inject.Inject

internal class UidCacheDataSource @Inject constructor(
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

    suspend fun setUid(uid: Uid) {
        withContext(Dispatchers.Main) {
            sharedPreferences.edit()
                .putString(UID_KEY, uid.toString())
                .apply()
        }
    }

    suspend fun getUid(): Uid? {
        return withContext(Dispatchers.Main) {
            sharedPreferences.getString(UID_KEY, null)?.toLongOrNull()
        }
    }

    suspend fun clearUid() {
        return withContext(Dispatchers.Main) {
            sharedPreferences.edit()
                .remove(UID_KEY)
                .apply()
        }
    }

    companion object {
        private const val FILE_NAME = "preferences"
        private const val UID_KEY = "uid"
    }
}