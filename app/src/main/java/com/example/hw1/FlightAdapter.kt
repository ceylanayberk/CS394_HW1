import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw1.R

class FlightAdapter(
    private val flights: List<FlightInfo>,
    private val onFlightClick: (FlightInfo) -> Unit
) : RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_flight, parent, false)
        return FlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val flight = flights[position]
        holder.bind(flight)
        holder.itemView.setOnClickListener { onFlightClick(flight) }
    }

    override fun getItemCount() = flights.size

    inner class FlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvFlightDate: TextView = itemView.findViewById(R.id.tv_flight_date)
        private val tvFlightTime: TextView = itemView.findViewById(R.id.tv_flight_time)
        private val tvAirportFrom: TextView = itemView.findViewById(R.id.tv_airport_from)
        private val tvAirportTo: TextView = itemView.findViewById(R.id.tv_airport_to)

        fun bind(flight: FlightInfo) {
            tvFlightDate.text = flight.flightDate
            tvFlightTime.text = flight.flightTime
            tvAirportFrom.text = flight.from
            tvAirportTo.text = flight.to
        }
    }
}