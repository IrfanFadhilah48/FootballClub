package com.example.windowsv8.footballclub

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ClubUI : AnkoComponent<ViewGroup>{

    companion object {
        val nameId = 1
        val imageId = 2
        val a = 1
    }
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        linearLayout{
            orientation = LinearLayout.HORIZONTAL
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView{
                id = imageId
                imageResource = R.drawable.img_mu

            }.lparams(dip(50), dip(50))

            textView{
                id = nameId
                text = "MUFC"
            }.lparams(matchParent, wrapContent){
                margin = dip(10)
                gravity = Gravity.CENTER_VERTICAL
            }
        }
    }

}