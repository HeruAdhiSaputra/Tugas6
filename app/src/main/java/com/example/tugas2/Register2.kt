package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas2.databinding.ActivityRegister2Binding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class Register2 : AppCompatActivity() {
    private lateinit var binding: ActivityRegister2Binding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding = ActivityRegister2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()



        binding.kembali.setOnClickListener{
            val intentHome = Intent(this,MainActivity::class.java)
            startActivity(intentHome) }

       binding.register.setOnClickListener{
           val email : String = binding.masukanemail.text.toString().trim()
           val password : String = binding.masukanpassword.text.toString().trim()
           val confirmPassword : String = binding.confirmpassword.text.toString().trim()

           if (email.isEmpty()){
               binding.masukanemail.error = "Masukan Email Dluu"
               binding.masukanemail.requestFocus()
               return@setOnClickListener
           }

           if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
               binding.masukanemail.error = "Salah Woi"
               binding.masukanemail.requestFocus()
               return@setOnClickListener
           }

           if (password.isEmpty() || password.length < 6 ){
               binding.masukanpassword.error = "Harus Lebih Dari 6 karakter Bro"
               binding.masukanpassword.requestFocus()
               return@setOnClickListener
           }

           if (password != confirmPassword){
               binding.confirmpassword.error = "Passwordnya harus Sama woi"
               binding.confirmpassword.requestFocus()
               return@setOnClickListener
           }
           registerUser(email,password)

       }








    }

    private fun registerUser(email : String, password: String){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
            if (it.isSuccessful){
                Intent (this,MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
            else{
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null){
            Intent(this,MainActivity::class.java).also {
                it.flags =Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }

}