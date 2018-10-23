package com.example.windowsv8.footballclub

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity(){

    companion object {
        val infoID = 3
        val POSITIONEXTRA = "position"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent  = intent
        val list = intent.getParcelableExtra<Club>(POSITIONEXTRA)

        DetailActivityUI(list).setContentView(this)
    }

    class DetailActivityUI(var list : Club): AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) =  with(ui) {
            verticalLayout() {
                lparams(matchParent, matchParent)

                linearLayout(){
                    orientation = LinearLayout.HORIZONTAL
                    lparams(matchParent, wrapContent)
                    gravity = Gravity.CENTER_HORIZONTAL

                    imageView(){
                        Glide.with(this).load(list.image).into(this)
                        id = ClubUI.imageId
                        padding = dip(10)
//                        Gravity.CENTER_HORIZONTAL
                    }.lparams(dip(120), dip(100))
                }


                textView(){
                    id = ClubUI.nameId
                    text = list.nama
                    textSize = sp(14).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)
                }

                textView(){
                    id = infoID
                    text = list.keterangan
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)

                }
            }
        }
    }
}