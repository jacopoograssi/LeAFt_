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

        // Collegamento al pulsante "Avanti" nel layout
        Button pulsanteAvanti = findViewById(R.id.btnGoNext);

        pulsanteAvanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent passaggioSchermata = new Intent(ObiettiviActivity.this, BeforeStartingActivity.class);

                startActivity(passaggioSchermata);
            }
        });
    }
}
