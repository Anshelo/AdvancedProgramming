package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuProducts extends AppCompatActivity {
    Button btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_products);
        btnListar = (Button)findViewById(R.id.btnList);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objIntent = new Intent(MenuProducts.this,GetProducts.class);
                MenuProducts.this.startActivity(objIntent);
            }
        });
    }
}
