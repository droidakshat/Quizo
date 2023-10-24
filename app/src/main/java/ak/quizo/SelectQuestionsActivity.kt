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

            selectedOption=10
            optOne.setBackgroundResource(R.drawable.options)
            // Reset the background of optTwo to its original state
            optTwo.setBackgroundResource(android.R.color.transparent)

        }
        optTwo.setOnClickListener{

            selectedOption=20
            optTwo.setBackgroundResource(R.drawable.options)
            // Reset the background of optTwo to its original state
            optOne.setBackgroundResource(android.R.color.transparent)

        }
        start.setOnClickListener{
            val intent = Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.username,tvname.text.toString())
            intent.putExtra(Constants.questionsNUm,selectedOption)
            startActivity(intent)
        }



    }
}