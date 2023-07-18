package com.pjatk.bmi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pjatk.bmi.R
import com.pjatk.bmi.model.Question

class QuizFragment : Fragment() {

    private lateinit var mQuestionTextView: TextView
    private lateinit var mRadioGroup: RadioGroup
    private lateinit var mRadioButton1: RadioButton
    private lateinit var mRadioButton2: RadioButton
    private lateinit var mRadioButton3: RadioButton
    private lateinit var mNextButton: Button

    private var questionList = arrayListOf<com.pjatk.bmi.model.Question>()
    private var mCurrentIndex = 0
    private var mScore = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)

        mQuestionTextView = view.findViewById(R.id.question_text_view)
        mRadioGroup = view.findViewById(R.id.answer_radio_group)
        mRadioButton1 = view.findViewById(R.id.choice_a_button)
        mRadioButton2 = view.findViewById(R.id.choice_b_button)
        mRadioButton3 = view.findViewById(R.id.choice_c_button)
        mNextButton = view.findViewById(R.id.submit_button)

        initiateQuestions()

        mCurrentIndex = 0
        mScore = 0
        setQuestion()

        mNextButton.setOnClickListener {
            checkAnswer()
            mCurrentIndex++
            if (mCurrentIndex < questionList.size) {
                setQuestion()
            } else {
                endQuiz()
            }
        }

        return view
    }

    private fun setQuestion() {
        // Set the question text
        mQuestionTextView.text = questionList[mCurrentIndex].question

        // Set the answer choices
        mRadioButton1.text = questionList[mCurrentIndex].answers[0]
        mRadioButton2.text = questionList[mCurrentIndex].answers[1]
        mRadioButton3.text = questionList[mCurrentIndex].answers[2]

        // Clear the radio button selection
        mRadioGroup.clearCheck()
    }

    private fun checkAnswer() {
        // Get the index of the correct answer
        val correctAnswerIndex = questionList[mCurrentIndex].correctAnswerIndex

        // Check if the selected answer is correct
        val selectedAnswerIndex = mRadioGroup.checkedRadioButtonId
        if (selectedAnswerIndex != -1) {
            val selectedAnswer = view?.findViewById<RadioButton>(selectedAnswerIndex)
            val selectedAnswerValue = mRadioGroup.indexOfChild(selectedAnswer)
            if (selectedAnswerValue == correctAnswerIndex) {
                mScore++
            }
        }
    }

    private fun endQuiz() {
        // Show the final score and reset the quiz
        val text = "Your score is $mScore out of ${questionList.size}"
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
        mCurrentIndex = 0
        mScore = 0
        setQuestion()
    }

    private fun initiateQuestions() {
        questionList = arrayListOf(
                com.pjatk.bmi.model.Question(getString(R.string.question_1), arrayOf(getString(R.string.q1_answer_a), getString(R.string.q1_answer_b), getString(R.string.q1_answer_c)), resources.getString(R.string.q1_answer_correct_index).toInt()),
                com.pjatk.bmi.model.Question(getString(R.string.question_2), arrayOf(getString(R.string.q2_answer_a), getString(R.string.q2_answer_b), getString(R.string.q2_answer_c)), resources.getString(R.string.q2_answer_correct_index).toInt()),
                com.pjatk.bmi.model.Question(getString(R.string.question_3), arrayOf(getString(R.string.q3_answer_a), getString(R.string.q3_answer_b), getString(R.string.q3_answer_c)), resources.getString(R.string.q3_answer_correct_index).toInt()),
                com.pjatk.bmi.model.Question(getString(R.string.question_4), arrayOf(getString(R.string.q4_answer_a), getString(R.string.q4_answer_b), getString(R.string.q4_answer_c)), resources.getString(R.string.q4_answer_correct_index).toInt()),
                com.pjatk.bmi.model.Question(getString(R.string.question_5), arrayOf(getString(R.string.q5_answer_a), getString(R.string.q5_answer_b), getString(R.string.q5_answer_c)), resources.getString(R.string.q5_answer_correct_index).toInt()),
                com.pjatk.bmi.model.Question(getString(R.string.question_6), arrayOf(getString(R.string.q6_answer_a), getString(R.string.q6_answer_b), getString(R.string.q6_answer_c)), resources.getString(R.string.q6_answer_correct_index).toInt())
        )
    }
}