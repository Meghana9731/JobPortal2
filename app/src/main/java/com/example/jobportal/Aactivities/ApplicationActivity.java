package com.example.jobportal.Aactivities;

import android.app.Application;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jobportal.R;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class ApplicationActivity extends AppCompatActivity implements AlertDialogRadio.AlertPositiveListener {
    int position = 0;

    EditText full_name,company_name,mob_number,address,bod,education,gender,sub_categories,experience,expect_salary;
    DatePickerDialog picker;
    Button submit;
    RadioGroup radioGroup;
    RadioButton radio;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        gender =  findViewById(R.id.editg);
        full_name = findViewById(R.id.editName);
        company_name = findViewById(R.id.editEmail);
        mob_number = findViewById(R.id.editPass);
        address = findViewById(R.id.address);
        education = findViewById(R.id.edite);
        experience = findViewById(R.id.editee);
        expect_salary = findViewById(R.id.edis);
        bod = findViewById(R.id.editbod);
        sub_categories = findViewById(R.id.editCat);
        submit = findViewById(R.id.button);




        sub_categories.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(ApplicationActivity.this);
                final String[] subcatArray=new String[]{"Manufacturing","Traders","Service","Consultancy","Others"};
                final boolean[] checkedSubArray=new boolean[]{
                   false,false,false,false,false
                };
                final List<String> subcatList= Arrays.asList(subcatArray);
                builder.setTitle("Choose your choice");
//                builder.setIcon(R.drawable.ic_format_list_bulleted_black_24dp);
                builder.setMultiChoiceItems(subcatArray, checkedSubArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedSubArray[which]=isChecked;
                        String currentItem=subcatList.get(which);
                        Toast.makeText(ApplicationActivity.this,currentItem +"" + isChecked,Toast.LENGTH_SHORT);

                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        sub.setText("your choice");

                        for (int i = 0; i<checkedSubArray.length; i++){
                            boolean checked = checkedSubArray[i];
                            if (checked) {
                                sub_categories.setText(sub_categories.getText() + subcatList.get(i)+",");
                            }
                        }

                    }
                });

                builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();




//                // TODO Auto-generated method stub
//                CatDia dilaog = new CatDia(ApplicationActivity.this);
//
//                dilaog.show();
            }
        });


        bod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(ApplicationActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                bod.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });



        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Getting the fragment manager */
                FragmentManager manager = getFragmentManager();

                /** Instantiating the DialogFragment class */
                AlertDialogRadio alert = new AlertDialogRadio();

                /** Creating a bundle object to store the selected item's index */
                Bundle b = new Bundle();

                /** Storing the selected item's index in the bundle object */
                b.putInt("position", position);

                /** Setting the bundle object to the dialog fragment object */
                alert.setArguments(b);

                /** Creating the dialog fragment object, which will in turn open the alert dialog window */
                alert.show(manager, "alert_dialog_radio");
            }
        };

        /** Getting the reference of the button from the main layout */

        /** Setting a button click listener for the choose button */
        gender.setOnClickListener(listener);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void insertData() {

        final String company = company_name.getText().toString().trim();
        final String mob = mob_number.getText().toString().trim();
        final String adds = address.getText().toString().trim();
        final String dob = bod.getText().toString().trim();
        final String edu = education.getText().toString().trim();
        final String gen = gender.getText().toString().trim();
        final String cat = sub_categories.getText().toString().trim();
        final String exp = experience.getText().toString().trim();
        final String salary = expect_salary.getText().toString().trim();
        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Loading....");

        if (company.isEmpty()) {
            company_name.setError("Enter Company Name");
        }
        else if (mob.isEmpty()){
            mob_number.setError("Enter mob number");
        }
        else if (adds.isEmpty()) {
            address.setError("Enter Address");
        }
        else if (dob.isEmpty()) {
            bod.setError("Enter dob");
        }
        else if (edu.isEmpty()) {
            education.setError("Enter your education");
        }
        else if (gen.isEmpty()) {
            gender.setError("Enter gender");
        }
        else if (cat.isEmpty()) {
            sub_categories.setError("Enter sub categories");
        }
        else if (exp.isEmpty()) {
            experience.setError("Enter your Experience");
        }
        else if (salary.isEmpty()) {
            expect_salary.setError("Enter expected salary");

            return;
        }
        else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.43.79/jobportal/v1/jobapplication.php",

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(ApplicationActivity.this, "Successfully Done", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                        }


                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(ApplicationActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> params = new HashMap<String, String>();

                    params.put("company_name", company);
                    params.put("mob_number", mob);
                    params.put("address", adds);
                    params.put("bod", dob);
                    params.put("education", edu);
                    params.put("gender", gen);
                    params.put("sub_categories", cat);
                    params.put("experience", exp);
                    params.put("expected_salary", salary);


                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(ApplicationActivity.this);
            requestQueue.add(request);
        }
    }



    @Override
    public void onPositiveClick(int position) {
        this.position = position;

        /** Getting the reference of the textview from the main layout */
        /** Setting the selected android version in the textview */
        gender.setText( Dia.code[this.position]);
    }
}


