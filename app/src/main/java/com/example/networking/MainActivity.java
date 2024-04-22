package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "HTTPS_URL_TO_JSON_DATA_CHANGE_THIS_URL";
    private final String JSON_FILE = "mountains.json";

    private RecyclerViewAdapter adapter;

   // private Gson = gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonFile(this, this).execute(JSON_FILE); //Hämtar en lokal JSON textfil
        new JsonTask(this).execute(JSON_URL); //Hämtar en JSON textfil från en URL
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
    }

}
