package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollBtn);
        rollButton.setOnClickListener{rollDice()}
    }
    private fun rollDice(){
        Toast.makeText(this,"Roll!",Toast.LENGTH_SHORT).show()

        val randomNum = (1..6).random()

        val numberText: TextView = findViewById(R.id.numberTxt)
        numberText.text = randomNum.toString()
    }
}