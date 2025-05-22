package com.example.historyquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        // Find views
        val reviewHeaderTextView = findViewById<TextView>(R.id.reviewHeaderTextView)
        val reviewContentTextView = findViewById<TextView>(R.id.reviewContentTextView)
        val homeButton = findViewById<Button>(R.id.homeButton)
        val playAgainButton = findViewById<Button>(R.id.playAgainFromReviewButton)

        // Set header text
        reviewHeaderTextView.text = "Quiz Review"

        // Provide correct answers for all questions
        val reviewContent = """
            1. The Declaration of Independence was signed in 1776.
               Answer: TRUE - It was signed on July 4, 1776.
               
            2. World War II ended in 1945.
               Answer: TRUE - The war ended in September 1945 after Japan's surrender.
               
            3. The Berlin Wall fell in 1980.
               Answer: FALSE - The Berlin Wall fell in November 1989.
               
            4. The first Moon landing happened in 1969.
               Answer: TRUE - Apollo 11 landed on the Moon on July 20, 1969.
               
            5. The Roman Empire fell in the 15th century.
               Answer: FALSE - The Western Roman Empire fell in 476 CE (5th century).
        """.trimIndent()

        reviewContentTextView.text = reviewContent

        // Set up home button
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        // Set up play again button
        playAgainButton.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}


