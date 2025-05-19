package com.example.android.quizapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textView = findViewById(R.id.score);
        Bundle result = getIntent().getExtras();
        textView.setText(String.valueOf(result.getInt("result")));
        Toast.makeText(this, result.getInt("result") + R.string.out_of_5, Toast.LENGTH_SHORT).show();
    }
}