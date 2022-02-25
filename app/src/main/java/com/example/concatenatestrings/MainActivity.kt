package com.example.concatenatestrings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var input1: EditText? = null
    private var input2: EditText? = null
    private var input3: EditText? = null
    private var tvResult: TextView? = null
    private var INPUTTEXT1 = "TEXT_CONTENT1"
    private var INPUTTEXT2 = "TEXT_CONTENT2"
    private var INPUTTEXT3 = "TEXT_CONTENT3"
    private var TEXT = "TEXT_CONTENT_TV"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClean: Button = findViewById<Button>(R.id.buttonClean)
        val buttonAdd: Button = findViewById<Button>(R.id.buttonAdd)
        input1 = findViewById<EditText>(R.id.editTextInput1)
        input2 = findViewById<EditText>(R.id.editTextInput2)
        input3 = findViewById<EditText>(R.id.editTextInput3)
        tvResult = findViewById<TextView>(R.id.textViewResult)


        buttonAdd?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                if(input1?.text.toString() == "" || input2?.text.toString() == "" || input3?.text.toString() == ""){
                    tvResult?.append("")
                }
                else{
                    tvResult?.append("${input1?.text} + ${input2?.text} = ${input3?.text} \n")
                    input1?.text?.clear()
                    input2?.text?.clear()
                    input3?.text?.clear()
                }
            }
        })

        buttonClean?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                input1?.text?.clear()
                input2?.text?.clear()
                input3?.text?.clear()
                tvResult?.text = ""
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(INPUTTEXT1, input1?.text.toString())
        outState.putString(INPUTTEXT2, input2?.text.toString())
        outState.putString(INPUTTEXT3, input3?.text.toString())
        outState.putString(TEXT, tvResult?.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        input1?.setText(savedInstanceState.getString(INPUTTEXT1,""))
        input2?.setText(savedInstanceState.getString(INPUTTEXT2,""))
        input3?.setText(savedInstanceState.getString(INPUTTEXT3,""))
        tvResult?.text = savedInstanceState.getString(TEXT,"")
    }
}