package com.example.historyquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        // Get score from intent
        val score = intent.getIntExtra("SCORE", 0)
        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 5)

        // Find views
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val scoreMessageTextView = findViewById<TextView>(R.id.scoreMessageTextView)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val playAgainButton = findViewById<Button>(R.id.playAgainButton)

        // Set score text
        scoreTextView.text = "Your Score: $score out of $totalQuestions"

        // Set feedback message based on score
        val message = when {
            score == totalQuestions -> "Perfect! Amazing job!"
            score >= totalQuestions * 0.8 -> "Excellent! You're a history buff!"
            score >= totalQuestions * 0.6 -> "Good job! You know your history!"
            score >= totalQuestions * 0.4 -> "Not bad! Keep learning!"
            else -> "Keep studying history! You'll improve!"
        }
        scoreMessageTextView.text = message

        // Set up review button
        reviewButton.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }

        // Set up play again button
        playAgainButton.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
            finish()
        // Code developed with assistance from Claude 3.7 Sonnet (Anthropic, 2025)
        // History Quiz App - Kotlin Android Application
        // Button implementation adapted from multiple sources:
        // - W3Schools Android Tutorial: https://www.w3schools.com/
        // W3Schools. (2025) *Kotlin Tutorial*. Available at: https://www.w3schools.com/kotlin/ (Accessed: 22 May 2025).
        // - Stack Overflow answer by [Username]: https://stackoverflow.com/questions/[id]
        // Accessed: 22 May 2025
        // Generated: May 19, 2025


        }
    }
}