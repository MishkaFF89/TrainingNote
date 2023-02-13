package com.example.trainingnote

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface.BUTTON_POSITIVE
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingnote.DataBase.MyAdapter
import com.example.trainingnote.DataBase.MyDbManager
import com.example.trainingnote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val myDbManager = MyDbManager(this)
    val myAdapter = MyAdapter(ArrayList(), this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFragment(HomeFragment.newInstance(), R.id.frame_home_layout)
        binding.navMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    openFragment(HomeFragment.newInstance(), R.id.frame_home_layout)
                    binding.rcViewM.visibility = View.VISIBLE
                }
                R.id.newEx ->{
                    openFragment(NewExerciceFragment.newInstance(),R.id.frame_home_layout)
                    binding.rcViewM.visibility = View.GONE
                }

            }
            true
        }



    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()

        init()
        fillAdapter()

    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

    private fun openFragment(f: Fragment, idHolder: Int) {
        supportFragmentManager.beginTransaction()
            .replace(idHolder, f)
            .commit()

    }

    fun init() {
        binding.rcViewM.layoutManager = LinearLayoutManager(this)
        binding.rcViewM.adapter = myAdapter

        val swapHelper = getSwapMg()
        swapHelper.attachToRecyclerView(binding.rcViewM)
    }

    fun fillAdapter() {
        val list = myDbManager.readDbData("")
        myAdapter.updateAdapter(list)
    }

    private fun getSwapMg(): ItemTouchHelper {
        return ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                myAdapter.removeItem(viewHolder.layoutPosition, myDbManager)
            }


        })


    }




}
