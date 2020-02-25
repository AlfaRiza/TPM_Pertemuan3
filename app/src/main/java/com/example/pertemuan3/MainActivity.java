package com.example.pertemuan3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPahlawan;
    private ArrayList<modelPahlawan> listPahlawan = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPahlawan = findViewById(R.id.rvPahlawan);
        rvPahlawan.setHasFixedSize(true);
        listPahlawan.addAll(dataPahlawan.getListData());

        showRecyclerList();
    }

    private void showRecyclerList(){
        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        adapterPahlawan adapterPahlawan = new adapterPahlawan(this);
        adapterPahlawan.setModelPahlawans(listPahlawan);
        rvPahlawan.setAdapter(adapterPahlawan);
        adapterPahlawan.setOnItemClickCallback(new adapterPahlawan.OnItemClickCallback() {
            @Override
            public void onItemClicked(modelPahlawan data) {
                Intent intent = new Intent(MainActivity.this, detail_pahlawan.class);
                intent.putExtra(detail_pahlawan.EXTRA_DATA,data);
                startActivity(intent);
            }
        });
    }
}
