package com.marcosviniciusferreira.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.marcosviniciusferreira.orgs.databinding.FormImageBinding
import com.marcosviniciusferreira.orgs.extensions.tryLoadImage

class FormImageDialog(private val context: Context) {

    private var url: String? = null

    fun show(defaultUrl: String? = null, whenImageLoaded: (imageUrl: String) -> Unit) {

        val binding = FormImageBinding.inflate(LayoutInflater.from(context)).apply {
            defaultUrl?.let {
                formImageImageview.tryLoadImage(it)
                imageUrlTextField.setText(it)
            }

        }


        binding.formImageButtonLoad.setOnClickListener {
            url = binding.imageUrlTextField.text.toString()
            binding.formImageImageview.tryLoadImage(url)

        }

        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirm") { _, _ ->
                url = binding.imageUrlTextField.text.toString()
                binding.formImageImageview.tryLoadImage(url)
                whenImageLoaded(url!!)

            }.setNegativeButton("Cancel") { _, _ -> }.show()
    }
}