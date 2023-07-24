package ak.quizo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SelectQuestionsActivity : AppCompatActivity() {
    private var selectedOption:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_questions)
        val tvname: TextView =findViewById(R.id.username)
        tvname.text=intent.getStringExtra(Constants.username)
        var optOne:Button=findViewById(R.id.op1)
        var optTwo:Button=findViewById(R.id.op2)
        var start:Button=findViewById(R.id.Start)

        optOne.setOnClickListener{
        //  var   valueToStore = optOne.text.toString().toIntOrNull()
          //  selectedOption=valueToStore
            selectedOption=10
        }
        optTwo.setOnClickListener{
           // var valueToStore = optTwo.text.toString().toIntOrNull()
            //selectedOption=valueToStore
            selectedOption=20
        }
        start.setOnClickListener{
            val intent = Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.username,tvname.text.toString())
            intent.putExtra("questionsNo",selectedOption)
            startActivity(intent)
        }



    }
}