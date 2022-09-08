package net.ivanvega.mirollera

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var boton: Button
    lateinit var lbl: TextView
    lateinit var img1: ImageView
    lateinit var img2: ImageView

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_roller)


        lbl = findViewById(R.id.lblSaludo)
        boton = findViewById(R.id.btnRoller)
        img1 = findViewById(R.id.imgRoller)
        img2 = findViewById(R.id.imgRoller2)

        /*boton.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(applicationContext,
                    "Boton presionafdo",
                    Toast.LENGTH_LONG
                    ).show()
            }
        )*/

        img1.setImageDrawable(resources.getDrawable(R.drawable.dice_3))
        img2.setImageDrawable(resources.getDrawable(R.drawable.dice_5))

        boton.setOnClickListener {
            val al = diceRoller()
            val bl= diceRoller()

            Toast.makeText(
                applicationContext,
                "Boton presionado aleatorio " + (al+bl),
                Toast.LENGTH_LONG
            ).show()




            img1.setImageResource(imageRoller(al))
            img2.setImageResource(imageRoller(bl))

            lbl.text = (al+bl).toString()

        }
    }

    private fun diceRoller(): Int {
        return (1..6).random()
    }
    private fun imageRoller(n:Int):Int{
        return when (n) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }

}