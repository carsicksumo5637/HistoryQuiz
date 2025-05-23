package com.example.historyquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views
        val startButton = findViewById<Button>(R.id.startButton)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val welcomeImageView = findViewById<ImageView>(R.id.welcomeImageView)

        // Set title text
        titleTextView.text = "History Quiz"

        // Set welcome image
        welcomeImageView.setImageResource(R.drawable.historyimg)

        // Set up button click listener to navigate to QuestionActivity
        startButton.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }
    }
}
// Code developed with assistance from Claude 3.7 Sonnet (Anthropic, 2025)
// History Quiz App - Kotlin Android Application
// Button implementation adapted from multiple sources:
// - W3Schools Android Tutorial: https://www.w3schools.com/

