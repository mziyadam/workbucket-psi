package com.ziyad.workbucket.biografigenerator.viewmodel

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BiogenViewModel : ViewModel() {
    var nama = MutableLiveData<String>("")
    var asal = MutableLiveData<String>("")
    var ide = MutableLiveData<String>("")
    var paragraf = MutableLiveData<String>("")
    fun clear() {
        nama.value = ""
        asal.value = ""
        ide.value = ""
        paragraf.value = ""
    }

    fun String.capitalizeWords() = split(' ').joinToString(" ", transform = String::capitalize)

    fun generateParagraf(nama1: String, asal1: String, ide1: String) {
        if (nama1 == "" || asal1 == "" || ide1 == "") {
            paragraf.value = "Lengkapi data terlebih dahulu!"
            return
        }
        nama.value = nama1.capitalizeWords()
        asal.value = asal1.capitalizeWords()
        ide.value = ide1.capitalizeWords()
        paragraf.value = "Nama saya ${nama.value}. Saya berasal dari ${asal.value}. Saya memiliki ide menarik dalam menjalankan bisnis. Bagaimana kalau kita membuat ${ide.value}."
    }

    fun copyToClipboard(activity: Activity, context: Context) {
        if (paragraf.value != "Lengkapi data terlebih dahulu!") {
            val clipboard: ClipboardManager =
                activity.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("paragraf", paragraf.value)
            clipboard.setPrimaryClip(clip)
        } else {
            Toast.makeText(context, "Lengkapi data terlebih dahulu!", Toast.LENGTH_SHORT)
                .show()
        }
    }
}