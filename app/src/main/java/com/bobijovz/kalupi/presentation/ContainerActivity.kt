package com.bobijovz.kalupi.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bobijovz.kalupi.R
import com.bobijovz.kalupi.databinding.ActivityContainerBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ContainerActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        val binding = ActivityContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding.bottomNavigation.setupWithNavController(navHostFragment.navController)
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
            Toast.makeText(this, "${currentUser?.uid} Already Logged in", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Not logged in", Toast.LENGTH_LONG).show()
            signIn()
        }
    }

    private fun signIn(){
        auth.signInAnonymously()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser?.uid
                    Toast.makeText(this, "$user Logged in", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }


}