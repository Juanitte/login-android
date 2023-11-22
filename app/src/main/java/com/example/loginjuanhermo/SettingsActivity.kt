package com.example.loginjuanhermo

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.loginjuanhermo.util.AppData
import java.util.Locale

class SettingsActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val imgBack: ImageView = findViewById(R.id.img_back)

        imgBack.setOnClickListener {
            if(!AppData.isLogged) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

        val switchTheme: Switch = findViewById(R.id.switch_theme)
        val switchLanguage: Switch = findViewById(R.id.switch_language)

        if(AppData.isEnglish) {
            switchLanguage.isChecked = true
        } else {
            switchLanguage.isChecked = false
        }

        if(AppData.isDarkMode) {
            var color = resources.getColor(R.color.darkmode_background, theme)
            findViewById<View>(android.R.id.content).setBackgroundColor(color)

            val lblTitle: TextView = findViewById(R.id.lbl_settings_title)
            color = resources.getColor(R.color.white)
            lblTitle.setTextColor(color)

            val lblTheme: TextView = findViewById(R.id.lbl_theme)
            lblTheme.setTextColor(color)

            val lblLanguage: TextView = findViewById(R.id.lbl_language)
            lblLanguage.setTextColor(color)
            switchTheme.isChecked = true
        } else {
            var color = resources.getColor(R.color.white, theme)
            findViewById<View>(android.R.id.content).setBackgroundColor(color)

            val lblTitle: TextView = findViewById(R.id.lbl_settings_title)
            color = resources.getColor(R.color.black)
            lblTitle.setTextColor(color)

            val lblTheme: TextView = findViewById(R.id.lbl_theme)
            lblTheme.setTextColor(color)

            val lblLanguage: TextView = findViewById(R.id.lbl_language)
            lblLanguage.setTextColor(color)
            switchTheme.isChecked = false
        }

        switchTheme.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                AppData.isDarkMode = true
                changeTheme(true)
            } else {
                AppData.isDarkMode = false
                changeTheme(false)
            }
        }
        switchLanguage.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                AppData.isEnglish = true
                val locale = Locale("en")
                val config = resources.configuration
                config.setLocale(locale)
                resources.updateConfiguration(config, resources.displayMetrics)
                val refreshIntent = Intent(this, javaClass)
                startActivity(refreshIntent)
                finish()
            } else {
                AppData.isEnglish = false
                val locale = Locale("es")
                val config = resources.configuration
                config.setLocale(locale)
                resources.updateConfiguration(config, resources.displayMetrics)
                val refreshIntent = Intent(this, javaClass)
                startActivity(refreshIntent)
                finish()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun changeTheme(isDarkMode: Boolean) {
        if(isDarkMode) {
            var color = resources.getColor(R.color.darkmode_background, theme)
            findViewById<View>(android.R.id.content).setBackgroundColor(color)

            val lblTitle: TextView = findViewById(R.id.lbl_settings_title)
            color = resources.getColor(R.color.white)
            lblTitle.setTextColor(color)

            val lblTheme: TextView = findViewById(R.id.lbl_theme)
            lblTheme.setTextColor(color)

            val lblLanguage: TextView = findViewById(R.id.lbl_language)
            lblLanguage.setTextColor(color)
        } else {
            var color = resources.getColor(R.color.white, theme)
            findViewById<View>(android.R.id.content).setBackgroundColor(color)

            val lblTitle: TextView = findViewById(R.id.lbl_settings_title)
            color = resources.getColor(R.color.black)
            lblTitle.setTextColor(color)

            val lblTheme: TextView = findViewById(R.id.lbl_theme)
            lblTheme.setTextColor(color)

            val lblLanguage: TextView = findViewById(R.id.lbl_language)
            lblLanguage.setTextColor(color)
        }
    }
}