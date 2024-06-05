package hiro.kt.editor

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.OutputStreamWriter

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        // 権限の確認と要求
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        } else {
            val uri = getDocumentDirectoryUri()
            displayUri(uri)
        }
    }

    private fun getDocumentDirectoryUri(): Uri? {
        val documentsPath: File? = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        return documentsPath?.let {
            Uri.fromFile(it)
        }
    }

    private fun displayUri(uri: Uri?) {
        uri?.let {
            Toast.makeText(this, "Document Directory URI: $it", Toast.LENGTH_SHORT).show()
        } ?: run {
            Toast.makeText(this, "Documents directory not available.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            val uri = getDocumentDirectoryUri()
            displayUri(uri)
        } else {
            Toast.makeText(this, "Permission denied.", Toast.LENGTH_SHORT).show()
        }
    }

    fun openWriteFile() {
        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TITLE, "sample1.txt")
        startActivityForResult(intent, 101)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 101 && resultCode == RESULT_OK) {
            data?.data?.let { uri ->
                contentResolver.openOutputStream(uri)?.use { out ->
                    val writer = OutputStreamWriter(out)
                    writer.write("サンプルテキスト\n2行目")
                    writer.close()
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}

