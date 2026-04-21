package za.ac.iie.shinriquest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlascardPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flascard_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Declarations for screen2
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNextQuestion = findViewById<Button>(R.id.btnNextQuestion)
        val tvMyths = findViewById<TextView>(R.id.tvMyth)
        val tvAnswers=findViewById<TextView>(R.id.tvAnswers)
        val btnShowResultScreen=findViewById<Button>(R.id.btnShowResultScreen)

               //declaring my arrays and their questions

           val Myths = arrayOf(
                "1.\nIF YOU REFRESH A PAGE ENOUGH TIMES,\nTHE INTERNET WILL LOAD FASTER",
                "2.\nCLEARING YOUR BROWSER HISTORY DELETES EVERYTHING ABOUT YOU FROM THE INTERNET",
                "3.\nTYPING 'DO A BARREL ROLL' INTO GOOGLE \nMAKES THE SCREEN SPIN "
            )

            val Answers = arrayOf<Boolean>(false, false, true)//first 2 are myths and the last one is a hack
            val explanations = arrayOf<String>(
                "FALSE!\nREFRESHING DOES NOT IMPROVE INTERNET SPEED...\nIT JUST RELOADS THE PAGE...",
                "FALSE!\nIT ONLY REMOVES YOUR LOCAL HISTORY...ON YOUR DEVICE...\n YOUR ONLINE DATA",
                "TRUE!\nTHIS IS A REAL GOOGLE EASTER EGG\nTHAT MAKES THE PAGE ROTATE..\nGO TRY IT"
            )

        var reviewText = ""
        //the while loop is for screen 3
        var counter = 0// outside controller of while
        while (counter <Myths.count()) {
            reviewText += "Q${counter + 1}:${Myths[counter]}\n"
            reviewText += "${explanations[counter]}\n\n"
            counter++//controller inside while
        }
        /* Introduction to Mobile Application,2026
         code(version 2.0),[source code]
        Availabe at :https:advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BCA5A47EE-F107-44AD-AB60-6E296E0B3EAE%7D&file=IMAD5112MM.docx&action=default&mobileredirect=true
        Accessed 21 April 2026*/




        var Index = 0//index starts at 0

        var points = 0//the score is set at 0


        tvMyths.text = Myths[Index] //pops up when you go to screen2
        //the logic for the first..myth..or fact


        tvMyths.text = Myths[Index]
        btnTrue.setOnClickListener {
            if (tvMyths.text.toString() == Myths[Index]) {
                if (Answers[Index] == true) {
                    tvMyths.text = "CORRECT BROCHACHOO..\nMOCHACHO"
                    points++//it adds a point everytime you get a question right

                }else if (Answers[Index] == false) {
                    tvAnswers.text = "WRONG...\nJUST WRONG!!!"



                }
            }}
            btnFalse.setOnClickListener {//if you click on "myth"
                if (tvMyths.text.toString() == Myths[Index]){
                if (Answers[Index] == true) {
                        tvAnswers.text = "AAAANDDDD THAT WAS......\nFALSEEEE"

                    }else if (Answers[Index] == false) {
                        tvAnswers.text = "WE GOT AN EINSTEIN...\nCORRECT"
                        points++


                }


            }}


        //now question 2 and the question 3 logic for answers
        btnNextQuestion.setOnClickListener {
            //this is the current indexex ...like the addition
            Index++

            tvMyths.text = Myths[Index]

            btnTrue.setOnClickListener {
                if (tvMyths.text.toString() == Myths[Index]) {
                    if (Answers[Index] == true) {
                        tvAnswers.text = "OK..THATS CORRECT PAL"
                        points++

                    }else if (Answers[Index] == false) {
                        tvAnswers.text = "YOU ARE SUPER DUPER WRONG"


                    }
                }
            }

            btnFalse.setOnClickListener {
                if (tvMyths.text.toString() == Myths[Index]) {
                    if (Answers[Index] == true) {
                        tvAnswers.text = "SORRY THAT IS FALSEEEE"


                    }else if (Answers[Index] == false) {
                        tvAnswers.text = "WOOHOOO YOU ARE CORRECT"
                        points++

                    }
                }

            }




        }
        btnShowResultScreen.setOnClickListener {//this button takes the user to the next screen and shows the results
            val ScoringScreen = Intent(this, ScoreScreen::class.java)
            ScoringScreen.putExtra("reviewText", reviewText)//the reviewText is the array facts and answers so it'll show to the next screen..that was what the while loop was for
            ScoringScreen.putExtra("points", points)//this will send the score to the next screen...like it'll have your marks tallied up..and shown om screen 3


            startActivity(ScoringScreen)//this actually starts the activity ..if you dont put this then it wont do anything


        }




















    }
}