package com.example.leaft;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountActivity extends AppCompatActivity {

    private TextView accountsTextView;
    private Database databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        // Collegamento alla TextView
        accountsTextView = findViewById(R.id.accountsTextView);

        // Inizializza il database
        databaseHelper = new Database(this);

        // Recupera la lista di utenti dal database
        ArrayList<HashMap<String, String>> userList = databaseHelper.getAllUsers();

        // Mostra gli utenti nella TextView
        StringBuilder userDisplay = new StringBuilder();

        if (userList.isEmpty()) {
            userDisplay.append("Nessun account registrato.");
        } else {
            for (int i = 0; i < userList.size(); i++) {
                HashMap<String, String> user = userList.get(i);
                userDisplay.append("Account ")
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

        accountsTextView.setText(userDisplay.toString());
    }
}
