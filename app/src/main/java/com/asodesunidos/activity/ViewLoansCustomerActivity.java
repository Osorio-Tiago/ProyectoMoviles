package com.asodesunidos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.asodesunidos.R;

public class ViewLoansCustomerActivity extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_loans_customer);
    }



    @Override
    protected Context context() {
        return this;
    }
}