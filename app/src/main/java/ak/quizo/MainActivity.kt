package ak.quizo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnStart:Button=findViewById(R.id.btn_str)
        var et_name:EditText=findViewById(R.id.et_start)
        btnStart.setOnClickListener{
            if (et_name.text.isEmpty()){
                Toast.makeText(this,"Enter Name!", Toast.LENGTH_SHORT).show()
            }else{
                val intent= Intent(this,SelectQuestionsActivity::class.java)
                intent.putExtra(Constants.username,et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}