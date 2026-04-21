package za.ac.iie.shinriquest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnPlayAgain = findViewById<Button>(R.id.btnPlayAgain)
        val tvPoints = findViewById<TextView>(R.id.tvPoints)
        val btnShowResult = findViewById<Button>(R.id.btnShowReview)
        val bundle: Bundle? = intent.extras
        val points = bundle?.getInt("points",0)
        val reviewText = bundle?.getString("reviewText")
        // val score=  intent.getIntExtra("score",0)



        if(points==0 ) {
            tvPoints.text== "\uD83D\uDE2CYOU GOT 0 scores...\nTRY HARDER NEXT TIME..\nITS GENERAL KNOWLEDGE\uD83D\uDE2C" }
            else if
                ( points== 1  ) {
                tvPoints.text = "\uD83C\uDF4B\u200D\uD83D\uDFE9YOUR SCORE IS 1 ..\nARE YOU LOST LIKE ZORO..\n A SCORE OF 1 IS JUST EMBARASSING\uD83C\uDF4B\u200D\uD83D\uDFE9"
                }
               else if
                        (points == 2) {
                    tvPoints.text = "\uD83E\uDD51YOUR SCORE IS 2..\nTHATS AMAZING!!!!! \nYOU ARE JUST 1 POINT AWAY FROM \nTOTAL AWESOMENESS\uD83E\uDD51"
                        }
                   else if
                            (points == 3) {
                        tvPoints.text = "\uD83E\uDD5DYOUR SCORE IS 3..\nTHAT IS 100%..\nYOU ARE A REAL KNOW-IT-ALL..\uD83E\uDD5D"
                            }


        btnShowResult.setOnClickListener {
            tvPoints.text=reviewText
        }


        btnPlayAgain.setOnClickListener {
            val MainActivity= Intent(this, MainActivity::class.java)
            startActivity(MainActivity)
        }
























    }
}