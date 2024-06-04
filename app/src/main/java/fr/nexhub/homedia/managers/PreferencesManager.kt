package fr.nexhub.homedia.managers

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class PreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("homedia", Context.MODE_PRIVATE)

    private val encryptedSharedPreferences: SharedPreferences =
        getEncryptedSharedPreferences(context)

    private fun getEncryptedSharedPreferences(context: Context): SharedPreferences {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        return EncryptedSharedPreferences.create(
            "encrypted_prefs",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun saveData(
        key: String,
        value: String,
        shouldEncrypt: Boolean = false
    ) {
        val editor =
            if (shouldEncrypt)
                encryptedSharedPreferences.edit()
            else
                sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getData(key: String, isEncrypted: Boolean = false, defaultValue: String = ""): String {
        return if (isEncrypted)
            encryptedSharedPreferences.getString(key, defaultValue) ?: defaultValue
        else
            sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun reset() {
        resetUnsecuredData()
        resetEncryptedData()
    }

    private fun resetUnsecuredData() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    private fun resetEncryptedData() {
        val editor = encryptedSharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}