package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {
    Button btnProduct;
    Button btnCarrier;
    Button btnZone;
    Button btnClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        btnProduct = (Button)findViewById(R.id.btnProducts);
        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objIntent = new Intent(MenuPrincipal.this,MenuProducts.class);
                MenuPrincipal.this.startActivity(objIntent);
            }
        });
        btnCarrier = (Button)findViewById(R.id.btnCarriers);
        btnCarrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objIntent = new Intent(MenuPrincipal.this,MenuCarrier.class);
                MenuPrincipal.this.startActivity(objIntent);
            }
        });
        btnZone = (Button)findViewById(R.id.btnZones);
        btnZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objIntent = new Intent(MenuPrincipal.this,MenuZones.class);
                MenuPrincipal.this.startActivity(objIntent);
            }
        });
        btnClient = (Button)findViewById(R.id.btnClients);
        btnClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objIntent = new Intent(MenuPrincipal.this,MenuClients.class);
                MenuPrincipal.this.startActivity(objIntent);
            }
        });
    }
}
