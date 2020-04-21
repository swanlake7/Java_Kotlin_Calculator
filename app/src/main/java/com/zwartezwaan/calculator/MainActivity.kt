package com.zwartezwaan.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buEvnt(view:View){
        var data = viewText.text
        var sel = view as Button
        var clicked:String = viewText.text.toString()
        when(sel.id){
            bu0.id -> {clicked +="0"}
            bu1.id -> {clicked +="1"}
            bu2.id -> {clicked +="2"}
            bu3.id -> {clicked +="3"}
            bu4.id -> {clicked +="4"}
            bu5.id -> {clicked +="5"}
            bu6.id -> {clicked +="6"}
            bu7.id -> {clicked +="7"}
            bu8.id -> {clicked +="8"}
            bu9.id -> {clicked +="9"}
            //try to prevent adding more than one dot
            buDot.id -> {clicked +="."}
            buPlMi.id -> {clicked ="-" + clicked}
        }
        viewText.setText(clicked)
    }
}
