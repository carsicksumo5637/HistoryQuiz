﻿# HistoryQuiz

 1. Technical Specifications
Development Environment

Platform: Android Studio
Programming Language: Kotlin
Android studio- Meercat
Build System: Gradle

Architecture Pattern

Pattern: Activity-based navigation
Components: Multiple activities with Intent-based communication
UI Framework: Android Views with XML layouts


2. Application Flow and Navigation
User Journey

Welcome Screen: Users are greeted with the main interface
Start Quiz: Initiate the question session
Question Display: Present True/False questions sequentially
Answer Selection: Users select their responses
Score Display: Show immediate performance results
Review Section: Detailed review of all questions and answers

Navigation Structure
MainActivity (Start Screen)
    ↓
QuestionActivity (Quiz Interface)
    ↓
ScoreActivity (Performance Results)
    ↓
ReviewActivity (Detailed Review)

3
. Application Components
MainActivity

Purpose: Entry point and welcome interface
Key Features:

Start button to begin quiz
Clean, minimalist design
Navigation to question activity


Code Highlights: Intent-based navigation with activity finishing to prevent back navigation

QuestionActivity

Purpose: Core quiz functionality
Key Features:

Question display
True/False button interface
Answer processing logic
Progress indication


Expected Functionality: Sequential question presentation with user interaction handling

ScoreActivity

Purpose: Display quiz performance and results
Key Features:

Final score presentation
Performance percentage calculation
Success/completion feedback
Navigation to detailed review


Expected Functionality: Score calculation and motivational feedback display

ReviewActivity

Purpose: Results display and comprehensive review
Key Features:

Question and answer summary
Performance overview
Learning reinforcement through review


Code Highlights: Multi-line string formatting using Kotlin's trimIndent() function
