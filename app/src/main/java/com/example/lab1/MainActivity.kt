package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Button





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

         fun validate_imie() : Boolean{
            if(imie.text.toString().isEmpty()){
                imie.error = "Imie nie może być puste!"
                Toast.makeText(applicationContext,"Imie nie może być puste!",Toast.LENGTH_SHORT).show()
                return false
            }
            else
                return true
         }
        fun validate_nazwisko() : Boolean{
            if(nazwisko.text.toString().isEmpty()){
                nazwisko.error = "Nazwisko nie może być puste!"
                Toast.makeText(applicationContext,"Nazwisko nie może być puste!",Toast.LENGTH_SHORT).show()
                return false
            }
            else
                return  true

        }
        fun validate_oceny() : Boolean{
            if(oceny.text.toString().toInt() in 5..15){
                return true
            }
            else
            {
                oceny.error = "Wpisz oceny od 5 do 15!"
                Toast.makeText(applicationContext,"Wpisz oceny od 5 do 15!",Toast.LENGTH_SHORT).show()
                return false
            }
        }


        imie.onFocusChangeListener = View.OnFocusChangeListener{ view, b ->
            if(b){
               // Toast.makeText(applicationContext,"jest fokus",Toast.LENGTH_LONG).show()
            }
            else{

               // Toast.makeText(applicationContext,"utrata fokusa",Toast.LENGTH_LONG).show()
                when (validate_imie() && validate_nazwisko() && validate_oceny() ) {
                    true -> button.setVisibility(View.VISIBLE)
                    false ->  button.setVisibility(View.INVISIBLE)
                }
            }
        }

        nazwisko.onFocusChangeListener = View.OnFocusChangeListener{view, b ->
            if(b){
            }
            else{
                when (validate_nazwisko() && validate_nazwisko() && validate_oceny() ) {
                    true -> button.setVisibility(View.VISIBLE)
                    false ->  button.setVisibility(View.INVISIBLE)
                }
            }
        }

        oceny.onFocusChangeListener = View.OnFocusChangeListener{view, b->
            if(b){
            }
            else{
                when (validate_nazwisko() && validate_nazwisko() && validate_oceny() ) {
                    true -> button.setVisibility(View.VISIBLE)
                    false ->  button.setVisibility(View.INVISIBLE)
                }
            }
        }

        button.setOnClickListener{
            val text = imie.text
            Toast.makeText(applicationContext,text,Toast.LENGTH_SHORT).show()
        }
    }
}