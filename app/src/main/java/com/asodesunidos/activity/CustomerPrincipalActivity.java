package com.asodesunidos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.asodesunidos.R;
import com.asodesunidos.entity.Customer;

public class CustomerPrincipalActivity extends SuperActivity {

    int userId;
    String userName;
    TextView welcome;

    //Buttons

    Button personalInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_principal);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        welcome = (TextView) findViewById(R.id.welcomeCustomer);

        userId = getIntent().getIntExtra("idCustomer",0);

        userName = getIntent().getStringExtra("customerName");
        welcome.setText("Bienvenido " + userName);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        personalInfo = (Button) findViewById(R.id.personalInformation);
        findViewById(R.id.calc).setOnClickListener(view -> changeView(CustomerCalcCuotaActivity.class));

        findViewById(R.id.viewLoans).setOnClickListener(view -> changeView(ViewLoansCustomerActivity.class));
    }


    public void personalInformationCustomer(View view){
        Intent i = new Intent(this, CustomerInformationActivity.class);
        i.putExtra("idCustomer", userId);
        startActivity(i);
    }

    public void logout(View view){
        finish();
    }
    @Override
    protected Context context() { return this;
    }
}