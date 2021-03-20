package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import androidx.core.widget.addTextChangedListener



class MainActivity : AppCompatActivity() {
    lateinit var imie : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.oceny_b)
        val imie = findViewById<EditText>(R.id.imie)
        val nazwisko = findViewById<EditText>(R.id.nazwisko)
        val oceny = findViewById<EditText>(R.id.ocena)
        val fokus = findViewById<TextView>(R.id.fokus)


        imie.onFocusChangeListener = View.OnFocusChangeListener{ view, b ->
            if(b){
              //  Toast.makeText(applicationContext,"jest fokus",Toast.LENGTH_LONG).show()
            }
            else{
               // Toast.makeText(applicationContext,"utrata fokusa",Toast.LENGTH_LONG).show()
                imie.addTextChangedListener(object : TextWatcher {

                    override fun afterTextChanged(s: Editable?) {
                        val msg: String = imie.text.toString()
                        
                    }

                    override fun beforeTextChanged(s: CharSequence, start: Int,
                                                   count: Int, after: Int) {
                    }

                    override fun onTextChanged(s: CharSequence, start: Int,
                                               before: Int, count: Int) {
                        if(start == 0) {
                            Toast.makeText(applicationContext,"Uzupełnij imie",Toast.LENGTH_SHORT).show()
                        }

                    }
                })
            }

        }


        button.setOnClickListener{
            val text = imie.text

            Toast.makeText(applicationContext,text,Toast.LENGTH_SHORT).show()

        }

    }



}