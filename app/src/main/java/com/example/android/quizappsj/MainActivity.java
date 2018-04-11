package com.example.android.quizappsj;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Scores - variables declaration

    private int scoreQ1;
    private int scoreQ2;
    private int scoreQ3;
    private int scoreQ4;
    private int scoreQ5;

    // Total Score - variable declaration and initialization

    private int score = 0;

    // Answers - variables declaration

    private CheckBox ans1A;
    private CheckBox ans1B;
    private CheckBox ans1C;
    private CheckBox ans1D;
    private RadioButton ans2A;
    private EditText ans3;
    private RadioButton ans4B;
    private RadioButton ans5B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Answers - variables initialization

        ans1A = (CheckBox) this.findViewById(R.id.ans1A);
        ans1B = (CheckBox) this.findViewById(R.id.ans1B);
        ans1D = (CheckBox) this.findViewById(R.id.ans1C);
        ans1C = (CheckBox) this.findViewById(R.id.ans1D);
        ans2A = (RadioButton) this.findViewById(R.id.ans2A);
        ans3 = (EditText) this.findViewById(R.id.ans3);
        ans4B = (RadioButton) this.findViewById(R.id.ans4B);
        ans5B = (RadioButton) this.findViewById(R.id.ans5B);
    }

    // Checking answer 1

    private void checkAnswer1() {
        boolean a;
        boolean b;
        boolean c;
        boolean d;

        a = ans1A.isChecked();
        b = ans1B.isChecked();
        c = ans1C.isChecked();
        d = ans1D.isChecked();

        if (a && !b && c && d) {
            scoreQ2 = 1;
        }
    }

    // Checking answer 2

    private void checkAnswer2() {
        boolean correct;
        correct = ans2A.isChecked();
        if (correct) {
            scoreQ1 = 1;
        }
    }

    // Checking answer 3

    private void checkAnswer3() {
        String correct;
        correct = ans3.getText().toString().trim();
        if (correct.equals("8")) {
            scoreQ3 = 1;
        }
    }

    // Checking answer 4

    private void checkAnswer4() {
        boolean correct;
        correct = ans4B.isChecked();
        if (correct) {
            scoreQ4 = 1;
        }
    }

    // Checking answer 5

    private void checkAnswer5() {
        boolean correct;
        correct = ans5B.isChecked();
        if (correct) {
            scoreQ5 = 1;
        }
    }

    // Clicking Submit Button

    public void onClickSubmit(View view) {

        checkAnswer1();
        checkAnswer2();
        checkAnswer3();
        checkAnswer4();
        checkAnswer5();

        // Total Score

        score = scoreQ1 + scoreQ2 + scoreQ3 + scoreQ4 + scoreQ5;

        // Toast text

        CharSequence text;
        text = "Score: " + score + " correct answers!";

        // Displaying Toast

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}