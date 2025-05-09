package com.example.tugas2

import android.content.Intent
import android.media.RouteListingPreference.Item
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas2.databinding.ActivityHalamanutamaBinding
import com.example.tugas2.databinding.ActivityLupapasswordBinding
import com.google.firebase.auth.FirebaseAuth

class Halamanutama : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityHalamanutamaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_halamanutama)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        binding = ActivityHalamanutamaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.idToolbar)

        auth = FirebaseAuth.getInstance()

        binding.massage.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT ,  binding.editText2.text.toString() )
            intent.type = "text/plain"

            startActivity(Intent(Intent.createChooser(intent,"Share to")))

        }

        binding.call.setOnClickListener{
            val uri = Uri.parse("tel" + binding.editText3.text.toString())
            startActivity(Intent(Intent.ACTION_DIAL,uri))
        }

        binding.maps.setOnClickListener{
            val uri = Uri.parse("geo:0,0?q=" + binding.editText5.text.toString())
            startActivity(Intent(Intent.ACTION_VIEW,uri))
        }

        binding.url.setOnClickListener{
            val uri = Uri.parse(binding.editText4.text.toString())
            startActivity(Intent(Intent.ACTION_VIEW,uri))
        }

        binding.imageView4.setOnClickListener{
            startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }

        binding.imageView5.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("content://media//external/images/media/")
            startActivity(intent)

        }

        binding.alaram.setOnClickListener{
            startActivity(Intent(AlarmClock.ACTION_SHOW_ALARMS))
        }

        binding.textView5.setOnClickListener{
            val intentHome = Intent(this,database::class.java)
            startActivity(intentHome) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Logout -> {
                auth.signOut()
                startActivity(Intent(this,MainActivity::class.java))
                return true
            }
            R.id.Register -> {
                auth.signOut()
                startActivity(Intent(this,Register2::class.java))
                return true
            }
            R.id.Profil -> {
                startActivity(Intent(this,Profil::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }
}