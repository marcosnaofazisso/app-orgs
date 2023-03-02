package com.marcosviniciusferreira.orgs.ui.dialog

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import coil.load
import com.marcosviniciusferreira.orgs.R
import com.marcosviniciusferreira.orgs.databinding.FormImageBinding

class FormImageDialog(private val context: Context) {

    private var url: String? = null

    fun show() {
        val binding = FormImageBinding.inflate(LayoutInflater.from(context))
        binding.formImageButtonLoad.setOnClickListener {
            url = binding.imageUrlTextField.text.toString()
            binding.formImageImageview.load(url) {
                placeholder(R.drawable.placeholder)
                fallback(R.drawable.fruit_not_found)
                error(R.drawable.fruit_not_found)

                listener(onError = { _, _ ->
                    Toast.makeText(
                        context,
                        "Erro ao carregar URL",
                        Toast.LENGTH_SHORT
                    ).show()
                })

            }


        }

        AlertDialog.Builder(context).setView(binding.root)
            .setPositiveButton("Confirm") { _, _ ->
                url = binding.imageUrlTextField.text.toString()
                Log.i("URL", "ESTA É A URL DA IMAGE: ${url}")
//                binding.activityFormProductImage.load(url) {
//                    placeholder(R.drawable.placeholder)
//                    fallback(R.drawable.fruit_not_found)
//                    error(R.drawable.fruit_not_found)
//
//                    listener(onError = { _, _ ->
//                        Toast.makeText(
//                            this@ProductFormActivity,
//                            "Erro ao carregar URL",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    })
//
//
//                }

            }.setNegativeButton("Cancel") { _, _ -> }.show()
    }
}