package com.asodesunidos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.asodesunidos.R;
import com.asodesunidos.entity.Customer;

public class CustomerPrincipalActivity extends SuperActivity {

    int userId;
    String userName;
    TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_principal);

        welcome = (TextView) findViewById(R.id.welcomeCustomer);

        userId = getIntent().getIntExtra("idCustomer",0);

        userName = getIntent().getStringExtra("customerName");
        welcome.setText("Bienvenido " + userName);
    }

    public void logout(View view){
        finish();
    }

    @Override
    protected Context context() {
        return null;
    }
}