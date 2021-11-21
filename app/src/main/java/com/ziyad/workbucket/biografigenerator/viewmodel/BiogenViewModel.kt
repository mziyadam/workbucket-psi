package com.ziyad.workbucket.biografigenerator.viewmodel

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ziyad.workbucket.setting.view.SettingFragment

class BiogenViewModel : ViewModel() {
    var nama = MutableLiveData<String>("")
    var asal = MutableLiveData<String>("")
    var ide = MutableLiveData<String>("")
    var paragraf = MutableLiveData<String>("")
    var email = MutableLiveData<String>("")
    fun clear() {
        nama.value = ""
        asal.value = ""
        ide.value = ""
        paragraf.value = ""
        email.value=""
    }

    fun String.capitalizeWords() = split(' ').joinToString(" ", transform = String::capitalize)

    fun generateParagraf(nama1: String, asal1: String, ide1: String, email1: String) {
        if (nama1 == "" || asal1 == "" || ide1 == ""||email1=="") {
            paragraf.value = "Lengkapi data terlebih dahulu!"
            return
        }
        nama.value = nama1.capitalizeWords()
        asal.value = asal1.capitalizeWords()
        ide.value = ide1.capitalizeWords()
        email.value=email1
        paragraf.value = "Nama saya ${nama.value}. Saya berasal dari ${asal.value}. Saya memiliki ide menarik dalam menjalankan bisnis. Bagaimana kalau kita membuat ${ide.value}. Jika tertarik anda dapat menghubungi saya di ${email.value}"
    }

    fun copyToClipboard(activity: Activity, context: Context) {
        if (paragraf.value != "Lengkapi data terlebih dahulu!") {
            SettingFragment.doAsync {
                val clipboard: ClipboardManager =
                    activity.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("paragraf", paragraf.value)
                clipboard.setPrimaryClip(clip)
            }.execute()
            } else {
                Toast.makeText(context, "Lengkapi data terlebih dahulu!", Toast.LENGTH_SHORT)
                    .show()
            }

    }
    fun translate(context: Context){
        if (paragraf.value != "Lengkapi data terlebih dahulu!"&&paragraf.value !="") {
            val webpage: Uri = Uri.parse("https://translate.google.com/?q=${paragraf.value}")
            val intent = Intent(Intent.ACTION_VIEW, webpage)

            startActivity(context,intent,null)
        } else {
            Toast.makeText(context, "Lengkapi data terlebih dahulu dan klik submit!", Toast.LENGTH_SHORT)
                .show()
        }

    }
}