package com.example.trainingnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trainingnote.DataBase.MyDbManager
import com.example.trainingnote.DataBase.MyIntentConstants
import com.example.trainingnote.databinding.ActivityTextExerciseBinding

class TextExercise : AppCompatActivity() {
    lateinit var binding: ActivityTextExerciseBinding
    val myDbManager = MyDbManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myDbManager.openDb()
        getMyIntents()
    }


    override fun onResume() {
        super.onResume()

    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

    fun getMyIntents() {
        val intent = intent
        if (intent != null && intent.getStringExtra(MyIntentConstants.I_TITLE_KEY) != null) {

            binding.apply {
                textExercise.setText(intent.getStringExtra(MyIntentConstants.I_TITLE_KEY))
                textData1.setText(intent.getStringExtra(MyIntentConstants.I_DATA1_KEY))
                textData2.setText(intent.getStringExtra(MyIntentConstants.I_DATA2_KEY))

                textW1.setText(intent.getStringExtra(MyIntentConstants.I_WEIGHT1_KEY))
                textQ1.setText(intent.getStringExtra(MyIntentConstants.I_QUANTITY1_KEY))

                textW2.setText(intent.getStringExtra(MyIntentConstants.I_WEIGHT2_KEY))
                textQ2.setText(intent.getStringExtra(MyIntentConstants.I_QUANTITY2_KEY))

                textW3.setText(intent.getStringExtra(MyIntentConstants.I_WEIGHT3_KEY))
                textQ3.setText(intent.getStringExtra(MyIntentConstants.I_QUANTITY3_KEY))

                textW4.setText(intent.getStringExtra(MyIntentConstants.I_WEIGHT4_KEY))
                textQ4.setText(intent.getStringExtra(MyIntentConstants.I_QUANTITY4_KEY))

                textW5.setText(intent.getStringExtra(MyIntentConstants.I_WEIGHT5_KEY))
                textQ5.setText(intent.getStringExtra(MyIntentConstants.I_QUANTITY5_KEY))

                textW6.setText(intent.getStringExtra(MyIntentConstants.I_WEIGHT6_KEY))
                textQ6.setText(intent.getStringExtra(MyIntentConstants.I_QUANTITY6_KEY))


            }
        }
    }
}