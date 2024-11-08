package com.example.hw1
import FlightInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.hw1.R

class FlightDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_detail)


        val flightInfo: FlightInfo? = intent.getParcelableExtra("flightInfo")

        flightInfo?.let {
            findViewById<TextView>(R.id.textViewFlightId).text = "Flight ID: ${it.id}"
            findViewById<TextView>(R.id.textViewFirstName).text = "First Name: ${it.firstName}"
            findViewById<TextView>(R.id.textViewLastName).text = "Last Name: ${it.lastName}"
            findViewById<TextView>(R.id.textViewEmail).text = "Email: ${it.email}"
            findViewById<TextView>(R.id.textViewGender).text = "Gender: ${it.gender}"
            findViewById<TextView>(R.id.textViewAirportCode).text = "Airport Code: ${it.airportCode}"
            findViewById<TextView>(R.id.textViewFlightTime).text = "Flight Time: ${it.flightTime}"
            findViewById<TextView>(R.id.textViewFlightDate).text = "Flight Date: ${it.flightDate}"
            findViewById<TextView>(R.id.textViewFrom).text = "From: ${it.from}"
            findViewById<TextView>(R.id.textViewTo).text = "To: ${it.to}"
        }
    }
}
