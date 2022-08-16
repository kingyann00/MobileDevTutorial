package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var dice_Img:ImageView

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main)
        dice_Img = findViewById(R.id.diceImg)


        val rollButton: Button = findViewById(R.id.rollBtn);
        val etButton: Button = findViewById(R.id.editButton);
        rollButton.setOnClickListener{rollDice()}

        etButton.setOnClickListener{editPlayer(it)}
    }
    private  fun editPlayer(view: View){

        binding.apply {
            playerName.text = editPlayerNameET.text.toString()
            editPlayerNameET.text.clear()
            editPlayerNameET.clearFocus()
        }


        binding.playerName.setPaintFlags(View.INVISIBLE);

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


        binding.diceImg.setImageResource(diceResource)



        binding.numberTxt.text = randomNum.toString()
}
}