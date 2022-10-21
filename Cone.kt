package com.akmalinnuha.eventpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.PI
import kotlin.math.sqrt

class Cone : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtRadius: EditText
    private lateinit var edtHeightCone: EditText
    private lateinit var btnCalculateCone: Button
    private lateinit var tvResultCone: TextView
    private val pi : Double = 3.14
    private val pertiga : Double = 0.33

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cone)

        edtRadius = findViewById(R.id.edt_radius)
        edtHeightCone = findViewById(R.id.edt_height_cone)
        btnCalculateCone = findViewById(R.id.btn_calculate_cone)
        tvResultCone = findViewById(R.id.tv_result_triangle)

        btnCalculateCone.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(Cone.STATE_RESULT)
            tvResultCone.text = result
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate_cone) {
            val inputRadius = edtRadius.text.toString().trim()
            val inputHeightC = edtHeightCone.text.toString().trim()

            var isEmptyFields = false

            if (inputRadius.isEmpty()) {
                isEmptyFields = true
                edtRadius.error = "Field ini tidak boleh kosong"
            }
            if (inputHeightC.isEmpty()) {
                isEmptyFields = true
                edtHeightCone.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyFields) {
                val kuadrat = inputRadius.toDouble() * inputRadius.toDouble()
                val volume = pertiga * pi * kuadrat * inputHeightC.toDouble()
                tvResultCone.text = volume.toString()
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(Cone.STATE_RESULT, tvResultCone.text.toString())
    }
}