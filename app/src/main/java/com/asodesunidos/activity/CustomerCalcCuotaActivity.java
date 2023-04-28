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
import com.asodesunidos.entity.Loan;

public class CustomerCalcCuotaActivity extends SuperActivity {


    // Spinners
    String[] tiposPrestamo = {"Hipotecario", "Educación", "Personal", "Viajes"};

    String[] plazosPrestamo = {"3 años", "5 años", "10 años"};

    Spinner tiposPrestamoSpinner;
    Spinner plazosPrestamoSpinner;

    //Buttons

    Button calcularBtn;

    // Texview


    TextView cuotaCalculadaTv;
    TextView montoPrestarTv;


    int periodo;

    float montoTotal;

    float porcentaje;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_calc_cuota);


        tiposPrestamoSpinner = (Spinner) findViewById(R.id.tiposSpinnerCuota);

        plazosPrestamoSpinner = (Spinner) findViewById(R.id.plazosSpinnerCuota);

        ArrayAdapter<String> adapterTipos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tiposPrestamo);

        ArrayAdapter<String> adapterPlazos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, plazosPrestamo);

        tiposPrestamoSpinner.setAdapter(adapterTipos);
        plazosPrestamoSpinner.setAdapter(adapterPlazos);


        calcularBtn = (Button) findViewById(R.id.btnCalcularCuota);

        // Texview

        cuotaCalculadaTv = (TextView) findViewById(R.id.cuotaCalculada);
        montoPrestarTv = (TextView) findViewById(R.id.montoDeseadoCuota);


    }




    @SuppressLint("DefaultLocale")
    public void calcularCuota(View view){
        if(validarCalcular()){
            float montoPrestamo = Float.parseFloat(montoPrestarTv.getText().toString());
            float interesMensual = interesMensualCalc();
            float cuota = 0;
            int numeroCuotas = numeroCuotasCalc(view);

            cuota = (float) (montoPrestamo * (interesMensual / (1 - Math.pow(1 + interesMensual, -numeroCuotas))));

            String stringdouble= Float.toString(cuota);

            cuotaCalculadaTv.setText(String.format("La cuota es de: \n%s", stringdouble));

            montoTotal = cuota * numeroCuotas;
        }
    }


    private int numeroCuotasCalc(View view){
        String opcSpinner = plazosPrestamoSpinner.getSelectedItem().toString();
        int cuotas = 0;
        switch (opcSpinner){
            case "3 años":
                cuotas = 12 * 3;
                periodo = 3;
                break;
            case "5 años":
                cuotas = 12 * 5;
                periodo = 5;
                break;
            case "10 años":
                cuotas = 12 * 10;
                periodo = 10;
                break;
        }
        return cuotas;
    }

    private float interesMensualCalc(){
        String opcSpinner = tiposPrestamoSpinner.getSelectedItem().toString();
        float interes = 0;
        switch (opcSpinner){
            case "Hipotecario":
                interes = (float) ( 0.075 / 12);
                porcentaje = (float) 0.075;
                break;
            case "Educación":
                interes = (float) ( 0.008 / 12);
                porcentaje = (float) 0.008;
                break;
            case "Personal":
                interes = (float) ( 0.010 / 12);
                porcentaje = (float) 0.010;
                break;
            case "Viajes":
                interes = (float) (0.012 / 12);
                porcentaje = (float) 0.012;
                break;
        }
        return interes;
    }

    private boolean validarCalcular(){

        if(montoPrestarTv.getText().toString().isEmpty()) {
            montoPrestarTv.setError("El campo no puede estar en blanco.");
            return false;
        }
        return true;
    }

    @Override
    protected Context context() {
        return this;
    }
}