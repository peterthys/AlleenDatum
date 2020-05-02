package com.example.alleendatum

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class MainActivity : AppCompatActivity() {
    // val dateFormat = SimpleDateFormat("yyyy-mm-dd")
    // val timeFormat = SimpleDateFormat("HH:mm")
    var t1: LocalDateTime? = null
    var t2: LocalDateTime? = null

    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern(("dd-MMMM-yyyy "))
    val formatted = current.format(formatter)

//    var calendar = Calendar.getInstance()
//    var datum = DateFormat.getDateInstance().format(calendar.getTime())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    //    tv_datum.text = formatted
    }


    fun beginUurWeergeven(view: View) {

        val buSelected = view as Button
        when (buSelected.id) {
            bt_beginUur.id -> {
                val currentBegin = LocalDateTime.now()
                t1 = currentBegin
                val formatterBegin = DateTimeFormatter.ofPattern(("HH:mm"))
                val formattedBegin = currentBegin.format(formatterBegin)

                //  var beginUur = DateFormat.getTimeInstance().format(calendar.getTime())
                bt_beginUur.text = formattedBegin

            }
        }
    }

    fun eindUurWeergeven(view: View) {
        val buSelected2 = view as Button
        when (buSelected2.id) {

            bt_eindUur.id -> {
                val currentEind = LocalDateTime.now()
                t2 = currentEind
                val formatterEind = DateTimeFormatter.ofPattern(("HH:mm"))
                val formattedEind = currentEind.format(formatterEind)
                //var eindUur = DateFormat.getTimeInstance().format(calendar.getTime())
                bt_eindUur.text = formattedEind
                val fromDateTime =t1
                   // LocalDateTime.of(1984, 12, 16, 7, 45, 55)
                val toDateTime = t2
                 //   LocalDateTime.of(2014, 9, 10, 6, 40, 45)

                var tempDateTime =
                    LocalDateTime.from(fromDateTime)

                val years = tempDateTime.until(toDateTime, ChronoUnit.YEARS)
                tempDateTime = tempDateTime.plusYears(years)

                val months = tempDateTime.until(toDateTime, ChronoUnit.MONTHS)
                tempDateTime = tempDateTime.plusMonths(months)

                val days = tempDateTime.until(toDateTime, ChronoUnit.DAYS)
                tempDateTime = tempDateTime.plusDays(days)


                val hours = tempDateTime.until(toDateTime, ChronoUnit.HOURS)
                tempDateTime = tempDateTime.plusHours(hours)

                val minutes = tempDateTime.until(toDateTime, ChronoUnit.MINUTES)
                tempDateTime = tempDateTime.plusMinutes(minutes)

                val seconds = tempDateTime.until(toDateTime, ChronoUnit.SECONDS)

                println(
                    years.toString() + " years " +
                            months + " months " +
                            days + " days " +
                            hours + " hours " +
                            minutes + " minutes " +
                            seconds + " seconds."
                )
                var som = minutes + seconds

                tv_datum.text = "Resultaat  " +hours.toString() + " hours " +
                        minutes + " minutes" +
                        seconds + "seconds."//  Som = "+tempDateTime
            }
        }
    }




}
