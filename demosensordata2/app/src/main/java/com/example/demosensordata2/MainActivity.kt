package com.example.demosensordata2

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class HomeFragment : Fragment(), SensorEventListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var sensorManager: SensorManager
    lateinit var main: MainActivity
    var mGravity: Sensor? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        main = requireActivity() as MainActivity
        sensorManager = main.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mGravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)

        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        deviceSensors.forEach {
            Log.d("Sensors",it.toString())
        }

    }

    override fun onResume() {
        super.onResume()
        mGravity.also { grav ->
            sensorManager.registerListener(this,grav,SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        Log.d("Accuracy","None")
    }

    override fun onSensorChanged(event: SensorEvent) {
        val gravity = event.values[0]
        angle_value.setText(gravity.toString())
    }
}