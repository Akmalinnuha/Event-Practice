package com.akmalinnuha.eventpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Segitiga : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtSurface: EditText
    private lateinit var edtHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segitiga)

        edtSurface = findViewById(R.id.edt_surface)
        edtHeight = findViewById(R.id.edt_height)
        btnCalculate = findViewById(R.id.btn_calculate_triangle)
        tvResult = findViewById(R.id.tv_result_triangle)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }
    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate_triangle) {
            val inputSurface = edtSurface.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyFields = false

            if (inputSurface.isEmpty()) {
                isEmptyFields = true
                edtSurface.error = "Field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                edtHeight.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyFields) {
                val volume = inputSurface.toDouble() * inputHeight.toDouble() / 2
                tvResult.text = volume.toString()
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }
}