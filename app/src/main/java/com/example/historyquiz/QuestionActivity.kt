
package com.example.historyquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity : AppCompatActivity() {
    // List of questions
    private val questions = listOf(
        Question("The Declaration of Independence was signed in 1776.", true),
        Question("World War II ended in 1945.", true),
        Question("The Berlin Wall fell in 1980.", false),
        Question("The first Moon landing happened in 1969.", true),
        Question("The Roman Empire fell in the 15th century.", false)
    )

    private var currentQuestionIndex = 0
    private var score = 0
    private val userAnswers = mutableListOf<Boolean?>()

    // Views
    private lateinit var questionTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionCounterTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        // Initialize views
        questionTextView = findViewById(R.id.questionTextView)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)
        questionCounterTextView = findViewById(R.id.questionCounterTextView)

        // Initialize answers array
        for (i in questions.indices) {
            userAnswers.add(null)
        }

        // Display first question
        updateQuestion()

        // Set up answer buttons
        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        // Set up next button
        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                updateQuestion()
            } else {
                // Show score screen when all questions are answered
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("TOTAL_QUESTIONS", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun updateQuestion() {
        // Update question text
        questionTextView.text = questions[currentQuestionIndex].text

        // Update question counter
        questionCounterTextView.text = "Question ${currentQuestionIndex + 1} of ${questions.size}"

        // Reset feedback
        feedbackTextView.text = ""
        feedbackTextView.visibility = View.INVISIBLE

        // Enable answer buttons if not answered yet
        val answered = userAnswers[currentQuestionIndex] != null
        trueButton.isEnabled = !answered
        falseButton.isEnabled = !answered

        // Only show Next button after answering
        nextButton.visibility = if (answered) View.VISIBLE else View.INVISIBLE
    }

    private fun checkAnswer(answer: Boolean) {
        val correctAnswer = questions[currentQuestionIndex].answer
        val isCorrect = answer == correctAnswer

        // Save user's answer
        userAnswers[currentQuestionIndex] = answer

        // Update score if correct
        if (isCorrect) {
            score++
        }

        // Show feedback
        if (isCorrect) {
            feedbackTextView.text = "Correct! Good job!"
        } else {
            feedbackTextView.text = "Incorrect! Nice try."
        }

        feedbackTextView.visibility = View.VISIBLE

        // Show toast with feedback
        Toast.makeText(
            this,
            if (isCorrect) "Correct!" else "Incorrect!",
            Toast.LENGTH_SHORT
        ).show()

        // Disable answer buttons after answering
        trueButton.isEnabled = false
        falseButton.isEnabled = false

        // Show Next button
        nextButton.visibility = View.VISIBLE
    }
}
// Code developed with assistance from Claude 3.7 Sonnet (Anthropic, 2025)
// History Quiz App - Kotlin Android Application
// Button implementation adapted from multiple sources:
// - W3Schools Android Tutorial: https://www.w3schools.com/