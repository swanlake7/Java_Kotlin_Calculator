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

var op = "*"
var oldNum = ""
var isNewOp = true

    fun buEvnt(view:View){
        if(isNewOp == true){
            viewText.setText("")
        }
        isNewOp = false
        //sel = clicked button
        var sel = view as Button
        //clicked= what's displayed on screen
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

    fun buOpEv(view:View){
        val sel = view as Button
        when(sel.id){
            buDiv.id ->{ op = "/"}
            buMult.id->{  op = "*"}
            buMinus.id -> { op = "-"}
            buPlus.id -> { op = "+"}
        }
        oldNum = viewText.text.toString()
        isNewOp = true
    }

    fun buEqlEvnt(view:View){
        var newNum = viewText.text.toString()
        var finalNum:Double?=null
        when(op){
            "*" ->{finalNum = oldNum.toDouble() * newNum.toDouble()}
            "/" ->{finalNum = oldNum.toDouble() / newNum.toDouble()}
            "-" ->{finalNum = oldNum.toDouble() - newNum.toDouble()}
            "+" ->{finalNum = oldNum.toDouble() + newNum.toDouble()}
        }
        viewText.setText(finalNum.toString())
        isNewOp = true
    }

    fun buPercEvnt(view:View){
        var num:Double = viewText.text.toString().toDouble()/100
        viewText.setText(num.toString())
    }

    fun buCleanEvnt(view: View){
        viewText.setText("")
        isNewOp= true
    }

}
