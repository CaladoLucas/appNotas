package com.example.lucas.appnotas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var resultado:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val edtNota1 = findViewById<EditText>(R.id.edtNota1)
        val edtNota2 = findViewById<EditText>(R.id.edtNota2)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener{
        var intent = Intent("android.intent.action.filter")
            intent.addCategory("android.intent.category.DEFAULT")
            intent.addCategory("android.intent.category.filter")
            intent.putExtra("NOTA1",edtNota1.text)
            intent.putExtra("NOTA2",edtNota2.text)
            startActivityForResult(intent,Intent.FILL_IN_ACTION)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(resultCode){
            Intent.FILL_IN_ACTION->{
                txtResultado.text = data!!.extras["RESULTADO"].toString()

            }
        }
    }


}
