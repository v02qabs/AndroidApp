package com.example.myconsole

import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import android.widget.*;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        file_writer()
    }

    fun file_writer() {
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            // 外部ストレージに保存するファイルのパスを指定
            val file = File(getExternalFilesDir(null), "Hello.txt")
            // ファイルに書き込む
            FileOutputStream(file).use { outputStream ->
                outputStream.write("Hello".toByteArray())
            }
            showToast("ファイルに書き込みました: ${file.absolutePath}")
        } else {
            showToast("外部ストレージがマウントされていません")
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
