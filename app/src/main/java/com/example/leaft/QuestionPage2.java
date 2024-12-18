package com.example.leaft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionPage2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionpage2);

        RadioGroup radioGroup = findViewById(R.id.radioGroupObiettivi);
        Button avantiButton = findViewById(R.id.BottoneObiettiviAvanti);

        avantiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuestionPage2.this, "Seleziona un'opzione per continuare", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(QuestionPage2.this, Experience.class)); // Sostituisci con la tua Activity successiva
                }
            }
        });
    }
}
