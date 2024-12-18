package com.example.leaft;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText, nameEditText, surnameEditText;
    private Spinner ageSpinner, genderSpinner;
    private Button registerButton, viewAccountsButton;
    private Database databaseHelper;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Collegamenti agli elementi UI
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.cognomeEditText);
        ageSpinner = findViewById(R.id.ageSpinner);
        genderSpinner = findViewById(R.id.genderSpinner);
        registerButton = findViewById(R.id.registerButton);
        viewAccountsButton = findViewById(R.id.viewAccountsButton);

        // Inizializzazione del database
        databaseHelper = new Database(this);

        // Listener per il pulsante di registrazione
        registerButton.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String name = nameEditText.getText().toString().trim();
            String surname = surnameEditText.getText().toString().trim();
            String ageString = ageSpinner.getSelectedItem().toString();
            String gender = genderSpinner.getSelectedItem().toString();

            // Validazione dei campi
            if (username.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty() ||
                    ageString.equals("Seleziona età") || gender.equals("Seleziona sesso")) {
                Toast.makeText(this, "Per favore completa tutti i campi", Toast.LENGTH_SHORT).show();
                return;
            }

            int age = Integer.parseInt(ageString);

            // Aggiungi utente al database
            databaseHelper.addUser(username, password, name, surname, gender, age);
            Toast.makeText(this, "Registrazione completata!", Toast.LENGTH_SHORT).show();

            // Vai alla schermata di login
            Intent loginIntent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(loginIntent);
            finish();
        });

        // Listener per il pulsante "Tutti gli account"
        viewAccountsButton.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, AccountActivity.class);
            startActivity(intent);
        });
    }
}
