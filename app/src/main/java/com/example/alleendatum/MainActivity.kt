package com.example.alleendatum

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var beginTijdInUren: Int = 0
    var beginTijdInMinuten: Int = 0
    var eindTijdInUren: Int = 0
    var eindTijdInMinuten: Int = 0
    var pauzeUren: Int = 0
    var pauzeMinuten = 30
    val customerList = arrayOf("Jansen", "Peeters", "Goddefroi")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pickerUren = findViewById<NumberPicker>(R.id.numerberPickerUren)
        pickerUren.minValue = 0
        pickerUren.maxValue = 12
        pickerUren.wrapSelectorWheel = true


        var pickerCustomers = findViewById<NumberPicker>(R.id.numberPickerCustomers)
        if (pickerCustomers != null) {
            pickerCustomers.minValue = 0
            pickerCustomers.wrapSelectorWheel = true
            pickerCustomers.maxValue = customerList.size - 1
            pickerCustomers.displayedValues = customerList

        }
        val pickerMinuten = findViewById<NumberPicker>(R.id.numberPickerMinuten)
        pickerMinuten.minValue = 0
        pickerMinuten.maxValue = 60
        pickerMinuten.value = 30
        pickerMinuten.wrapSelectorWheel = true


    }

    fun beginUurWeergeven(view: View) {

        val buSelected = view as Button
        when (buSelected.id) {
            bt_beginUur.id -> {

                val t3 = Calendar.getInstance()//.time
                beginTijdInUren = t3.get(Calendar.HOUR_OF_DAY)
                beginTijdInMinuten = t3.get(Calendar.MINUTE)
                val result = beginTijdInUren.toString() + ":" + beginTijdInMinuten.toString()

                bt_beginUur.text = result

            }
        }


    }

    fun eindUurWeergeven(view: View) {


        val buSelected = view as Button
        when (buSelected.id) {
            bt_eindUur.id -> {

                val t4 = Calendar.getInstance()//.time
                eindTijdInUren = t4.get(Calendar.HOUR_OF_DAY)
                eindTijdInMinuten = t4.get(Calendar.MINUTE)
                val result = eindTijdInUren.toString() + ":" + eindTijdInMinuten.toString()

                bt_eindUur.text = result

            }
        }


    }

    fun berekeningWerkTijd(view: View) {


        pauzeUren = numerberPickerUren.value

        pauzeMinuten = numberPickerMinuten.value
        val pauzeTotaal = pauzeUren * 60 + pauzeMinuten
        var werkTijd =
            ((eindTijdInUren * 60) + (eindTijdInMinuten)) - ((beginTijdInUren * 60) + (beginTijdInMinuten)) - pauzeTotaal
        var werkTijdInUren: Int = werkTijd / 60
        var werktijdInMinuten: Int = werkTijd - werkTijdInUren * 60
        var resultaat: String =
            werkTijdInUren.toString() + " u  " + werktijdInMinuten.toString() + " min."
        bt_resultaat.text = resultaat


    }

}
