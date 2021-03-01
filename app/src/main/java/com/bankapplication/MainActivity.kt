package com.bankapplication

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

   lateinit var  textSelectSate :TextView
   lateinit var  textViewPanCard :TextView
   lateinit var  btnNext :TextView

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         textSelectSate = findViewById<TextView>(R.id.textViewSelectDate)
         textViewPanCard = findViewById<TextView>(R.id.textViewPanCard)
         btnNext = findViewById<Button>(R.id.buttonNext)

        btnNext.setOnClickListener(this)
        textViewPanCard.setOnClickListener(this)
        textSelectSate.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.textViewPanCard -> {
                finish()
            }
            R.id.buttonNext -> {
                Toast.makeText(this, "Details submitted successfully", Toast.LENGTH_LONG).show()
                finish()
            }
            R.id.textViewSelectDate ->{
                val calender = Calendar.getInstance()
                val year = calender.get(Calendar.YEAR)
                val month = calender.get(Calendar.MONTH)
                val day = calender.get(Calendar.DAY_OF_MONTH)
                val datePickerDialog = DatePickerDialog(this@MainActivity, DatePickerDialog.OnDateSetListener
                { view, year, monthOfYear, dayOfMonth ->
                    textSelectSate.setText("" + dayOfMonth + " - " + (monthOfYear + 1) + " - " + year)
                }, year, month, day)
                datePickerDialog.show()
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            }

        }
    }
}