package com.example.doublediceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Find the button in the layout
        val rollButton: Button = findViewById(R.id.button)
        //Set a click listener on the roll button to roll the dice when the user clicks the button
        rollButton.setOnClickListener { rollDice() }

        //Do a dice roll when app starts
        rollDice()
    }

    private fun rollDice() {
        //Create the two dices and roll them
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val diceRoll1 = dice1.roll()
        val diceRoll2 = dice2.roll()

        //Update the screen with the result of the roll of the two dice
        val resultTextView1: TextView = findViewById(R.id.textView4)
        resultTextView1.text = diceRoll1.toString()
        val resultTextView2: TextView = findViewById(R.id.textView3)
        resultTextView2.text = diceRoll2.toString()

        //Find the image in the layout
        val diceImage1: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        //Determine which drawable resource to use on dice roll
        val drawableResource1 = when (diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Update the ImageView with the correct drawable resource ID
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)

        //Update the content description
        diceImage1.contentDescription = diceRoll1.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }
}

class Dice (private val numSides: Int) {
    fun roll (): Int {
        return (1..6).random()
    }
}