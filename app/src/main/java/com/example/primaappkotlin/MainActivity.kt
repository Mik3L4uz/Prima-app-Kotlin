package com.example.primaappkotlin

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var campoInput: EditText
    lateinit var bottone: Button
    lateinit var showNumero: TextView
    lateinit var checkBlocca: CheckBox
    lateinit var checkInverti: CheckBox

    // ----------------- //

    var incremento: Int = 0
    var totale: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        campoInput = findViewById(R.id.campoInput)
        bottone = findViewById(R.id.bottone)
        showNumero = findViewById(R.id.showNumero)
        checkBlocca = findViewById(R.id.checkBlocca)
        checkInverti = findViewById(R.id.checkInverti)




        bottone.setOnClickListener {
            if (checkBlocca.isChecked == false){
                incremento = campoInput.text.toString().toInt()
                if (checkInverti.isChecked == true){
                    totale = totale-incremento
                    showNumero.text = totale.toString()
                }
                else{
                    totale = totale+incremento
                    showNumero.text = totale.toString()
                }
            }

        }


    }
}