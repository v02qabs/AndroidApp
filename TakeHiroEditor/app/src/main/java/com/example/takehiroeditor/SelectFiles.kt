package com.example.takehiroeditor

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import android.widget.ArrayAdapter as ArrayAdapter

class SelectFiles : AppCompatActivity() {
    val pwd = "/data/data/com.example.takehiroeditor/files"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selectfile)
        val fview = findViewById<ListView>(R.id.fview)
        val fpwd = EditText(this)

        fpwd.setText(pwd)
        val flist = File(pwd).list()
        //val fmkdir = File(pwd + "dir").mkdir()
        val aAdapter= ArrayAdapter(this, android.R.layout.simple_list_item_1, flist)
        fview.adapter = aAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        super.onCreateOptionsMenu(menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.selectfiles, menu)

        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val mes = when(item.itemId)
        {
            R.id.mkdirs-> {
                mymkdris()
                return true
            }
            else ->
            {
                return false
            }
        }
    }

    private fun mymkdris(){
        val mlist = File(pwd + "/bin").mkdir()
        if(mlist == true)
            Toast.makeText(this, "craete dir sucess.", Toast.LENGTH_SHORT).show()
        val lists = File(pwd).list()
        val aAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, lists)
        val fview = findViewById<ListView>(R.id.fview)
        fview.adapter = aAdapter
    }
}