package com.example.sqlitecrud

import android.content.Intent

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class GetAllUsersActivity : AppCompatActivity() {

    private var btnStore: Button? = null
    private var etname: EditText? = null
    private var ethobby: EditText? = null
    private var databaseHelper: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.getuser)
        databaseHelper = DatabaseHelper(this)
        btnStore = findViewById(R.id.btnstore) as Button
        etname = findViewById(R.id.etname) as EditText
        ethobby = findViewById(R.id.ethobby) as EditText

     btnStore!!.setOnClickListener {
        var name:String=etname?.text.toString()
        var designation:String=ethobby?.text.toString()

        if(name.length>0 && designation.length>-0){

            databaseHelper!!.addUserDetail(etname!!.text.toString(), ethobby!!.text.toString())
            etname!!.setText("")
            ethobby!!.setText("")
            val intent = Intent(this@GetAllUsersActivity, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(
                this@GetAllUsersActivity,
                "Stored Success  ! $name $designation",
                Toast.LENGTH_SHORT
            )
                .show()

        }
        else {
            Toast.makeText(this,"enter valid credentials",Toast.LENGTH_LONG).show()

        }
    }



    }
}