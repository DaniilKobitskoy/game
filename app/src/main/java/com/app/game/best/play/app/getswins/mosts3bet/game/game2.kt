package com.app.game.best.play.app.getswins.mosts3bet.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.app.game.best.play.app.getswins.mosts3bet.R
import com.app.game.best.play.app.getswins.mosts3bet.bindingActivityMain


class game2 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var targetNumber = (1..100).random()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_game2, container, false)
        val submitButton = root.findViewById<Button>(R.id.submit_button)
        val guessEditText = root.findViewById<EditText>(R.id.guess_edit_text)
        val resultTextView = root.findViewById<TextView>(R.id.result_text_view)
        root.findViewById<ImageView>(R.id.imageView2).setOnClickListener {

            var m = mainsmenu()
            var menu = requireFragmentManager().beginTransaction()
            menu.replace(bindingActivityMain.fg.id, m).commit()


        }
        submitButton.setOnClickListener {
            if (guessEditText.text.isNotEmpty()) {
                val guess = guessEditText.text.toString().toInt()
                if (guess == targetNumber) {
                    resultTextView.text = "You got it! The number was $targetNumber."
                    targetNumber = (1..100).random()
                } else if (guess < targetNumber) {
                    resultTextView.text = "The number is higher."
                } else {
                    resultTextView.text = "The number is lower."
                }
            }
        }

        return root
    }
}