package com.example.alleendatum

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
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
    val customerList = arrayOf("customer1", "customer2", "customer3")
    var aantalMinuten: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pickerUren = findViewById<NumberPicker>(R.id.numerberPickerUren)
        pickerUren.minValue = 0
        pickerUren.maxValue = 12
        pickerUren.wrapSelectorWheel = true
        pickerUren.setOnValueChangedListener { pickerUren, oldVal, newVal -> tv_pauze_uur.setText("$newVal") }


        var pickerCustomers = findViewById<NumberPicker>(R.id.numberPickerCustomers)
        if (pickerCustomers != null) {
            pickerCustomers.minValue = 0
            pickerCustomers.wrapSelectorWheel = true
            pickerCustomers.maxValue = customerList.size - 1
            pickerCustomers.displayedValues = customerList
//            pickerCustomers.setOnValueChangedListener { pickerCustomers, oldVal, newVal ->
//                tv_customer.setText(
//                    "customer : ($newVal+1)"
//                )
//            }

        }
        val pickerMinuten = findViewById<NumberPicker>(R.id.numberPickerMinuten)
        pickerMinuten.minValue = 0
        pickerMinuten.maxValue = 60
        pickerMinuten.value = 30
        pickerMinuten.wrapSelectorWheel = true
        pickerMinuten.setOnValueChangedListener { pickerMinuten, oldVal, newVal ->
            tv_pauze_minuten.setText(
                "$newVal"
            )
        }


        //  pauzeMinuten = pickerMinuten.value

        tv_pauze_minuten.text = pauzeMinuten.toString()


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


        val edittxt = findViewById<TextView>(R.id.tv_pauze_uur)
        pauzeUren = edittxt.text.toString().toInt()
        val edittxt2 = findViewById<TextView>(R.id.tv_pauze_minuten)
        pauzeMinuten = edittxt2.text.toString().toInt()
        val pauzeTotaal = pauzeUren * 60 + pauzeMinuten
        var werkTijd =
            ((eindTijdInUren * 60) + (eindTijdInMinuten)) - ((beginTijdInUren * 60) + (beginTijdInMinuten)) - pauzeTotaal
        var werkTijdInUren: Int = werkTijd / 60
        var werktijdInMinuten: Int = werkTijd - werkTijdInUren * 60
        var resultaat: String =
            werkTijdInUren.toString() + " u  " + werktijdInMinuten.toString() + " min."
      //  bt_resultaat.text = resultaat

        //    bt_resultaat.text = aantalMinuten.toString()

        //    var som = aantalMinuten + 1
        //   tv_pauze_uur.text = som.toString()
        var edict = findViewById<TextView>(R.id.tv_pauze_minuten)
        aantalMinuten = edict.text.toString().toInt()
        aantalMinuten= numberPickerMinuten.value

        tv_pauze_uur.text = pauzeMinuten.toString()
        bt_resultaat.text = aantalMinuten.toString()


    }

}
