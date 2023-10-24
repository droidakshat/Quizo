package ak.quizo

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionlist: ArrayList<question>? = null
    private var mselectedOptionPosition: Int = 0
    private var mUSername: String? = null
    private var mQuestionNum:Int?=null
    private var mCorrectanswer: Int = 0
    private var num:Int =0


    private var progessbar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUSername = intent.getStringExtra(Constants.username)
        mQuestionNum=intent.getIntExtra(Constants.questionsNUm,0)
        num=mQuestionNum?:0



        progessbar = findViewById(R.id.progressbar)
        tvProgress = findViewById(R.id.tv_progrss)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        mQuestionlist = getRandomQuestions(num) //constain.getquestions

        setQuestion()


    }
    private fun getRandomQuestions(num: Int): ArrayList<question> {
        val allQuestions = Constants.getQuestion()
        val list = allQuestions.shuffled().take(num)
        return ArrayList(list)
    }


    private fun setQuestion() {
        defaultOption()
        val ques: question = mQuestionlist!![mCurrentPosition - 1]

        ivImage?.setImageResource(ques.image)
        progessbar?.max = num?: 0
        progessbar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progessbar?.max}"
        tvQuestion?.text = ques.questions
        tvOptionOne?.text = ques.optionOne
        tvOptionTwo?.text = ques.optionTwo
        tvOptionThree?.text = ques.optionThree
        tvOptionFour?.text = ques.optionFour

        if (mCurrentPosition == mQuestionlist!!.size)
            btnSubmit?.text = "Check Result"
        else
            btnSubmit?.text = "SUBMIT"
    }

    private fun defaultOption() {
        val options = arrayListOf<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }
        for (option in options) {
            option.setTextColor(Color.parseColor("#41393E"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.borderbg

            )
        }
    }


    private fun selectedOption(tv: TextView, selectedOptionNum: Int) {
        defaultOption()
        mselectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_bg_option
        )
    }

    private fun selCorrOpt(tv: TextView, selectedOptionNum: Int) {
        defaultOption()
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option_one -> {
                tvOptionOne?.let {
                    selectedOption(it, 1)
                }
            }

            R.id.tv_option_two -> {
                tvOptionTwo?.let {
                    selectedOption(it, 2)
                }
            }

            R.id.tv_option_three -> {
                tvOptionThree?.let {
                    selectedOption(it, 3)
                }
            }

            R.id.tv_option_four -> {
                tvOptionFour?.let {
                    selectedOption(it, 4)
                }
            }

            R.id.btn_submit -> {
                if (mselectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionlist!!.size -> {
                            setQuestion()
                        }

                        else -> {
                            if(mCorrectanswer>5&&num==10 ||mCorrectanswer>10&&num==20){
                            val intent = Intent(this, result::class.java)
                            intent.putExtra(Constants.username, mUSername)
                            intent.putExtra(Constants.correctAnswers, mCorrectanswer)
                            intent.putExtra(Constants.totalQuestion, mQuestionlist?.size)
                                intent.putExtra(Constants.questionsNUm,num)
                            startActivity(intent)
                            finish()}
                            else{
                                val intent = Intent(this, ResultActivity2::class.java)
                                intent.putExtra(Constants.username, mUSername)
                                intent.putExtra(Constants.correctAnswers, mCorrectanswer)
                                intent.putExtra(Constants.totalQuestion, mQuestionlist?.size)
                                intent.putExtra(Constants.questionsNUm,num)
                                startActivity(intent)
                                finish()
                            }

                        }
                    }
                } else {
                    val quest = mQuestionlist?.get(mCurrentPosition - 1)
                    if (quest!!.correctAnswer != mselectedOptionPosition) {
                        answerview(mselectedOptionPosition, R.drawable.wrong_option_bg)
                    } else {
                        mCorrectanswer++
                    }
                    answerview(quest.correctAnswer, R.drawable.correct_option_bg)


                    if (mCurrentPosition == mQuestionlist!!.size) {
                        btnSubmit?.text = "FINISH"
                    } else {
                        btnSubmit?.text = "NEXT QUESTION"
                    }
                    mselectedOptionPosition = 0

                }

            }
        }
    }

    fun answerview(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )

            }

            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }

    }

}
/*1.add page before quiz to display no of questions,intent to this page
2.add num onclicklistener
set fail condition in a new var
add 50 more question
edit processbar

 */