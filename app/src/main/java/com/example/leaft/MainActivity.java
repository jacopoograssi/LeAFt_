package com.example.leaft;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private Database databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Riferimenti agli elementi della UI
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        TextView registratiTextView = findViewById(R.id.registrati);

        databaseHelper = new Database(this); // Inizializza il DatabaseHelper

        // Listener per il pulsante di login
        loginButton.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Inserisci nome utente e password", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isValid = databaseHelper.checkUserCredentials(username, password);
            if (isValid) {
                Toast.makeText(this, "Accesso effettuato con successo!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, ObiettiviActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Nome utente o password errati", Toast.LENGTH_SHORT).show();
            }
        });

        registratiTextView.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
