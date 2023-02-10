package com.app.game.best.play.app.getswins.mosts3bet.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.game.best.play.app.getswins.mosts3bet.bindingActivityMain
import com.app.game.best.play.app.getswins.mosts3bet.databinding.FragmentMainsmenuBinding


class mainsmenu : Fragment() {
  lateinit var binding: FragmentMainsmenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentMainsmenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {

        val gm1 = game1()
        var next = requireFragmentManager().beginTransaction()
        next.replace(bindingActivityMain.fg.id, gm1).commit()

        }
        binding.button2.setOnClickListener {

            val gm2 = game2()
            var next = requireFragmentManager().beginTransaction()
            next.replace(bindingActivityMain.fg.id, gm2).commit()

        }
        binding.button3.setOnClickListener {

            val gm3 = game3()
            var next = requireFragmentManager().beginTransaction()
            next.replace(bindingActivityMain.fg.id, gm3).commit()

        }
    }

    companion object {

        fun newInstance() =
            mainsmenu()
    }
}