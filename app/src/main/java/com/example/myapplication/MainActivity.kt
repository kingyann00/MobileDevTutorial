package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var dice_Img:ImageView
    lateinit var editPlayerNameET:EditText
    lateinit var playerName:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice_Img = findViewById(R.id.diceImg)


        val rollButton: Button = findViewById(R.id.rollBtn);
        val etButton: Button = findViewById(R.id.editButton);
        rollButton.setOnClickListener{rollDice()}
        playerName = findViewById(R.id.playerName)
        editPlayerNameET = findViewById(R.id.editPlayerNameET)
        etButton.setOnClickListener{editPlayer(it)}
    }
    private  fun editPlayer(view: View){



        playerName.text = editPlayerNameET.text
        editPlayerNameET.text.clear()
        editPlayerNameET.clearFocus()
        playerName.setPaintFlags(View.INVISIBLE);

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)


    }
    private fun rollDice(){
        Toast.makeText(this,"Roll!",Toast.LENGTH_SHORT).show()


        val randomNum = (1..6).random()


        val diceResource = when (randomNum){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6


        }


        dice_Img.setImageResource(diceResource)

        val numberText: TextView = findViewById(R.id.numberTxt)
        val fileName = "dice_".plus(randomNum)
        numberText.text = fileName
}
}