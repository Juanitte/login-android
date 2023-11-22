package com.example.loginjuanhermo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.loginjuanhermo.util.AppData

class LoginActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogout: Button = findViewById(R.id.btn_logout)

        btnLogout.setOnClickListener {
            AppData.isLogged = false
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val imgSettings: ImageView = findViewById(R.id.img_settings2)

        imgSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        if(AppData.isDarkMode) {
            var color = resources.getColor(R.color.darkmode_background, theme)
            findViewById<View>(android.R.id.content).setBackgroundColor(color)

            val lblTitle: TextView = findViewById(R.id.lbl_title2)
            color = resources.getColor(R.color.white)
            lblTitle.setTextColor(color)

            val lblMessage: TextView = findViewById(R.id.lbl_message)
            lblMessage.setTextColor(color)

            val btnLogout: Button = findViewById(R.id.btn_logout)
            color = resources.getColor(R.color.darkmode_button)
            btnLogout.setBackgroundColor(color)

        } else {
            var color = resources.getColor(R.color.white, theme)
            findViewById<View>(android.R.id.content).setBackgroundColor(color)

            val lblTitle: TextView = findViewById(R.id.lbl_title2)
            color = resources.getColor(R.color.black)
            lblTitle.setTextColor(color)

            val lblMessage: TextView = findViewById(R.id.lbl_message)
            lblMessage.setTextColor(color)

            val btnLogout: Button = findViewById(R.id.btn_logout)
            color = resources.getColor(R.color.lightmode_button)
            btnLogout.setBackgroundColor(color)
        }
    }
}