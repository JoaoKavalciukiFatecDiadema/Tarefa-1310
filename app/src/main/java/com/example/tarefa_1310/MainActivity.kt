package com.example.tarefa_1310

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioButtonFem : RadioButton = findViewById(R.id.rbFem)
        val radioButtonMasc : RadioButton = findViewById(R.id.rbMasc)
        val etIdade : EditText = findViewById(R.id.etIdade)

        val tvResult: TextView = findViewById(R.id.tvResult)

        val btnCalc: Button = findViewById(R.id.btnCalc)
        btnCalc.setOnClickListener {

            if(etIdade.text.isBlank() || etIdade.text.isEmpty()){
                Toast.makeText(this, "O campo idade precisa ser preenchido", Toast.LENGTH_SHORT).show()
                //Verifica quao botão foi selecionado e qual a idade informada
            } else if((radioButtonMasc.isChecked && etIdade.text.toString().toInt() >= 65) ||
                (radioButtonFem.isChecked && etIdade.text.toString().toInt() >= 62)) {
                    Toast.makeText(this, "Você já pode entrar com o processo de aposentadoria", Toast.LENGTH_SHORT).show()
            }else {
                    val result: Int
                    if(radioButtonMasc.isChecked){

                        result = 65 - etIdade.text.toString().toInt()
                        tvResult.text = "Faltam $result anos para sua aposentadoria"
                    } else{
                        result = 62 - etIdade.text.toString().toInt()
                        tvResult.text = "Faltam $result anos para sua aposentadoria"
                    }
                }
            }
        }
    }
