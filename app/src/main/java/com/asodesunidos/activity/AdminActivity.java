package com.asodesunidos.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import com.asodesunidos.R;

public class AdminActivity extends SuperActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        init();
    }

    @Override
    protected Context context() { return AdminActivity.this; }

    private void init() {
        findViewById(R.id.addCustomerBtn).setOnClickListener(view -> changeView(CustomerActivity.class));
        findViewById(R.id.logout).setOnClickListener(view -> changeView(Login.class));
    }


}