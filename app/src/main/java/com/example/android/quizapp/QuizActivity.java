package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    // This variable will work as the score, it will be incremented when the user get any question right.
    private int result = 0;
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private EditText editText;
    private CheckBox checkBox;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        inflate();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkQuestion1();
                checkQuestion2();
                checkQuestion3();
                checkQuestion4();
                checkQuestion5();
                Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                i.putExtra("result", result);
                startActivity(i);
                // I have used this method so that the user cannot return to the quiz page.
                finish();
            }
        });
    }

    private void checkQuestion1() {
        int answer = radioGroup1.getCheckedRadioButtonId();
        if (answer == R.id.radio_q1_ans) {
            result++;
        }
    }

    private void checkQuestion2() {
        if (TextUtils.isEmpty(editText.getText().toString())) {
        } else {
            int answer = Integer.parseInt(String.valueOf(editText.getText()));
            if (answer == 2019) {
                result++;
            }
        }
    }

    private void checkQuestion3() {
        if (checkBox.isChecked() && checkBox1.isChecked()) {
            if (checkBox2.isChecked()) {
            } else {
                result++;
            }
        }
    }

    private void checkQuestion4() {
        int answer = radioGroup2.getCheckedRadioButtonId();
        if (answer == R.id.radio_q4_ans) {
            result++;
        }
    }

    private void checkQuestion5() {
        int answer = radioGroup3.getCheckedRadioButtonId();
        if (answer == R.id.radio_q5_ans) {
            result++;
        }
    }

    private void inflate() {
        radioGroup1 = findViewById(R.id.first_radio_group);
        radioGroup2 = findViewById(R.id.second_radio_group);
        radioGroup3 = findViewById(R.id.third_radio_group);
        editText = findViewById(R.id.et_q2);
        checkBox = findViewById(R.id.checkbox_q3_ans);
        checkBox1 = findViewById(R.id.checkbox_q3_ans2);
        checkBox2 = findViewById(R.id.checkbox_q3_ans_wrong2);
        button = findViewById(R.id.confirm);
    }
}