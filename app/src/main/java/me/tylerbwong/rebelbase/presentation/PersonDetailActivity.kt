package me.tylerbwong.rebelbase.presentation

import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.transition.Transition
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_person_detail.*
import me.tylerbwong.rebelbase.R

/**
 * @author Tyler Wong
 */
class PersonDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_detail)

        val fade: Transition = Fade()
        fade.excludeTarget(R.id.app_bar, true)
        fade.excludeTarget(android.R.id.statusBarBackground, true)
        fade.excludeTarget(android.R.id.navigationBarBackground, true)
        window.enterTransition = fade
        window.exitTransition = fade

        val imageUrl = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")

        setSupportActionBar(this.toolbar)
        supportActionBar?.title = name

        ViewCompat.setTransitionName(this.image, imageUrl)

        val options: RequestOptions = RequestOptions()
                .dontAnimate()

        Glide.with(this)
                .load(imageUrl)
                .apply(options)
                .into(this.image)
    }
}