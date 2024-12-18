package com.example.leaft;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ObiettiviActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obiettivi);

        Button pulsanteAvanti = findViewById(R.id.BottoneObiettiviAvanti);

        pulsanteAvanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent passaggioSchermata = new Intent(ObiettiviActivity.this, QuestionPage1.class);

                startActivity(passaggioSchermata);
            }
        });
    }
}
