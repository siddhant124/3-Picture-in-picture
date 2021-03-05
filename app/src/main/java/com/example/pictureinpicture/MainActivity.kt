package com.example.pictureinpicture

import android.app.PictureInPictureParams
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.view.Display;
import android.util.Rational
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.pictureinpicture.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root

        setContentView(view)

        binding.enterButton.setOnClickListener{
            val d: Display = windowManager.defaultDisplay
            val p = Point()
            d.getSize(p)
            val width: Int = p.x
            val height: Int = p.y

            val ratio = Rational(width, height)
            val pip_Builder = PictureInPictureParams.Builder()
            pip_Builder.setAspectRatio(ratio).build()
            enterPictureInPictureMode(pip_Builder.build())
        }

    }
}