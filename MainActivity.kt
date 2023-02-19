package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        // what will happen when button is clicked
        /*rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            // concise alternative:
            //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = "Yeah I see it!"

        }*/
        rollButton.setOnClickListener {
            rollDice()
        }
        // Do a dice roll when the app starts
        rollDice()
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Update the TextView with the dice roll
        //val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView.text = dice.roll().toString()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // set to pic 2 everytime
        //diceImage.setImageResource(R.drawable.dice_2)

        // Determine which drawable resource ID to use based on the dice roll
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
