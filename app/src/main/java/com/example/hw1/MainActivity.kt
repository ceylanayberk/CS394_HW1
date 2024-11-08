package com.example.hw1

import FlightAdapter

import FlightInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.content.Intent
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var flightAdapter: FlightAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val flights = try {
            loadFlightData(this)
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList<FlightInfo>()         }


        flightAdapter = FlightAdapter(flights) { flight ->
            navigateToDetailScreen(flight)
        }
        recyclerView.adapter = flightAdapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navigateToDetailScreen(flight: FlightInfo) {
        val intent = Intent(this, FlightDetailActivity::class.java)
        intent.putExtra("flightInfo", flight)
        startActivity(intent)
    }

    fun loadFlightData(context: Context): List<FlightInfo> {
        return try {
            val inputStream = context.assets.open("hw1.json")
            val reader = InputStreamReader(inputStream)

            val jsonArray = Gson().fromJson(reader, JsonArray::class.java)


            jsonArray.map { it.asJsonObject }.map {
                FlightInfo(
                    it.get("id").asInt,
                    it.get("first_name").asString,
                    it.get("last_name").asString,
                    it.get("email").asString,
                    it.get("gender").asString,
                    it.get("airportCode").asString,
                    it.get("flightTime").asString,
                    it.get("flightDate").asString,
                    it.get("from").asString,
                    it.get("to").asString
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("FlightData", "Error loading flight data: ${e.message}")
            emptyList()
        }
    }
}