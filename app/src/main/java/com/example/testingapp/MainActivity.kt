package com.example.testingapp

import android.content.Context
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.chaquo.python.PyException
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (! Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }


        findViewById<Button>(R.id.buttonWorks2).setOnClickListener {
            var strOut:String=""
            val python = Python.getInstance()
            val pythonFile= python.getModule("ForAndroid",)
            strOut= findViewById<EditText>(R.id.textInput).text.toString()
            textView.text=pythonFile.callAttr("inputFirst",strOut).toString()
            textInput.getText().clear()

        }


    }


}