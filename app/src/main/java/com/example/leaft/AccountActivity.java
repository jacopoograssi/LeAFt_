package com.example.leaft;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountActivity extends AppCompatActivity {

    private TextView accountsTextView;
    private Button backToLoginButton;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        accountsTextView = findViewById(R.id.accountsTextView);
        backToLoginButton = findViewById(R.id.backToLoginButton);

        // Inizializza il database
        database = new Database(this);

        // Recupera la lista di utenti dal database
        ArrayList<HashMap<String, String>> listaUtenti = database.getAllUsers();

        // Mostra gli utenti nella TextView
        StringBuilder visualizzaUtenti = new StringBuilder();

        if (listaUtenti.isEmpty()) {
            visualizzaUtenti.append("Nessun account registrato.");
        } else {
            for (int i = 0; i < listaUtenti.size(); i++) {
                HashMap<String, String> user = listaUtenti.get(i);
                visualizzaUtenti.append("Account ")
                        .append(i + 1)
                        .append(":\n")
                        .append("Nome: ").append(user.get("nome")).append("\n")
                        .append("Cognome: ").append(user.get("cognome")).append("\n")
                        .append("Username: ").append(user.get("username")).append("\n")
                        .append("Password: ").append(user.get("password")).append("\n")
                        .append("Genere: ").append(user.get("genere")).append("\n")
                        .append("Età: ").append(user.get("eta")).append("\n\n");
            }
        }

        accountsTextView.setText(visualizzaUtenti.toString());

        backToLoginButton.setOnClickListener(view -> {
            Intent loginIntent = new Intent(AccountActivity.this, MainActivity.class);
            startActivity(loginIntent);
            finish();
        });
    }
}
