package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.projectapp.Interface.Transport;
import com.example.projectapp.Model.Carrier;
import com.example.projectapp.Model.Product;
import com.example.projectapp.Model.TableDynamic;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetProducts extends AppCompatActivity {
    private TextView mJsonTxtView;
    TableDynamic tabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_products);
        tabla = new TableDynamic(this, (TableLayout)findViewById(R.id.tableProducts));
        String [] cabeza = {"ID","Nombre","Descripcion","Peso","Sensibilidad","ValorUnitario"};
        tabla.agregarCabezera(cabeza);
        getProducts();
    }
    public TableDynamic getProducts(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://freigthtransport.ddns.net:1024/FreightTransport/project/product/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Transport apiTransport = retrofit.create(Transport.class);
        Call<List<Product>> call = apiTransport.getProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                List<Product> productList = response.body();

                for(Product product:productList){
                    ArrayList<String> elements = new ArrayList<String>();
                    elements.add(product.getProductCode());
                    elements.add(product.getProductName());
                    elements.add(product.getDescription());
                    elements.add(Float.toString(product.getWeight()));
                    elements.add(product.getSensibility());
                    elements.add(Float.toString(product.getUnitValue()));
                    tabla.agregarFilaTabla(elements);
                }

            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());

            }
        });

        return tabla;
    }
}
