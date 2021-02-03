package com.example.jobportal.Aactivities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jobportal.Model.ApiInterface;
import com.example.jobportal.R;

import java.util.HashMap;
import java.util.Map;

public class Traders extends AppCompatActivity {

    EditText company_name, nature_business, address, mob_no, land_no, email, no_of_vac, job_type, time, salary;
    ProgressDialog progressDialog;
    Button submit;
    ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitment);
        company_name = findViewById(R.id.editEmail);
        nature_business = findViewById(R.id.editPass);
        address = findViewById(R.id.address);
        mob_no = findViewById(R.id.editbod);
        land_no = findViewById(R.id.edite);
        email = findViewById(R.id.editg);
        no_of_vac = findViewById(R.id.editCat);
        job_type = findViewById(R.id.editee);
        time = findViewById(R.id.ed);
        salary = findViewById(R.id.edis);
        submit = findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();

            }
        });
    }

    private void insertData() {

        final String company = company_name.getText().toString().trim();
        final String busnss = nature_business.getText().toString().trim();
        final String adds = address.getText().toString().trim();
        final String mob = mob_no.getText().toString().trim();
        final String land = land_no.getText().toString().trim();
        final String ema = email.getText().toString().trim();
        final String nov = no_of_vac.getText().toString().trim();
        final String jt = job_type.getText().toString().trim();
        final String tm = time.getText().toString().trim();
        final String sar = salary.getText().toString().trim();
        final ProgressDialog progressDialog = new ProgressDialog(this);


        progressDialog.setMessage("Loading....");


        if (company.isEmpty()) {
            company_name.setError("Enter Company Name");
        }
        else if (busnss.isEmpty()){
            nature_business.setError("Enter Buisness");
        }
        else if (adds.isEmpty()) {
            address.setError("Enter Address");
        }
        else if (mob.isEmpty()) {
            mob_no.setError("Enter Mobile No.");
        }
        else if (land.isEmpty()) {
            land_no.setError("Enter LandLine no.");
        }
        else if (ema.isEmpty()) {
            email.setError("Enter Email");
        }
        else if (nov.isEmpty()) {
            no_of_vac.setError("Enter Numbers of vacancy");
        }
        else if (jt.isEmpty()) {
            job_type.setError("Enter job type");
        }
        else if (tm.isEmpty()) {
            time.setError("Enter time type");
        }
        else if (sar.isEmpty()) {
            salary.setError("Enter salary");

            return;
        }
        else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.43.79/jobportal/v1/traders.php",

                    new Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(Traders.this, "Successfully Done", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                        }


                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(Traders.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
//
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> params = new HashMap<String, String>();

                    params.put("company_name", company);
                    params.put("nature_business", busnss);
                    params.put("address", adds);
                    params.put("mob_no", mob);
                    params.put("land_no", land);
                    params.put("email", ema);
                    params.put("no_of_vac", nov);
                    params.put("job_type", jt);
                    params.put("time", tm);
                    params.put("salary", sar);


                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(Traders.this);
            requestQueue.add(request);
        }
    }
}

