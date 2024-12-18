package com.example.leaft;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionPage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionpage1);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        View.OnClickListener ProssimaPagina = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionPage1.this, QuestionPage2.class);
                startActivity(intent);
            }
        };

        button1.setOnClickListener(ProssimaPagina);
        button2.setOnClickListener(ProssimaPagina);
        button3.setOnClickListener(ProssimaPagina);
        button4.setOnClickListener(ProssimaPagina);
    }
}
