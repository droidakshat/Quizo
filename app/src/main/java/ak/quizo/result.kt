package ak.quizo

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat

class result : AppCompatActivity() {
    private lateinit var mediaplayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvname:TextView=findViewById(R.id.username)
        val tvscore:TextView=findViewById(R.id.score)
        val btnFinish:Button=findViewById(R.id.finish)

     tvname.text=intent.getStringExtra(Constants.username)
        val correctAnswers=intent.getIntExtra(Constants.correctAnswers,0)
        val totalAnswer=intent.getIntExtra(Constants.totalQuestion,0)

        tvscore.text="Your Score is $correctAnswers out of $totalAnswer"


        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

        playMusic()


    }

    private fun playMusic() {
        mediaplayer=MediaPlayer.create(this, R.raw.complete)
        mediaplayer.start()
        mediaplayer.setVolume(1f,1f)
    }
}