package com.example.testphotoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var image : ImageView
   var currentImage = 0
    val name = arrayOf("Virat kohli","Malla","Honey Singh","will Smith")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val prev = findViewById<ImageButton>(R.id.imageButton)
        val next = findViewById<ImageButton>(R.id.imageButton2)
        val showNane = findViewById<TextView>(R.id.textView2)


        prev.setOnClickListener {
          val idCurrentImageString ="pic$currentImage"
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)

         image = findViewById(idCurrentImageInt)
            image.alpha =0f

            currentImage = (4+ currentImage-1)%4
            val idImageToShowString = "pic$currentImage"

            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f

            showNane.text = name[currentImage]
        }
        next.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f

            currentImage = (4+ currentImage+1)%4
            val idImageToShowString = "pic$currentImage"

            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f
            showNane.text = name[currentImage]

        }
    }
}