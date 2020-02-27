package com.example.tugas4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imgBtn = findViewById<ImageButton>(R.id.imgButtonAdd)
        imgBtn.setOnClickListener{
            if (rbPria.isChecked) {
                val Pria = "Nama : "+editNama.text.toString()+ ", Gender " + rbPria.text.toString() + " telah berhasil disimpan"
                createToast(Pria)
            } else if (rbWanita.isChecked) {
                val Wanita = "Nama : " +  editNama.text.toString() + ", Gender " + rbWanita.text.toString() + " telah berhasil disimpan"
                createToast(Wanita)
            }
        }
        imgButtonCancel.setOnClickListener {
            editNama.getText().clear()
            radioGroup.clearCheck()

        }

        printHobi(cbCoding)
        printHobi(cbReading)
        printHobi(cbTraveling)

    }

    private fun printHobi(cb: CheckBox) {
        cb.setOnClickListener {
            if (cb.isChecked) {
                createToast(textPilih(cb.text.toString()))
            } else {
                createToast(textBatal(cb.text.toString()))
            }
        }
    }

    private fun textPilih(text: String): String {
        return "Anda memilihi hobi " + text
    }

    private fun textBatal(text: String): String {
        return "Anda membatalkan pilihan hobi " + text
    }

    // Fungsi Membuat Toast
    private fun createToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
