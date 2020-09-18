package by.adush.cryptocurrency.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import by.adush.cryptocurrency.BuildConfig
import by.adush.cryptocurrency.R
import kotlinx.android.synthetic.main.splash_layout.*

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.splash_layout)

        version.text = "${getString(R.string.version)} ${BuildConfig.VERSION_NAME}"

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        },2000)

    }



}