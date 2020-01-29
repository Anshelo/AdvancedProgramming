package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.projectapp.Interface.Transport;
import com.example.projectapp.Model.Product;
import com.example.projectapp.Model.TableDynamic;
import com.example.projectapp.Model.Zone;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetZones extends AppCompatActivity {

    private TextView mJsonTxtView;
    TableDynamic tabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_zones);
        tabla = new TableDynamic(this, (TableLayout)findViewById(R.id.tableZones));
        String [] cabeza = {"Codigo","Nombre"};
        tabla.agregarCabezera(cabeza);
        getZones();
    }
    public TableDynamic getZones(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://freigthtransport.ddns.net:1024/FreightTransport/project/zone/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Transport apiTransport = retrofit.create(Transport.class);
        Call<List<Zone>> call = apiTransport.getZones();

        call.enqueue(new Callback<List<Zone>>() {
            @Override
            public void onResponse(Call<List<Zone>> call, Response<List<Zone>> response) {

                List<Zone> zoneList = response.body();

                for(Zone zone:zoneList){
                    ArrayList<String> elements = new ArrayList<String>();
                    elements.add(zone.getCodigozona());
                    elements.add(zone.getNombrezona());
                    tabla.agregarFilaTabla(elements);
                }

            }
            @Override
            public void onFailure(Call<List<Zone>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());

            }
        });

        return tabla;
    }
}
