package hiro.kt.editor

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.net.Uri
import java.io.OutputStreamWriter

class MainActivity :Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
        	super.onCreate(savedInstanceState)
		setContentView(R.layout.main)
		openWriteFile()

	}
	    fun openWriteFile() {
        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TITLE, "sample1.txt")
        startActivityForResult(intent, 101)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 101 && resultCode == RESULT_OK) {
            if (data?.getData() != null) {
                val uri: Uri = data.getData() as Uri
                val out = contentResolver.openOutputStream(uri)
                val writer = OutputStreamWriter(out)
                writer.write("サンプルテキスト\n2行目")
                writer.close()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


}

