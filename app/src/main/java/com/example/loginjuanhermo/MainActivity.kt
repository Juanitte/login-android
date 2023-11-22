package com.example.loginjuanhermo

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.loginjuanhermo.util.AppData
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.Locale

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(!AppData.isEnglish) {
            val locale = Locale("es")
            val config = resources.configuration
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        } else{
            val locale = Locale("en")
            val config = resources.configuration
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        }

        setContentView(R.layout.activity_main)

        val btnLogin: Button = findViewById(R.id.btn_login)
        val tilUsername: TextInputLayout = findViewById(R.id.til_username)
        val txtUsername: EditText? = tilUsername.editText
        val tilPassword: TextInputLayout = findViewById(R.id.til_password)
        val txtPassword: EditText? = tilPassword.editText
        val lblUserError: TextView = findViewById(R.id.lbl_userError)
        val lblPasswordError: TextView = findViewById(R.id.lbl_passwordError)

        lblUserError.visibility = View.INVISIBLE
        lblPasswordError.visibility = View.INVISIBLE

        btnLogin.setOnClickListener {
            val usernameText = txtUsername?.text?.toString()
            val passwordText = txtPassword?.text?.toString()
            if(!usernameText.isNullOrBlank() && usernameText.equals("user") || usernameText.equals("User")) {
                lblUserError.visibility = View.INVISIBLE
                if(!passwordText.isNullOrBlank() && passwordText.equals("1234")) {
                    AppData.isLogged = true
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    lblPasswordError.visibility = View.VISIBLE
                }
            } else{
                lblUserError.visibility = View.VISIBLE
            }
        }

        val imgSettings: ImageView = findViewById(R.id.img_settings)

        imgSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        if(AppData.isDarkMode) {
            var color = resources.getColor(R.color.darkmode_background, theme)
            findViewById<View>(android.R.id.content).setBackgroundColor(color)

            val lblTitle: TextView = findViewById(R.id.lbl_title)
            color = resources.getColor(R.color.white)
            lblTitle.setTextColor(color)

            val lblUsername: TextView = findViewById(R.id.lbl_username)
            lblUsername.setTextColor(color)

            val lblPassword: TextView = findViewById(R.id.lbl_password)
            lblPassword.setTextColor(color)

            val btnLogin: Button = findViewById(R.id.btn_login)
            color = resources.getColor(R.color.darkmode_button)
            btnLogin.setBackgroundColor(color)

            val btnSignup: Button = findViewById(R.id.btn_signup)
            btnSignup.setBackgroundColor(color)
            color = resources.getColor(R.color.darkmode_background)
            btnSignup.setTextColor(color)
        } else {
            var color = resources.getColor(R.color.white, theme)
            findViewById<View>(android.R.id.content).setBackgroundColor(color)

            val lblTitle: TextView = findViewById(R.id.lbl_title)
            color = resources.getColor(R.color.black)
            lblTitle.setTextColor(color)

            val lblUsername: TextView = findViewById(R.id.lbl_username)
            lblUsername.setTextColor(color)

            val lblPassword: TextView = findViewById(R.id.lbl_password)
            lblPassword.setTextColor(color)

            val btnLogin: Button = findViewById(R.id.btn_login)
            color = resources.getColor(R.color.lightmode_button)
            btnLogin.setBackgroundColor(color)

            val btnSignup: Button = findViewById(R.id.btn_signup)
            color = resources.getColor(R.color.lightmode_button)
            btnSignup.setBackgroundColor(color)
        }
    }
}