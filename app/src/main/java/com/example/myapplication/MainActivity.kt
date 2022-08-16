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
    private  val gameinfo: GameInfo = GameInfo(playerName = "Hon", totalScore = "0")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main)

        binding.gameInfo = gameinfo

        val rollButton: Button = findViewById(R.id.rollBtn);
        val etButton: Button = findViewById(R.id.editButton);
        rollButton.setOnClickListener{rollDice(it)}

        etButton.setOnClickListener{editPlayer(it)}
    }
    private  fun editPlayer(view: View){

        binding.apply {
            gameInfo?.playerName = editPlayerNameET.text.toString()
            invalidateAll()
        }


        binding.playerName.setPaintFlags(View.INVISIBLE);

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)


    }
    private fun rollDice(view: View){
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



        binding.apply {
            diceImg.setImageResource(diceResource)
            gameInfo?.totalScore = (Integer.parseInt(binding.gameInfo?.totalScore) + randomNum).toString()
            invalidateAll()
        }

}
}