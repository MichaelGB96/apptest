package es.ifp.cartaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected Button btnAddPlate;
    protected ListView listView;
    protected ArrayList<String> platos;
    protected ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view_main);
        btnAddPlate = findViewById(R.id.btnAddPlate);

        platos = new ArrayList<String>();

        platos.add("TORTILLA DE PATATAS");
        platos.add("PATATAS BRAVAS");
        platos.add("CERVEZA");

        adaptador = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, platos);

        listView.setAdapter(adaptador);

        btnAddPlate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //codigo
            }
        });

    }
}