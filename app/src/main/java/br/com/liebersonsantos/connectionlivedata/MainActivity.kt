package br.com.liebersonsantos.connectionlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.liebersonsantos.connectionlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private lateinit var connectionLiveData: ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        connectionLiveData = ConnectionLiveData(this)

        connectionLiveData.observe(this){ isNetworkAvailable ->
            if (isNetworkAvailable){
                _binding.txtConnected.text = "Connected"
            } else {
                _binding.txtConnected.text = "Disconnected"
            }


        }

    }
}