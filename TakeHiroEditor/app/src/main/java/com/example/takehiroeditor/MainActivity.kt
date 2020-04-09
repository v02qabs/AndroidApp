package com.example.takehiroeditor

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        settingPermission()
        /*val e_text1 = findViewById<EditText>(R.id.editor
        ) as EditText
*/
        //e_text1.setText("Hello")
    }
    fun mygtext(message:String)
    {
        val s_message = Toast.makeText(this, message, Toast.LENGTH_LONG)
        s_message.show()
    }
    fun settingPermission()
    {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    100)

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }

    }
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            100 -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        super.onCreateOptionsMenu(menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val mes = when(item.itemId)
        {
            R.id.s_text ->
            {
                Toast.makeText(this, "共有", Toast.LENGTH_SHORT).show()
                ss_text()
                return true
            }
            R.id.viewer->
            {
                Toast.makeText(this, "プレビュー", Toast.LENGTH_SHORT).show()
                viewer()
                return true
            }
            R.id.fliststring->
            {
                fdialog()
                return true
            }
            else ->
            {
                return false
            }
        }
    }

    fun viewer() {
        val e_text = findViewById<EditText>(R.id.editor )
        try {
            File("/data/data/com.example.takehiroeditor/index.txt").bufferedReader().use()
            { reader ->
                var str=reader.readLine()
                while (str != null) {
                    e_text.setText(str)

                    str=reader.readLine()
                }
            }
        }
        catch(e:java.lang.Exception)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }
fun ss_text() {
        try {

                fdialog()
                Toast.makeText(this, "success.", Toast.LENGTH_SHORT).show()
        }catch (
            e:Exception
        )
        {
            Toast.makeText(this,
                "失敗", Toast.LENGTH_SHORT).show()
        }
        finally {

        }
    }
    fun fdialog()
    {
        val flistRoot = ListView(this)
        val e_text = findViewById<EditText>(R.id.editor )
       val intent = Intent(this, SelectFiles::class.java)
        startActivity(intent)
    }
    fun f_write(title:String) {

        val e_text = findViewById<EditText>(R.id.editor
        ) as EditText
        try {
            val write=PrintWriter(BufferedWriter(FileWriter("/data/data/com.example.takehiroeditor/" + title)))
            write.println(e_text.text.toString())
            write.close()
            Toast.makeText(this, "OK.", Toast.LENGTH_SHORT).show()
        }
        catch (e:Exception)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

}