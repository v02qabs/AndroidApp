package com.hiro.take.mywebview

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : Activity() {

    private lateinit var urlEditText: EditText
    private lateinit var downloadLocalText: EditText
    private lateinit var downloadButton: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        
        urlEditText = findViewById(R.id.urlEditText)
        downloadLocalText = findViewById(R.id.download_local_Text)
        downloadButton = findViewById(R.id.downloadButton)

        downloadButton.setOnClickListener {
            val fileUrl = urlEditText.text.toString()
            val fileName = downloadLocalText.text.toString()
            if (fileUrl.isNotEmpty() && fileName.isNotEmpty()) {
                downloadFile(fileUrl, fileName)
            } else {
                Toast.makeText(this, "URLまたはファイル名を入力してください", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun downloadFile(fileUrl: String, fileName: String) {
        GlobalScope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                downloadFileInBackground(fileUrl, fileName)
            }
            Toast.makeText(this@MainActivity, result, Toast.LENGTH_LONG).show()
        }
    }

    private fun downloadFileInBackground(fileUrl: String, fileName: String): String {
        var inputStream: BufferedInputStream? = null
        var fileOutputStream: FileOutputStream? = null
        return try {
            val url = URL(fileUrl)
            val connection = url.openConnection() as HttpURLConnection
            connection.connect()

            if (connection.responseCode != HttpURLConnection.HTTP_OK) {
                return "サーバーエラー: ${connection.responseCode} ${connection.responseMessage}"
            }

            inputStream = BufferedInputStream(connection.inputStream)
            
            // アプリ内の内部ストレージへの保存 (外部ストレージを使用しない)
            val outputFile = File(getExternalFilesDir(null), fileName)
            fileOutputStream = FileOutputStream(outputFile)

            val buffer = ByteArray(1024)
            var bufferLength: Int
            while (inputStream.read(buffer).also { bufferLength = it } > 0) {
                fileOutputStream.write(buffer, 0, bufferLength)
            }

            "ダウンロード完了: ${outputFile.absolutePath}"

        } catch (e: IOException) {
            "エラー: ${e.message}"
        } finally {
            try {
                inputStream?.close()
                fileOutputStream?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}

