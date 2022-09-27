package com.example.myapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var number : EditText = findViewById(R.id.edtnum)
        var msg : EditText = findViewById(R.id.edtsms)
        var btn : Button = findViewById(R.id.btnsend)

        btn.setOnClickListener(){
            if(number.text.isNotEmpty() && msg.text.isNotEmpty()){
                val packageManager : PackageManager  = getPackageManager()
                val i = Intent(Intent.ACTION_VIEW)
                val url = "https://api.whatsapp.com/send?phone=" + number.text.toString() + "&text=" + URLEncoder.encode(msg.text.toString(),)
                i.setPackage("som.whatsapp")
                i.data = Uri.parse(url)
            } else {
                Toast.makeText(this," Numero ou mensagem vazia", Toast.LENGTH_LONG).show()
            }

        }

    }
}