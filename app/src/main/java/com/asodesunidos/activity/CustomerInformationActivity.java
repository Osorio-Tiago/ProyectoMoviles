package com.asodesunidos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.asodesunidos.R;
import com.asodesunidos.entity.Customer;

import java.util.Calendar;

public class CustomerInformationActivity extends SuperActivity {


    TextView dateEdt;
    TextView name;
    TextView idCard;
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
                datePickerDialog.show();
            }
        });


    }


    public void consultarInformacion(View view){

        Customer customer = database().getCustomerDAO().findCustomer(1);
    }

    @Override
    protected Context context() {
    return null;
    }
}