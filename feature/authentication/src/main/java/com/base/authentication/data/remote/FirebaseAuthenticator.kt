package com.base.authentication.data.remote

import android.util.Log
import com.base.authentication.domain.repository.Authenticator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FirebaseAuthenticator(
    private val firebaseAuth: FirebaseAuth
) : Authenticator {
    override suspend fun registerWithEmailPassword(email: String, password: String): FirebaseUser? {
        firebaseAuth.createUserWithEmailAndPassword(
            email,
            password
        )
        return Firebase.auth.currentUser
    }

    override suspend fun loginWithEmailPassword(email: String, password: String): FirebaseUser? {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.i("FirebaseAuthenticator", "success")
                } else {
                    Log.i("FirebaseAuthenticator", "fail")
                }
            }.await()
        return Firebase.auth.currentUser
    }

    override fun signOut(): FirebaseUser? {
        firebaseAuth.signOut()
        return Firebase.auth.currentUser

    }

    override fun getUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override suspend fun sendPasswordReset(email: String) {
        firebaseAuth.sendPasswordResetEmail(email).await()
    }
}