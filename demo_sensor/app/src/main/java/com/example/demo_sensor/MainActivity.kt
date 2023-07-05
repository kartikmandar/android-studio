package com.example.demo_sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var mSensorManager : SensorManager
    private var mGyroscope: Sensor ?= null
    private var mMagneticField: Sensor ?= null
    private var mAccelerometer : Sensor ?= null
    private var mGravity: Sensor ?= null
    private var mLinearAcceleration: Sensor ?= null
    private var mRotationVector: Sensor ?= null
    private var mLight: Sensor ?= null
    private var mProximity: Sensor ?= null
    private var mTemperature: Sensor ?= null
    private var mRelativeHumidity: Sensor ?= null
    private var mPressure: Sensor ?= null
    private var resume = false

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }

    override fun onSensorChanged(event: SensorEvent?) {

        if (event != null && resume) {
            if (event.sensor.type == Sensor.TYPE_GYROSCOPE) {
                findViewById<TextView>(R.id.gyroscopex).text = event.values[0].toString()
                findViewById<TextView>(R.id.gyroscopey).text = event.values[1].toString()
                findViewById<TextView>(R.id.gyroscopez).text = event.values[2].toString()
            }
        }

        if (event != null && resume) {
            if (event.sensor.type == Sensor.TYPE_MAGNETIC_FIELD) {
                findViewById<TextView>(R.id.magneticx).text = event.values[0].toString()
                findViewById<TextView>(R.id.magneticy).text = event.values[1].toString()
                findViewById<TextView>(R.id.magneticz).text = event.values[2].toString()
            }
        }

        if (event != null && resume) {
            if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                findViewById<TextView>(R.id.accelerometerx).text = event.values[0].toString()
                findViewById<TextView>(R.id.accelerometery).text = event.values[1].toString()
                findViewById<TextView>(R.id.accelerometerz).text = event.values[2].toString()
            }
        }

        if (event != null && resume) {
            if (event.sensor.type == Sensor.TYPE_GRAVITY) {
                findViewById<TextView>(R.id.gravityx).text = event.values[0].toString()
                findViewById<TextView>(R.id.gravityy).text = event.values[1].toString()
                findViewById<TextView>(R.id.gravityz).text = event.values[2].toString()
            }
        }

        if (event != null && resume) {
            if (event.sensor.type == Sensor.TYPE_LINEAR_ACCELERATION) {
                findViewById<TextView>(R.id.linearaccelerationx).text = event.values[0].toString()
                findViewById<TextView>(R.id.linearaccelerationy).text = event.values[1].toString()
                findViewById<TextView>(R.id.linearaccelerationz).text = event.values[2].toString()
            }
        }

        if (event != null && resume) {
            if (event.sensor.type == Sensor.TYPE_ROTATION_VECTOR) {
                findViewById<TextView>(R.id.rotationx).text = event.values[0].toString()
                findViewById<TextView>(R.id.rotationy).text = event.values[1].toString()
                findViewById<TextView>(R.id.rotationz).text = event.values[2].toString()
                findViewById<TextView>(R.id.rotationcos).text = event.values[3].toString()
                findViewById<TextView>(R.id.rotationaccuracy).text = event.values[4].toString()
            }
        }

        if (event != null && resume) {
            if (event.sensor.type == Sensor.TYPE_LIGHT) {
                findViewById<TextView>(R.id.lightvalue).text = event.values[0].toString()
            }
        }

        if (event != null && resume) {
            if (event.sensor.type == Sensor.TYPE_PROXIMITY) {
                findViewById<TextView>(R.id.proximityvalue).text = event.values[0].toString()
            }
        }

        if (event != null && resume) {
            if (event.sensor.type == Sensor.TYPE_AMBIENT_TEMPERATURE) {
                findViewById<TextView>(R.id.temperaturevalue).text = event.values[0].toString()
            }
        }

        if (event != null && resume) {
            if (event.sensor.type == Sensor.TYPE_RELATIVE_HUMIDITY) {
                findViewById<TextView>(R.id.humidityvalue).text = event.values[0].toString()
            }
        }

        if (event != null && resume) {
            if (event.sensor.type == Sensor.TYPE_PRESSURE) {
                findViewById<TextView>(R.id.pressurevalue).text = event.values[0].toString()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

        mMagneticField = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        mGravity = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)

        mLinearAcceleration = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)

        mRotationVector = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)

        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        mTemperature = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)

        mRelativeHumidity = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY)

        mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)
    }

    override fun onResume() {
        super.onResume()
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mMagneticField, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mGravity, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mLinearAcceleration, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mRotationVector, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mTemperature, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mRelativeHumidity, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mPressure, SensorManager.SENSOR_DELAY_NORMAL)


    }

    override fun onPause() {
        super.onPause()
        mSensorManager.unregisterListener(this)
    }

    fun resumeReading(view: View) {
        this.resume = true
    }

    fun pauseReading(view: View) {
        this.resume = false
    }
}