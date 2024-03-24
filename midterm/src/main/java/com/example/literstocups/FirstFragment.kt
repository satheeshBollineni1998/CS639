package com.example.literstocups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.literstocups.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Accessing views from binding
        val editTextLiters = binding.editTextLiters
        val buttonConvert = binding.buttonConvert
        val textViewResult = binding.textViewResult

        buttonConvert.setOnClickListener {
            convertLitersToCups(editTextLiters, textViewResult)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun convertLitersToCups(editTextLiters: EditText, textViewResult: TextView) {
        val litersStr = editTextLiters.text.toString()
        if (litersStr.isNotEmpty()) {
            val liters = litersStr.toDouble()
            val cups = liters * 4.22
            textViewResult.text = String.format("%.2f liters = %.2f cups", liters, cups)
        } else {
            textViewResult.text = "Please enter a value."
        }
    }
}
