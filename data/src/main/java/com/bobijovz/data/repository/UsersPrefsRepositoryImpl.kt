package com.bobijovz.data.repository


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.bobijovz.domain.repository.UsersPrefsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class UsersPrefsRepositoryImpl(private val dataStore: DataStore<Preferences>) : UsersPrefsRepository {

    override fun setCurrentUser(uid: String): Flow<Boolean> = flow {
        dataStore.edit { preferences ->
            val prefKey = stringPreferencesKey(UsersPrefsRepository.UID)
            preferences[prefKey] = uid
        }
        emit(true)
    }

    override fun getCurrentUserId(): Flow<String> {
        val prefKey = stringPreferencesKey(UsersPrefsRepository.UID)
        return dataStore.data
            .map { preferences ->
                preferences[prefKey] ?: "default"
            }
    }
}