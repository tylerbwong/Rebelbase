package me.tylerbwong.rebelbase.presentation

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewTreeObserver
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_person_detail.*
import me.tylerbwong.rebelbase.R


/**
 * @author Tyler Wong
 */
class PersonDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_detail)

        val imageUrl = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")

        setSupportActionBar(this.toolbar)
        supportActionBar?.title = name
        ViewCompat.setTransitionName(this.appBar, "actionBar")
        ViewCompat.setTransitionName(this.image, imageUrl)

        supportPostponeEnterTransition()

        val decor: View = window.decorView
        decor.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                decor.viewTreeObserver.removeOnPreDrawListener(this)
                loadImage(imageUrl)
                return true
            }
        })
    }

    private fun loadImage(imageUrl: String) {
        val options: RequestOptions = RequestOptions()
                .dontAnimate()

        Glide.with(this)
                .load(imageUrl)
                .apply(options)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        supportStartPostponedEnterTransition()
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        supportStartPostponedEnterTransition()
                        return false
                    }
                })
                .into(this.image)
    }
}