package com.example.leaft;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ExperienceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        LinearLayout bannerBeginner = findViewById(R.id.bannerBeginner);
        LinearLayout bannerIntermediate = findViewById(R.id.bannerIntermediate);
        LinearLayout bannerExpert = findViewById(R.id.bannerExpert);

        bannerBeginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExperienceActivity.this, BeginnerWorkoutActivity.class));
            }
        });

        bannerIntermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExperienceActivity.this, EndQuestionActivity.class));
            }
        });

        bannerExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExperienceActivity.this, EndQuestionActivity.class));
            }
        });
    }
}
