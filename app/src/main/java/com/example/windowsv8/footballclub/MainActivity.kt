package com.example.windowsv8.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class MainActivity : AppCompatActivity() {

    var clubItem : MutableList<Club> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(this, clubItem){
            startActivity<DetailActivity>(DetailActivity.POSITIONEXTRA to it)
            toast("Anda Memilih ${it.nama}")
        }
//        verticalLayout {
//            lparams(matchParent, matchParent)
//            orientation = LinearLayout.VERTICAL
//
//            recyclerView {
//                lparams(matchParent, matchParent)
//                layoutManager = LinearLayoutManager(context)
//                adapter = Adapter(context, clubItem){
////                    startActivity<DetailActivity>("name")
//                    startActivity<DetailActivity>(DetailActivity.POSITIONEXTRA to it)
//                    toast("Anda Memilih ${it.nama}")
//                    //Toast.makeText(context, it.nama, Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val keterangan = resources.getStringArray(R.array.club_deskripsi)

        clubItem.clear()

        for (i in name.indices){
            clubItem.add(Club(name[i], image.getResourceId(i, 0), keterangan[i]))
        }
        Log.e("hasil", clubItem.size.toString())

        image.recycle()
    }

}
