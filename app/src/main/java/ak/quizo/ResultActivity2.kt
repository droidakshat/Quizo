package ak.quizo

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat

class ResultActivity2 : AppCompatActivity() {
    private lateinit var mediaplayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        val tvname:TextView=findViewById(R.id.username)
        val tvscore:TextView=findViewById(R.id.score)
        val btnFinish:Button=findViewById(R.id.finish)
        var need:Int=0

        tvname.text=intent.getStringExtra(Constants.username)
        val correctAnswers=intent.getIntExtra(Constants.correctAnswers,0)
        val totalAnswer=intent.getIntExtra(Constants.totalQuestion,0)
        val questionnum=intent.getIntExtra(Constants.questionsNUm,0)
        if(questionnum==10) {
            need= 5 - correctAnswers
        }else{
             need =11-correctAnswers
        }

        tvscore.text="Your Score is $correctAnswers out of $totalAnswer"


        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

        playMusic()

            Toast.makeText(this, "Needed $need more points to win", Toast.LENGTH_LONG).show()


    }

    private fun playMusic() {
        mediaplayer=MediaPlayer.create(this, R.raw.comp2)
        mediaplayer.start()
        mediaplayer.setVolume(1f,1f)
    }
}