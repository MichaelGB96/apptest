package es.ifp.cartaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VerProductoActivity extends AppCompatActivity {

    protected TextView titulo, tipoProd, precioProd;
    protected Button btnVolver;
    protected ImageView imageView;
    protected Intent nextAct;
    protected Bundle bundle;
    protected Package aPackage;
    protected int idProd;
    protected String strTipoProd, strPrecioProd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_producto);

        titulo = findViewById(R.id.prodName_ver_producto);
        tipoProd = findViewById(R.id.lbl_tipo_ver_producto);
        precioProd = findViewById(R.id.lbl_precio_ver_producto);

        imageView = findViewById(R.id.imageView);

        btnVolver = findViewById(R.id.btn_back_ver_producto);

        nextAct = this.getIntent();
        bundle = nextAct.getExtras();
        idProd = bundle.getInt("id");

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        // String url ="http://192.168.1.133/App2/read.php"; //localhost XAMPP
        String url = "https://end-stopped-buy.000webhostapp.com/read.php?id="+idProd; // 000webhost

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String name = "";
                            String type = "";
                            String price = "";
                            JSONObject jsonObject = new JSONObject(response);
                            name = jsonObject.getString("nombre");
                            type = jsonObject.getString("tipo");
                            price = jsonObject.getString("precio");

                            titulo.setText(name);
                            tipoProd.setText(type);
                            precioProd.setText(price+"€");
                            String uri = "@drawable/barista";
                            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                            imageView.setImageResource(imageResource);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VerProductoActivity.this, "El producto no existe", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                paramV.put("id",""+idProd);
                return paramV;
            }
        };;

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextAct = new Intent(VerProductoActivity.this, MainActivity.class);
                startActivity(nextAct);
            }
        });

    }
}