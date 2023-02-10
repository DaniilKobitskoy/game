package com.app.game.best.play.app.getswins.mosts3bet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.app.game.best.play.app.getswins.mosts3bet.game.mainsmenu
import com.app.game.best.play.app.getswins.mosts3bet.R
import com.app.game.best.play.app.getswins.mosts3bet.databinding.ActivityMainBinding

lateinit var bindingActivityMain: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivityMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingActivityMain.root)
supportFragmentManager
    .beginTransaction()
    .replace(bindingActivityMain.fg.id, mainsmenu())
    .commit()
        var txt = bindingActivityMain.textView
//        var anim = ObjectAnimator.ofFloat(txt, "alpha", 1f, 0f)
//        anim.start()
var anim = AnimationUtils.loadAnimation(this, R.anim.anim)
        bindingActivityMain.textView.startAnimation( anim)
anim.setAnimationListener(object : Animation.AnimationListener {
    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {

        bindingActivityMain.fg.visibility = View.VISIBLE
        bindingActivityMain.textView.visibility = View.GONE
        bindingActivityMain.loader.visibility = View.GONE
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }
})
    }
    override fun onBackPressed() {
        if ( bindingActivityMain.fg.isFocused() ) {

        } else {
        }
    }
}