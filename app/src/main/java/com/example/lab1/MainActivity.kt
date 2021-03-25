package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imie = findViewById<EditText>(R.id.imie)
        val nazwisko = findViewById<EditText>(R.id.nazwisko)
        val liczbaOcen = findViewById<EditText>(R.id.ocena)
        val przyciskOceny = findViewById<Button>(R.id.oceny_b)

        imie.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus) {
                //Toast.makeText(applicationContext, "Jest fokus", Toast.LENGTH_SHORT).show()
            } else if(!hasFocus && imie.text.isEmpty()) {
                Toast.makeText(applicationContext, "Pole imie nie moze byc puste", Toast.LENGTH_SHORT).show()
                imie.error="Imie nie może być puste!"
            }
        }
        nazwisko.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus) {
                //Toast.makeText(applicationContext, "Jest fokus", Toast.LENGTH_SHORT).show()
            } else if(!hasFocus && nazwisko.text.isEmpty()) {
                Toast.makeText(applicationContext, "Pole nazwisko nie moze byc puste", Toast.LENGTH_SHORT).show()
                nazwisko.error="Nazwisko nie może być puste!"
            }
        }
        liczbaOcen.setOnFocusChangeListener { _, hasFocus ->
            val test = liczbaOcen.text.toString()
            if(hasFocus) {
                //Toast.makeText(applicationContext, "Jest fokus", Toast.LENGTH_SHORT).show()
            } else if(!hasFocus && !test.equals("")) {
                if(liczbaOcen.text.toString().toInt() !in 5..15){
                    Toast.makeText(applicationContext, "Wpisz do 5 do 15!", Toast.LENGTH_SHORT).show()
                    liczbaOcen.error="Podaj oceny od 5 do 15!"
                }
            }
        }
        val ocenyTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val test = liczbaOcen.text.toString()
                if(!test.equals("")) {
                    if(liczbaOcen.text.toString().toInt() !in 5..15 || imie.text.toString().isEmpty() || nazwisko.text.toString().isEmpty()){
                        przyciskOceny.visibility = Button.INVISIBLE
                    }
                    else {
                        przyciskOceny.visibility = Button.VISIBLE
                    }
                }

            }
        }
      /*  liczbaOcen.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val test = liczbaOcen.text.toString()
                if(!test.equals("")) {
                    if(liczbaOcen.text.toString().toInt() !in 5..15){
                        przyciskOceny.visibility = Button.INVISIBLE
                    }
                }
            }
        }) */
        imie.addTextChangedListener(ocenyTextWatcher)
        nazwisko.addTextChangedListener(ocenyTextWatcher)
      liczbaOcen.addTextChangedListener(ocenyTextWatcher)
    }
}
