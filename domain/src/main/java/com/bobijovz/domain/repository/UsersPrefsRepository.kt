package com.bobijovz.domain.repository

import kotlinx.coroutines.flow.Flow

interface UsersPrefsRepository {
    fun setCurrentUser(uid: String) : Flow<Boolean>
    fun getCurrentUserId() : Flow<String>

    companion object {
        const val UID = "UID"
    }
}