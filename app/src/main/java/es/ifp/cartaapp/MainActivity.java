package es.ifp.cartaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected Intent nextAct;
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

/*        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url ="http://192.168.1.133/App2/read.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);*/

        platos.add("Tortilla de Patatas");
        platos.add("Patatas Bravas");
        platos.add("Cerveza");
        platos.add("Coca Cola");
        platos.add("Fanta de Naranja");
        platos.add("Torrijas");


        adaptador = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, platos);

        listView.setAdapter(adaptador);;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Item "+ platos.get(position) +" seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

        btnAddPlate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextAct = new Intent(MainActivity.this, CrearActivity.class);
                startActivity(nextAct);
            }
        });

    }
}