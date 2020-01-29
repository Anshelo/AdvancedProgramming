package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.projectapp.Interface.Transport;
import com.example.projectapp.Model.Carrier;
import com.example.projectapp.Model.Client;
import com.example.projectapp.Model.TableDynamic;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetClients extends AppCompatActivity {

    private TextView mJsonTxtView;
    TableDynamic tabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_clients);
        tabla = new TableDynamic(this, (TableLayout)findViewById(R.id.tableClients));
        String [] cabeza = {"CI","Name","RUC","Phone","Mobile","Email","Address"};
        tabla.agregarCabezera(cabeza);
        getClients();
    }

    public TableDynamic getClients(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://freigthtransport.ddns.net:1024/FreightTransport/project/client/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Transport apiTransport = retrofit.create(Transport.class);
        Call<List<Client>> call = apiTransport.getClients();

        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {

                List<Client> clientList = response.body();

                for(Client client: clientList){
                    ArrayList<String> elements = new ArrayList<String>();
                    elements.add(client.getCiClient());
                    elements.add(client.getNameClient());
                    elements.add(client.getRucClient());
                    elements.add(client.getPhoneClient());
                    elements.add(client.getMobileClient());
                    elements.add(client.getEmailClient());
                    elements.add(client.getAddressClient());
                    tabla.agregarFilaTabla(elements);
                }

            }
            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());

            }
        });

        return tabla;
    }
}
