package com.example.trainingnote

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageButton
import com.example.trainingnote.DataBase.MyDbManager
import com.example.trainingnote.databinding.ActivityAddNewExerciseBinding
import java.text.SimpleDateFormat
import java.util.*

class AddNewExercise : AppCompatActivity() {
    lateinit var binding : ActivityAddNewExerciseBinding
    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewExerciseBinding.inflate(layoutInflater)
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

    fun saveEx(view: View) {
        binding.apply {
            val edTitle = edExercise.text.toString()

            val weigh1 = edWeight1.text.toString() + " кг"
            val quant1 = edQua1.text.toString()

            var weigh2 = edWeight2.text.toString()
            val quant2 = edQua2.text.toString()

            var weigh3 = edWeight3.text.toString()
            val quant3 = edQua3.text.toString()

            var weigh4 = edWeight4.text.toString()
            val quant4 = edQua4.text.toString()

            var weigh5 = edWeight5.text.toString()
            val quant5 = edQua5.text.toString()

            var weigh6 = edWeight6.text.toString()
            val quant6 = edQua6.text.toString()

            val data1 = "Вес"
            val data2 = "Кол-во"
            val type = "1"
            if (edTitle != "" && weigh1 !="" && quant1 !="") {
                when{
                    weigh2 != "" -> weigh2 = "$weigh2 кг"
                    weigh3 != "" -> weigh3 = "$weigh3 кг"
                    weigh4 != "" -> weigh4 = "$weigh4 кг"
                    weigh5 != "" -> weigh5 = "$weigh5 кг"
                    weigh6 != "" -> weigh6 = "$weigh6 кг"
                }

                myDbManager.insertToDb(
                    edTitle, weigh1, quant1, weigh2,
                    quant2, weigh3, quant3, weigh4, quant4, weigh5, quant5, weigh6, quant6, type, getCurrentTime(), data1,data2)

            }
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