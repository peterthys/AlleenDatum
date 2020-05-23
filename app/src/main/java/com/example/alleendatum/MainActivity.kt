package com.example.alleendatum

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    var beginTijdInUren: Int = 0
    var beginTijdInMinuten: Int = 0
    var eindTijdInUren: Int = 0
    var eindTijdInMinuten: Int = 0
    var pauzeUren: Int = 0
    var pauzeMinuten = 30
    val customerList = arrayOf("customer1", "customer2", "customer3")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pickerUren = findViewById<NumberPicker>(R.id.numerberPickerUren)
        pickerUren.minValue = 0
        pickerUren.maxValue = 12
        pickerUren.wrapSelectorWheel = true
        pickerUren.setOnValueChangedListener { pickerUren, oldVal, newVal -> tv_pauze_uur.setText("$newVal") }
        val uuuur : Int = R.id.tv_pauze_uur





//        pickerMinuten.minValue = 0
//        pickerMinuten.maxValue = 60
//        pickerMinuten.wrapSelectorWheel = true
//        pickerMinuten.setOnValueChangedListener { pickerMinuten, oldVal, newVal -> tv_pauze_minuten.setText ("$newVal") }
//
        var pickerCustomers = findViewById<NumberPicker>(R.id.numberPickerCustomers)
        if (pickerCustomers!=null){
            pickerCustomers.minValue = 0
            pickerCustomers.wrapSelectorWheel = true
            pickerCustomers.maxValue = customerList.size-1
            pickerCustomers.displayedValues = customerList
            pickerCustomers.setOnValueChangedListener { pickerCustomers, oldVal, newVal -> tv_customer.setText("$newVal") }

        }

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
       pauzeUren = Integer.parseInt(tv_pauze_uur.toString())
//        pauzeMinuten = Integer.parseInt(pickerMinuten.text.toString())
        //       val pauzeTotaal = pauzeUren * 60 + pauzeMinuten
        var werkTijd =
            ((eindTijdInUren * 60) + (eindTijdInMinuten)) - ((beginTijdInUren * 60) + (beginTijdInMinuten)) //- pauzeTotaal
        var werkTijdInUren: Int = werkTijd / 60
        var werktijdInMinuten: Int = werkTijd - werkTijdInUren * 60
        var resultaat: String =
            werkTijdInUren.toString() + " u  " + werktijdInMinuten.toString() + " min."


    }


//    fun beginUurWeergeven(view: View) {
//
//        val buSelected = view as Button
//        when (buSelected.id) {
//            bt_beginUur.id -> {
//                val currentBegin = LocalDateTime.now()
//                t1 = currentBegin
//                val formatterBegin = DateTimeFormatter.ofPattern(("HH:mm"))
//                val formattedBegin = currentBegin.format(formatterBegin)
//
//                //  var beginUur = DateFormat.getTimeInstance().format(calendar.getTime())
//                bt_beginUur.text = formattedBegin
//
//            }
//        }
//    }
//
//    fun eindUurWeergeven(view: View) {
//        val buSelected2 = view as Button
//        when (buSelected2.id) {
//
//            bt_eindUur.id -> {
//                val currentEind = LocalDateTime.now()
//                t2 = currentEind
//                val formatterEind = DateTimeFormatter.ofPattern(("HH:mm"))
//                val formattedEind = currentEind.format(formatterEind)
//                //var eindUur = DateFormat.getTimeInstance().format(calendar.getTime())
//                bt_eindUur.text = formattedEind
//                val fromDateTime =t1
//                   // LocalDateTime.of(1984, 12, 16, 7, 45, 55)
//                val toDateTime = t2
//                 //   LocalDateTime.of(2014, 9, 10, 6, 40, 45)
//
//                var tempDateTime =
//                    LocalDateTime.from(fromDateTime)
//
//                val years = tempDateTime.until(toDateTime, ChronoUnit.YEARS)
//                tempDateTime = tempDateTime.plusYears(years)
//
//                val months = tempDateTime.until(toDateTime, ChronoUnit.MONTHS)
//                tempDateTime = tempDateTime.plusMonths(months)
//
//                val days = tempDateTime.until(toDateTime, ChronoUnit.DAYS)
//                tempDateTime = tempDateTime.plusDays(days)
//
//
//                val hours = tempDateTime.until(toDateTime, ChronoUnit.HOURS)
//                tempDateTime = tempDateTime.plusHours(hours)
//
//                val minutes = tempDateTime.until(toDateTime, ChronoUnit.MINUTES)
//                tempDateTime = tempDateTime.plusMinutes(minutes)
//
//                val seconds = tempDateTime.until(toDateTime, ChronoUnit.SECONDS)
//
//                println(
//                    years.toString() + " years " +
//                            months + " months " +
//                            days + " days " +
//                            hours + " hours " +
//                            minutes + " minutes " +
//                            seconds + " seconds."
//                )
//                var som = minutes + seconds
//
//                tv_datum.text = "Resultaat  " +hours.toString() + " hours " +
//                        minutes + " minutes" +
//                        seconds + "seconds."//  Som = "+tempDateTime
//            }
//        }
//    }


}
