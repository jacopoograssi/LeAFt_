package com.example.leaft;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Database extends SQLiteOpenHelper {

    // Nome e versione del database
    private static final String DATABASE_NAME = "leaft_db";
    private static final int DATABASE_VERSION = 1;

    // Nomi delle tabelle e delle colonne
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SURNAME = "surname";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_AGE = "age";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crea la tabella degli utenti
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SURNAME + " TEXT, " +
                COLUMN_GENDER + " TEXT, " +
                COLUMN_AGE + " INTEGER)";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Se la versione del database cambia, elimina la tabella esistente e ricreala
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Metodo per aggiungere un nuovo utente
    public void addUser(String username, String password, String name, String surname, String gender, int age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SURNAME, surname);
        values.put(COLUMN_GENDER, gender);
        values.put(COLUMN_AGE, age);

        // Inserisci il nuovo utente
        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    // Metodo per ottenere tutti gli utenti registrati
    public ArrayList<HashMap<String, String>> getAllUsers() {
        ArrayList<HashMap<String, String>> usersList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query per ottenere tutti gli utenti
        String query = "SELECT * FROM " + TABLE_USERS;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                // Crea un HashMap per ogni utente
                HashMap<String, String> user = new HashMap<>();
                user.put("nome", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)));
                user.put("cognome", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SURNAME)));
                user.put("username", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USERNAME)));
                user.put("password", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD)));
                user.put("genere", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GENDER)));
                user.put("eta", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AGE)));

                // Aggiungi l'utente alla lista
                usersList.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return usersList;
    }

    // Metodo per fare il login e verificare le credenziali
    public boolean checkUserCredentials(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{username, password});

        boolean userExists = cursor.moveToFirst();
        cursor.close();
        db.close();
        return userExists;
    }
}
