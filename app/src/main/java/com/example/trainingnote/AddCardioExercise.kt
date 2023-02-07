package com.example.trainingnote

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import com.example.trainingnote.DataBase.MyDbManager
import com.example.trainingnote.databinding.ActivityAddCardioExerciseBinding
import java.text.SimpleDateFormat
import java.util.*

class AddCardioExercise : AppCompatActivity() {
    lateinit var binding: ActivityAddCardioExerciseBinding
    val myDbManager = MyDbManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCardioExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
    }
    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

    fun saveCardio(view: View) {
        binding.apply {
            val edTitle = edCardio.text.toString()

            val time = edTime.text.toString()
            val distance = edDist.text.toString() + " км"

            val data1 = "Время"
            val data2 = "КМ"
            val type = "0"
            if (edTitle != "" && time != "" && distance !="") myDbManager.insertToDb( edTitle, time,distance, "", "", "", ""
                ,"", "", "", "","", "", type, getCurrentTime(),data1,data2)



        }




        showDialog("Внимание")

    }
    private fun getCurrentTime(): String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd MMM ", Locale.getDefault())
        return formatter.format(time)
    }

    private fun showDialog(title: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.alert_dialog)

        val yesBtn = dialog.findViewById(R.id.yesbutton) as ImageButton
        val noBtn = dialog.findViewById(R.id.nobutton) as ImageButton
        yesBtn.setOnClickListener {
            finish()
        }
        noBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}