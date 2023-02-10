package com.app.game.best.play.app.getswins.mosts3bet.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.app.game.best.play.app.getswins.mosts3bet.R
import com.app.game.best.play.app.getswins.mosts3bet.bindingActivityMain


class game1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var buttons: Array<Array<Button?>>
    private var player1Turn = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_game1, container, false)
        buttons = arrayOf(
            arrayOf(root.findViewById(R.id.button_00), root.findViewById(R.id.button_01), root.findViewById(R.id.button_02)),
            arrayOf(root.findViewById(R.id.button_10), root.findViewById(R.id.button_11), root.findViewById(R.id.button_12)),
            arrayOf(root.findViewById(R.id.button_20), root.findViewById(R.id.button_21), root.findViewById(R.id.button_22))
        )
        root.findViewById<ImageView>(R.id.imageView).setOnClickListener {

            var m = mainsmenu()
            var menu = requireFragmentManager().beginTransaction()
            menu.replace(bindingActivityMain.fg.id, m).commit()


        }

        for (i in buttons.indices) {
            for (j in buttons[i].indices) {
                buttons[i][j]?.setOnClickListener {
                    if (buttons[i][j]?.text.toString().isEmpty()) {
                        buttons[i][j]?.text = if (player1Turn) "X" else "O"
                        if (checkForWin()) {
                            Toast.makeText(
                                requireContext(),
                                if (player1Turn) "Player 1 wins!" else "Player 2 wins!",
                                Toast.LENGTH_SHORT
                            ).show()
                            resetGame()
                        } else {
                            player1Turn = !player1Turn
                        }
                    }
                }
            }
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    private fun checkForWin(): Boolean {
        for (i in 0..2) {
            if (checkRowForWin(i) || checkColumnForWin(i) || checkDiagonalForWin()) {
                return true
            }
        }
        return false
    }

    private fun checkRowForWin(row: Int): Boolean {
        return buttons[row][0]?.text == buttons[row][1]?.text &&
                buttons[row][1]?.text == buttons[row][2]?.text &&
                buttons[row][0]?.text != ""
    }

    private fun checkColumnForWin(column: Int): Boolean {
        return buttons[0][column]?.text == buttons[1][column]?.text &&
                buttons[1][column]?.text == buttons[2][column]?.text &&
                buttons[0][column]?.text != ""
    }

    private fun checkDiagonalForWin(): Boolean {
        return buttons[0][0]?.text == buttons[1][1]?.text &&
                buttons[1][1]?.text == buttons[2][2]?.text  && buttons[0][0]?.text != ""
    }

    private fun resetGame() {
        for (i in buttons.indices) {
            for (j in buttons[i].indices) {
                buttons[i][j]?.text = ""
            }
        }
        player1Turn = true
    }
}