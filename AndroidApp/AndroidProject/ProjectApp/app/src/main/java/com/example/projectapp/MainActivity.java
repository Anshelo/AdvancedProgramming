package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.projectapp.Interface.Transport;
import com.example.projectapp.Model.Carrier;
import com.example.projectapp.Model.TableDynamic;

import java.util.ArrayList;
import java.util.List;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView mJsonTxtView;
    TableDynamic tabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabla = new TableDynamic(this, (TableLayout)findViewById(R.id.tabla));
        tabla.agregarCabezera(R.array.cabecera_tabla);
        getCarriers();
    }

    public TableDynamic getCarriers(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://freigthtransport.ddns.net:1024/FreightTransport/project/carrier/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Transport apiTransport = retrofit.create(Transport.class);
        Call<List<Carrier>> call = apiTransport.getCarriers();

        call.enqueue(new Callback<List<Carrier>>() {
            @Override
            public void onResponse(Call<List<Carrier>> call, Response<List<Carrier>> response) {

                List<Carrier> carrierList = response.body();

                for(Carrier carrier: carrierList){
                    ArrayList<String> elements = new ArrayList<String>();
                    elements.add(carrier.getIdCarrier());
                    elements.add(carrier.getCi());
                    elements.add(carrier.getName());
                    elements.add(carrier.getBirthDate());
                    elements.add(carrier.getPhone());
                    elements.add(carrier.getMobile());
                    elements.add(carrier.getEmail());
                    elements.add(carrier.getAddress());
                    elements.add(carrier.getTruckPlate());
                    elements.add(carrier.getTruckType());
                    tabla.agregarFilaTabla(elements);
                }

            }
            @Override
            public void onFailure(Call<List<Carrier>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());

            }
        });

        return tabla;
    }
}
