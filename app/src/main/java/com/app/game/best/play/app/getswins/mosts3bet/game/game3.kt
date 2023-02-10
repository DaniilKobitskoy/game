package com.app.game.best.play.app.getswins.mosts3bet.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

import com.app.game.best.play.app.getswins.mosts3bet.R
import com.app.game.best.play.app.getswins.mosts3bet.bindingActivityMain
import com.app.game.best.play.app.getswins.mosts3bet.databinding.FragmentGame3Binding

class game3 : Fragment() {
lateinit var binding: FragmentGame3Binding
    private val words = listOf("kotlin", "java", "python", "javascript")
    private var wordToGuess = words.random()
    private var incorrectGuesses = 0
    private var correctGuesses = 0
    private val maxIncorrectGuesses = 6
    private var txt: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGame3Binding.inflate(inflater, container, false)
        val root = binding.root
        var wordToGuessTextView = binding.wordToGuessTextView
        val guessEditText = root.findViewById<EditText>(R.id.guess_edit_text)
        val submitButton = root.findViewById<Button>(R.id.submit_button)

        root.findViewById<ImageView>(R.id.imageView3).setOnClickListener {

            var m = mainsmenu()
            var menu = requireFragmentManager().beginTransaction()
            menu.replace(bindingActivityMain.fg.id, m).commit()


        }
        submitButton.setOnClickListener {
            if (guessEditText.text.isNotEmpty()) {
                val guess = guessEditText.text.toString().toLowerCase()
                if (guess.length > 1 || !guess.matches(Regex("[a-z]"))) {
                    Toast.makeText(activity, "Please enter a single letter.", Toast.LENGTH_SHORT).show()
                } else if (wordToGuess.contains(guess)) {
                    correctGuesses++
                    updateWordToGuess()
                } else {
                    incorrectGuesses++
                    if (incorrectGuesses == maxIncorrectGuesses) {
                        wordToGuessTextView.text = "You lost! The word was $wordToGuess."
                    }
                }
                guessEditText.text.clear()
            }
        }

        return root
    }

    private fun updateWordToGuess() {
        val wordToGuessBuilder = StringBuilder()
        for (c in wordToGuess) {
            if (c in 'a'..'z' && c !in wordToGuessBuilder) {
                wordToGuessBuilder.append('_')
            } else {
                wordToGuessBuilder.append(c)
            }
        }
        var wordToGuessTextView = binding.wordToGuessTextView
        wordToGuessTextView.text = wordToGuessBuilder.toString()

        if (wordToGuessBuilder.toString() == wordToGuess) {
            wordToGuessTextView.text = "You won! The word was $wordToGuess."
        }
    }
}