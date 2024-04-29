package com.example.networking;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";

    private RecyclerViewAdapter adapter;

    private ArrayList<Mountain> listOfMountains = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new RecyclerViewAdapter(this, listOfMountains, new RecyclerViewAdapter.OnClickListener() {

            @Override
            public void onClick(Mountain mountain) {
                Toast.makeText(MainActivity.this, mountain.toString(), Toast.LENGTH_SHORT).show();
                Log.d("Mountain1" , mountain.toString());
            }

        });

        new JsonTask(this).execute(JSON_URL); //Hämtar en JSON textfil från en URL

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);


    }

    @Override
    public void onPostExecute(String json) {

        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        listOfMountains = gson.fromJson(json, type);
        Log.d("Mountains", "" + listOfMountains.size());

        adapter.update(listOfMountains);  //Updaterar listan med mountains
        adapter.notifyDataSetChanged();

        for (Mountain berg : listOfMountains){
            Log.d("Mountain" , berg.toString());
        }
        Log.d("Mountains", json);

    }

}
