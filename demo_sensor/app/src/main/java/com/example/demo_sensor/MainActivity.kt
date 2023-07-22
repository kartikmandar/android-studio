package com.example.demo_sensor

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.provider.Settings
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.demo_sensor.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.Locale

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var mSensorManager : SensorManager
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    private val permissionId = 2
    private val PERMISSION_REQUEST_INTERVAL = 5000L
    private val permissionHandler = Handler()
    private val permissionRunnable = object : Runnable {
        override fun run() {
            requestPermissions()
            permissionHandler.postDelayed(this, PERMISSION_REQUEST_INTERVAL)
        }
    }
    private val fileName = "location_data.csv"
    private var fileWriter: FileWriter? = null
    private lateinit var mainBinding: ActivityMainBinding
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
    private var fileWriter1: FileWriter? = null
    private var fileWriter2: FileWriter? = null
    private var fileWriter3: FileWriter? = null
    private var fileWriter4: FileWriter? = null
    private var fileWriter5: FileWriter? = null
    private var fileWriter6: FileWriter? = null
    private var fileWriter7: FileWriter? = null
    private var fileWriter8: FileWriter? = null
    private var fileWriter9: FileWriter? = null
    private var fileWriter10: FileWriter? = null
    private var fileWriter11: FileWriter? = null


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }
    override fun onSensorChanged(event: SensorEvent?) {

        if (event != null && resume) {
            if (event.sensor.type == Sensor.TYPE_GYROSCOPE) {
                findViewById<TextView>(R.id.gyroscopex).text = event.values[0].toString()
                findViewById<TextView>(R.id.gyroscopey).text = event.values[1].toString()
                findViewById<TextView>(R.id.gyroscopez).text = event.values[2].toString()

                /* System.currentTimeMillis() is a method in Java (and Kotlin) that returns the current time in milliseconds since January 1, 1970, UTC (Coordinated Universal Time). It is often used to generate timestamps or measure the duration of operations. */
                val timestampGYROSCOPE = System.currentTimeMillis()
                val GYROSCOPEx = event.values[0]
                val GYROSCOPEy = event.values[1]
                val GYROSCOPEz = event.values[2]

                writeDataToFile1("$timestampGYROSCOPE,$GYROSCOPEx,$GYROSCOPEy,$GYROSCOPEz")
            }

            if (event.sensor.type == Sensor.TYPE_MAGNETIC_FIELD) {
                findViewById<TextView>(R.id.magneticx).text = event.values[0].toString()
                findViewById<TextView>(R.id.magneticy).text = event.values[1].toString()
                findViewById<TextView>(R.id.magneticz).text = event.values[2].toString()

                val timestampMAGNETIC_FIELD = System.currentTimeMillis()
                val MAGNETIC_FIELDx = event.values[0]
                val MAGNETIC_FIELDy = event.values[1]
                val MAGNETIC_FIELDz = event.values[2]

                writeDataToFile2("$timestampMAGNETIC_FIELD,$MAGNETIC_FIELDx,$MAGNETIC_FIELDy,$MAGNETIC_FIELDz")
            }

            if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                findViewById<TextView>(R.id.accelerometerx).text = event.values[0].toString()
                findViewById<TextView>(R.id.accelerometery).text = event.values[1].toString()
                findViewById<TextView>(R.id.accelerometerz).text = event.values[2].toString()

                val timestampACCELEROMETER = System.currentTimeMillis()
                val ACCELEROMETERx = event.values[0]
                val ACCELEROMETERy = event.values[1]
                val ACCELEROMETERz = event.values[2]

                writeDataToFile3("$timestampACCELEROMETER,$ACCELEROMETERx,$ACCELEROMETERy,$ACCELEROMETERz")
            }

            if (event.sensor.type == Sensor.TYPE_GRAVITY) {
                findViewById<TextView>(R.id.gravityx).text = event.values[0].toString()
                findViewById<TextView>(R.id.gravityy).text = event.values[1].toString()
                findViewById<TextView>(R.id.gravityz).text = event.values[2].toString()

                val timestampGRAVITY = System.currentTimeMillis()
                val GRAVITYx = event.values[0]
                val GRAVITYy = event.values[1]
                val GRAVITYz = event.values[2]

                writeDataToFile4("$timestampGRAVITY,$GRAVITYx,$GRAVITYy,$GRAVITYz")
            }

            if (event.sensor.type == Sensor.TYPE_LINEAR_ACCELERATION) {
                findViewById<TextView>(R.id.linearaccelerationx).text = event.values[0].toString()
                findViewById<TextView>(R.id.linearaccelerationy).text = event.values[1].toString()
                findViewById<TextView>(R.id.linearaccelerationz).text = event.values[2].toString()

                val timestampLINEAR_ACCELERATION = System.currentTimeMillis()
                val LINEAR_ACCELERATIONx = event.values[0]
                val LINEAR_ACCELERATIONy = event.values[1]
                val LINEAR_ACCELERATIONz = event.values[2]

                writeDataToFile5("$timestampLINEAR_ACCELERATION,$LINEAR_ACCELERATIONx,$LINEAR_ACCELERATIONy,$LINEAR_ACCELERATIONz")
            }

            if (event.sensor.type == Sensor.TYPE_ROTATION_VECTOR) {
                findViewById<TextView>(R.id.rotationx).text = event.values[0].toString()
                findViewById<TextView>(R.id.rotationy).text = event.values[1].toString()
                findViewById<TextView>(R.id.rotationz).text = event.values[2].toString()
                findViewById<TextView>(R.id.rotationcos).text = event.values[3].toString()
                findViewById<TextView>(R.id.rotationaccuracy).text = event.values[4].toString()

                val timestampROTATION_VECTOR = System.currentTimeMillis()
                val ROTATION_VECTORx = event.values[0]
                val ROTATION_VECTORy = event.values[1]
                val ROTATION_VECTORz = event.values[2]
                val ROTATION_VECTORw = event.values[3]
                val ROTATION_VECTORv = event.values[4]

                writeDataToFile6("$timestampROTATION_VECTOR,$ROTATION_VECTORx,$ROTATION_VECTORy,$ROTATION_VECTORz,$ROTATION_VECTORw,$ROTATION_VECTORv")
            }

            if (event.sensor.type == Sensor.TYPE_LIGHT) {
                findViewById<TextView>(R.id.lightvalue).text = event.values[0].toString()

                val timestampLIGHT = System.currentTimeMillis()
                val LIGHTx = event.values[0]

                writeDataToFile7("$timestampLIGHT,$LIGHTx")
            }

            if (event.sensor.type == Sensor.TYPE_PROXIMITY) {
                findViewById<TextView>(R.id.proximityvalue).text = event.values[0].toString()

                val timestampPROXIMITY = System.currentTimeMillis()
                val PROXIMITYx = event.values[0]

                writeDataToFile8("$timestampPROXIMITY,$PROXIMITYx")
            }

            if (event.sensor.type == Sensor.TYPE_AMBIENT_TEMPERATURE) {
                findViewById<TextView>(R.id.temperaturevalue).text = event.values[0].toString()

                val timestampAMBIENT_TEMPERATURE = System.currentTimeMillis()
                val AMBIENT_TEMPERATUREx = event.values[0]

                writeDataToFile9("$timestampAMBIENT_TEMPERATURE,$AMBIENT_TEMPERATUREx")
            }

            if (event.sensor.type == Sensor.TYPE_RELATIVE_HUMIDITY) {
                findViewById<TextView>(R.id.humidityvalue).text = event.values[0].toString()

                val timestampRELATIVE_HUMIDITY = System.currentTimeMillis()
                val RELATIVE_HUMIDITYx = event.values[0]

                writeDataToFile10("$timestampRELATIVE_HUMIDITY,$RELATIVE_HUMIDITYx")
            }

            if (event.sensor.type == Sensor.TYPE_PRESSURE) {
                findViewById<TextView>(R.id.pressurevalue).text = event.values[0].toString()

                val timestampPRESSURE = System.currentTimeMillis()
                val PRESSUREx = event.values[0]

                writeDataToFile11("$timestampPRESSURE,$PRESSUREx")
            }

            
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)



        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        permissionHandler.postDelayed(permissionRunnable, PERMISSION_REQUEST_INTERVAL)

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

    private fun isLocationEnabled(): Boolean {
        val locationManager: LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun checkPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }
    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            permissionId
        )
    }
    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == permissionId) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                getLocation()
            }
        }
    }

    @SuppressLint("MissingPermission", "SetTextI18n")
    private fun getLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
                    val location: Location? = task.result
                    if (location != null) {
                        val geocoder = Geocoder(this, Locale.getDefault())
                        val latitude = location.latitude
                        val longitude = location.longitude
                        saveLocationToFile(latitude, longitude)
                        val list: List<Address> =
                            geocoder.getFromLocation(location.latitude, location.longitude, 1)!!
                        mainBinding.apply {
                            tvLatitude.text = "Latitude\n${list[0].latitude}"
                            tvLongitude.text = "Longitude\n${list[0].longitude}"
                            tvCountryName.text = "Country Name\n${list[0].countryName}"
                            tvLocality.text = "Locality\n${list[0].locality}"
                            tvAddress.text = "Address\n${list[0].getAddressLine(0)}"
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Please turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermissions()
        }
    }

    private fun saveLocationToFile(latitude: Double, longitude: Double) {
        val file = File(getExternalFilesDir(null), fileName)
        try {
            if (!file.exists()) {
                file.createNewFile()
            }
            if (fileWriter == null) {
                fileWriter = FileWriter(file, true)
            }
            fileWriter?.append("Latitude: $latitude\nLongitude: $longitude\n")
            fileWriter?.append("\n")
            fileWriter?.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun writeDataToFile1(data: String) {
        val file = File(getExternalFilesDir(null), "gyroscope_data.csv")

        try {
            if (!file.exists()) {
                file.createNewFile()
            }

            if (fileWriter1 == null) {
                fileWriter1 = FileWriter(file, true)
            }

            fileWriter1?.append(data)
            fileWriter1?.append("\n")
            fileWriter1?.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun writeDataToFile2(data: String) {
        val file = File(getExternalFilesDir(null), "magneticField_data.csv")

        try {
            if (!file.exists()) {
                file.createNewFile()
            }

            if (fileWriter2 == null) {
                fileWriter2 = FileWriter(file, true)
            }

            fileWriter2?.append(data)
            fileWriter2?.append("\n")
            fileWriter2?.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun writeDataToFile3(data: String) {
        val file = File(getExternalFilesDir(null), "accelerometer_data.csv")

        try {
            if (!file.exists()) {
                file.createNewFile()
            }

            if (fileWriter3 == null) {
                fileWriter3 = FileWriter(file, true)
            }

            fileWriter3?.append(data)
            fileWriter3?.append("\n")
            fileWriter3?.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun writeDataToFile4(data: String) {
        val file = File(getExternalFilesDir(null), "gravity_data.csv")

        try {
            if (!file.exists()) {
                file.createNewFile()
            }

            if (fileWriter4 == null) {
                fileWriter4 = FileWriter(file, true)
            }

            fileWriter4?.append(data)
            fileWriter4?.append("\n")
            fileWriter4?.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun writeDataToFile5(data: String) {
        val file = File(getExternalFilesDir(null), "linearAcceleration_data.csv")

        try {
            if (!file.exists()) {
                file.createNewFile()
            }

            if (fileWriter5 == null) {
                fileWriter5 = FileWriter(file, true)
            }

            fileWriter5?.append(data)
            fileWriter5?.append("\n")
            fileWriter5?.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun writeDataToFile6(data: String) {
        val file = File(getExternalFilesDir(null), "rotationVector_data.csv")

        try {
            if (!file.exists()) {
                file.createNewFile()
            }

            if (fileWriter6 == null) {
                fileWriter6 = FileWriter(file, true)
            }

            fileWriter6?.append(data)
            fileWriter6?.append("\n")
            fileWriter6?.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun writeDataToFile7(data: String) {
        val file = File(getExternalFilesDir(null), "light_data.csv")

        try {
            if (!file.exists()) {
                file.createNewFile()
            }

            if (fileWriter7 == null) {
                fileWriter7 = FileWriter(file, true)
            }

            fileWriter7?.append(data)
            fileWriter7?.append("\n")
            fileWriter7?.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun writeDataToFile8(data: String) {
        val file = File(getExternalFilesDir(null), "proximity_data.csv")

        try {
            if (!file.exists()) {
                file.createNewFile()
            }

            if (fileWriter8 == null) {
                fileWriter8 = FileWriter(file, true)
            }

            fileWriter8?.append(data)
            fileWriter8?.append("\n")
            fileWriter8?.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun writeDataToFile9(data: String) {
        val file = File(getExternalFilesDir(null), "ambientTemperature_data.csv")

        try {
            if (!file.exists()) {
                file.createNewFile()
            }

            if (fileWriter9 == null) {
                fileWriter9 = FileWriter(file, true)
            }

            fileWriter9?.append(data)
            fileWriter9?.append("\n")
            fileWriter9?.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun writeDataToFile10(data: String) {
        val file = File(getExternalFilesDir(null), "relativeHumidity_data.csv")

        try {
            if (!file.exists()) {
                file.createNewFile()
            }

            if (fileWriter10 == null) {
                fileWriter10 = FileWriter(file, true)
            }

            fileWriter10?.append(data)
            fileWriter10?.append("\n")
            fileWriter10?.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun writeDataToFile11(data: String) {
        val file = File(getExternalFilesDir(null), "pressure_data.csv")

        try {
            if (!file.exists()) {
                file.createNewFile()
            }

            if (fileWriter11 == null) {
                fileWriter11 = FileWriter(file, true)
            }

            fileWriter11?.append(data)
            fileWriter11?.append("\n")
            fileWriter11?.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
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
        getLocation()
    }

    override fun onPause() {
        super.onPause()
        mSensorManager.unregisterListener(this)
        fileWriter1?.close()
        fileWriter2?.close()
        fileWriter3?.close()
        fileWriter4?.close()
        fileWriter5?.close()
        fileWriter6?.close()
        fileWriter7?.close()
        fileWriter8?.close()
        fileWriter9?.close()
        fileWriter10?.close()
        fileWriter11?.close()
        permissionHandler.removeCallbacks(permissionRunnable)
        fileWriter?.close()
    }

    fun resumeReading(view: View) {
        this.resume = true
    }

    fun pauseReading(view: View) {
        this.resume = false
    }
}
