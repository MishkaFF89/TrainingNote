package com.example.trainingnote

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trainingnote.DataBase.MyAdapter

import com.example.trainingnote.databinding.FragmentNewExerciseBinding


class NewExerciceFragment : Fragment() {
    lateinit var binding: FragmentNewExerciseBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentNewExerciseBinding.inflate(inflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonNewEx.setOnClickListener{
           startActivity(Intent(context, AddNewExercise::class.java))
        }

        binding.buttonCardio.setOnClickListener{
            startActivity(Intent(context, AddCardioExercise::class.java))
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =NewExerciceFragment()

    }
}