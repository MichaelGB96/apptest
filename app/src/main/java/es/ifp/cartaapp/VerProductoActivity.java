package es.ifp.cartaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class VerProductoActivity extends AppCompatActivity {

    protected TextView titulo, tipoProd, precioProd;
    protected Button btnVolver;
    protected ImageView imageView;
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



    }
}