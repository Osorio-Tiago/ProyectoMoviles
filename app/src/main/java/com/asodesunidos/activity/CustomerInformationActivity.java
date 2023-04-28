package com.asodesunidos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.asodesunidos.R;
import com.asodesunidos.entity.Customer;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomerInformationActivity extends SuperActivity {


    int userId;

    TextView dateEdt;
    TextView name;
    TextView idCard; //No modificar
    TextView phone;
    TextView salary;
    TextView civilState;
    TextView addressTxt;

    Button updateCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_information);


        name = findViewById(R.id.nameTxt);
        idCard = findViewById(R.id.idCardTxt);
        phone = findViewById(R.id.phoneTxt);
        salary = findViewById(R.id.salaryTxt);
        civilState = findViewById(R.id.civilStateTxt);
        addressTxt = findViewById(R.id.addressTxt);

        updateCustomer = findViewById(R.id.buttonUpdateCustomer);
        // on below line we are initializing our variables.
        dateEdt = findViewById(R.id.dateTxt);

        // on below line we are adding click listener
        // for our pick date button
        dateEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        CustomerInformationActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our edit text.
                                dateEdt.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();
            }
        });


        userId = getIntent().getIntExtra("idCustomer",0);
        consultarInformacion();
    }


    @SuppressLint("DefaultLocale")
    public void consultarInformacion(){

        Customer customer = database().getCustomerDAO().findCustomer(userId);
        if(customer != null) {
            idCard.setText(customer.getIdentificationCard());
            name.setText(customer.getName());
            salary.setText(String.format("%.0f", customer.getSalary()));
            phone.setText(customer.getPhoneNumber());
            dateEdt.setText(customer.getBirthdate());
            civilState.setText(customer.getCivilStatus());
            addressTxt.setText(customer.getDirection());

        }
    }

    public void updateCustomer(View view){
        if(validarCampos()) {
            Customer cusUpdate = new Customer();

            cusUpdate.setIdentificationCard(idCard.getText().toString());
            cusUpdate.setName(name.getText().toString());
            cusUpdate.setSalary(Double.parseDouble(salary.getText().toString()));
            cusUpdate.setPhoneNumber(phone.getText().toString());
            cusUpdate.setBirthdate(dateEdt.getText().toString());
            cusUpdate.setCivilStatus(civilState.getText().toString());
            cusUpdate.setDirection(addressTxt.getText().toString());
            cusUpdate.setUid(userId);

            database().getCustomerDAO().update(cusUpdate);

            showToast("Se actualizó la información de manera exitosa");
            consultarInformacion();
        }
    }

    private boolean validarCampos() {
        boolean flag = true;

        if(name.getText().toString().isEmpty()){
            flag = false;
            name.setError("El campo no puede estar vacío");
        }
        if(salary.getText().toString().isEmpty()){
            flag = false;
            salary.setError("El campo no puede estar vacío");
        }
        if( phone.getText().toString().isEmpty()){
            flag = false;
            phone.setError("El campo no puede estar vacío");
        }
        if( dateEdt.getText().toString().isEmpty()){
            flag = false;
            dateEdt.setError("El campo no puede estar vacío");
        }
        if( civilState.getText().toString().isEmpty()){
            flag = false;
            civilState.setError("El campo no puede estar vacío");
        }
        if( addressTxt.getText().toString().isEmpty()){
            flag = false;
            addressTxt.setError("El campo no puede estar vacío");
        }
        return flag;
    }

    @Override
    protected Context context() {
    return this;
    }
}