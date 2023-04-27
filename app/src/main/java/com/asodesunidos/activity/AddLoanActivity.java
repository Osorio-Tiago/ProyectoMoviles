package com.asodesunidos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.asodesunidos.R;
import com.asodesunidos.entity.Customer;

import java.lang.reflect.Array;
import java.util.List;

public class AddLoanActivity extends SuperActivity {



    // Spinners
    String[] tiposPrestamo = {"Hipotecario", "Educación", "Personal", "Viajes"};

    String[] plazosPrestamo = {"3 años", "5 años", "10 años"};

    Spinner tiposPrestamoSpinner;
    Spinner plazosPrestamoSpinner;

    //Buttons

    Button calcularBtn;
    Button buscarCedulaBtn;
    Button agregarPrestamoBtn;


    // Texview

    TextView cedulaTv;
    TextView nombreClienteTv;
    TextView salarioClienteTv;
    TextView salarioMaximoTv;
    TextView cuotaCalculadaTv;


    double salarioMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loan);

        tiposPrestamoSpinner = (Spinner) findViewById(R.id.tiposSpinner);

        plazosPrestamoSpinner = (Spinner) findViewById(R.id.plazosSpinner);

        ArrayAdapter<String> adapterTipos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tiposPrestamo);

        ArrayAdapter<String> adapterPlazos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, plazosPrestamo);

        tiposPrestamoSpinner.setAdapter(adapterTipos);
        plazosPrestamoSpinner.setAdapter(adapterPlazos);


        calcularBtn = (Button) findViewById(R.id.btnCalcular);
         buscarCedulaBtn = (Button) findViewById(R.id.searchIdCard);
         agregarPrestamoBtn = (Button) findViewById(R.id.btnAgregarPrestamo);


        // Texview

         cedulaTv = (TextView) findViewById(R.id.idCard);
         nombreClienteTv = (TextView) findViewById(R.id.customerName);
         salarioClienteTv = (TextView) findViewById(R.id.customerSalary);
         salarioMaximoTv = (TextView) findViewById(R.id.maxSalary);
         cuotaCalculadaTv = (TextView) findViewById(R.id.cuotaCalculada);
    }


    @SuppressLint("DefaultLocale")
    public void searchUser(View view){
        Customer customer = null;

        List<Customer> customers = database().getCustomerDAO().findAll();

        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getIdentificationCard().equals(cedulaTv.getText().toString()))
               customer = customers.get(i);
        }

        if(customer != null) {
            nombreClienteTv.setText(customer.getName());
            salarioClienteTv.setText(String.format("%s\n%s", getResources().getString(R.string.salario), String.format("%.0f", customer.getSalary())));
           // salarioClienteTv.getResources().getString(R.string.salario, customer.getSalary());
            salarioMax = calcSalarioMaximo(customer.getSalary());
            salarioMaximoTv.setText(String.format("Salario máximo: \n%s", String.format("%.02f",salarioMax)));
        }else{
            showToast("El cliente consultado no existe");
        }
    }
    private double calcSalarioMaximo(double salario){
        return salario * 0.45;
    }

    @Override
    protected Context context() {
        return this;
    }
}