package es.ifp.cartaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CrearActivity extends AppCompatActivity {

    protected Intent nextAct;
    protected Button btnVolver, btnCrear;
    protected EditText boxName, boxType, boxPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        boxName = findViewById(R.id.box_name_crear);
        boxType = findViewById(R.id.box_tipo_crear);
        boxPrice = findViewById(R.id.box_precio_crear);

        btnCrear = findViewById(R.id.btnCreate);
        btnVolver = findViewById(R.id.btnBack);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextAct = new Intent(CrearActivity.this, MainActivity.class);
                startActivity(nextAct);
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = boxName.getText().toString();
                String tipo = boxType.getText().toString();
                String precio = boxPrice.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                //String url = "http://192.168.1.133/App2/create.php"; //localhost XAMPP
                String url = "https://end-stopped-buy.000webhostapp.com/create.php"; // 000webhost

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("Success")){
                            Toast.makeText(CrearActivity.this, "Plato añadido", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(CrearActivity.this, response, Toast.LENGTH_SHORT).show();
                            System.out.println("ñññ: "+response);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("name",nombre);
                        paramV.put("type",tipo);
                        paramV.put("price",precio);
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                nextAct = new Intent(CrearActivity.this, MainActivity.class);
                startActivity(nextAct);
            }
        });


    }
}