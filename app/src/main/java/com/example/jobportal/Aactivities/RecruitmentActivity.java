package com.example.jobportal.Aactivities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jobportal.Model.ApiClient;
import com.example.jobportal.Model.ApiInterface;
import com.example.jobportal.Model.Recruitmentgetset;
import com.example.jobportal.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class RecruitmentActivity extends AppCompatActivity {

    EditText company_name, nature_of_business, address, contact, telephone_number, email, total_vacancy, job_type, job_time, salary;
    ProgressDialog progressDialog;
    Button submit;
    ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitment);
        company_name = findViewById(R.id.editEmail);
        nature_of_business = findViewById(R.id.editPass);
        address = findViewById(R.id.address);
        contact = findViewById(R.id.editbod);
        telephone_number = findViewById(R.id.edite);
        email = findViewById(R.id.editg);
        total_vacancy = findViewById(R.id.editCat);
        job_type = findViewById(R.id.editee);
        job_time = findViewById(R.id.ed);
        salary = findViewById(R.id.edis);
        submit = findViewById(R.id.button);

        job_type.setOnClickListener(new View.OnClickListener() {

                                        @Override
                                        public void onClick(View v) {
                                            AlertDialog.Builder builder = new AlertDialog.Builder(RecruitmentActivity.this);
                                            final String[] subcatArray = new String[]{"Full-time", "Half-time"};
                                            final boolean[] checkedSubArray = new boolean[]{
                                                    false, false, false, false, false
                                            };
                                            final List<String> subcatList = Arrays.asList(subcatArray);
                                            builder.setTitle("Choose your choice");
//                builder.setIcon(R.drawable.ic_format_list_bulleted_black_24dp);
                                            builder.setMultiChoiceItems(subcatArray, checkedSubArray, new DialogInterface.OnMultiChoiceClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                                    checkedSubArray[which] = isChecked;
                                                    String currentItem = subcatList.get(which);
                                                    Toast.makeText(RecruitmentActivity.this, currentItem + "" + isChecked, Toast.LENGTH_SHORT);

                                                }
                                            });
                                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
//                        sub.setText("your choice");

                                                    for (int i = 0; i < checkedSubArray.length; i++) {
                                                        boolean checked = checkedSubArray[i];
                                                        if (checked) {
                                                            job_type.setText(job_type.getText() + subcatList.get(i) + ",");
                                                        }
                                                    }

                                                }
                                            });

                                            builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                }
                                            });
                                            AlertDialog dialog = builder.create();
                                            dialog.show();

                                        }
                                    });



            submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();

            }
        });
    }

    private void insertData() {

        final String company = company_name.getText().toString().trim();
        final String busnss = nature_of_business.getText().toString().trim();
        final String adds = address.getText().toString().trim();
        final String mob = contact.getText().toString().trim();
        final String land = telephone_number.getText().toString().trim();
        final String ema = email.getText().toString().trim();
        final String nov = total_vacancy.getText().toString().trim();
        final String jt = job_type.getText().toString().trim();
        final String tm = job_time.getText().toString().trim();
        final String sar = salary.getText().toString().trim();
        final ProgressDialog progressDialog = new ProgressDialog(this);


        progressDialog.setMessage("Loading....");


        if (company.isEmpty()) {
                    company_name.setError("Enter Company Name");
                }
                    else if (busnss.isEmpty()){
                        nature_of_business.setError("Enter Buisness");
                    }
                    else if (adds.isEmpty()) {
                        address.setError("Enter Address");
                    }
                    else if (mob.isEmpty()) {
                        contact.setError("Enter Mobile No.");
                    }
                    else if (land.isEmpty()) {
                        telephone_number.setError("Enter LandLine no.");
                    }
                    else if (ema.isEmpty()) {
                        email.setError("Enter Email");
                    }
                    else if (nov.isEmpty()) {
                        total_vacancy.setError("Enter Numbers of vacancy");
                    }
                    else if (jt.isEmpty()) {
                        job_type.setError("Enter job type");
                    }
                    else if (tm.isEmpty()) {
                        job_time.setError("Enter time type");
                    }
                    else if (sar.isEmpty()) {
                        salary.setError("Enter salary");

            return;
        }
                    else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.43.79/jobportal/v1/recruitment.php",

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(RecruitmentActivity.this, "Successfully Done", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                        }


                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(RecruitmentActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
//
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> params = new HashMap<String, String>();

                    params.put("company_name", company);
                    params.put("nature_of_business", busnss);
                    params.put("address", adds);
                    params.put("contact", mob);
                    params.put("telephone_number", land);
                    params.put("email", ema);
                    params.put("total_vacancy", nov);
                    params.put("job_type", jt);
                    params.put("job_time", tm);
                    params.put("salary", sar);


                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(RecruitmentActivity.this);
            requestQueue.add(request);
        }
    }
}


















//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Loading.....");
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_editor, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.save:
//                String companyName = company_name.getText().toString().trim();
//                String natBusnes = nature_buisness.getText().toString().trim();
//                String addRess = address.getText().toString().trim();
//                String mobno = mob_no.getText().toString().trim();
//                String landno = land_no.getText().toString().trim();
//                String eMail = email.getText().toString().trim();
//                String noofvac = no_of_vac.getText().toString().trim();
//                String jobtype = job_type.getText().toString().trim();
//                String tIme = time.getText().toString().trim();
//                String sAlary = salary.getText().toString().trim();
//                if (companyName.isEmpty()) {
//                    company_name.setError("Enter Company Name");
//                }
//                    else if (natBusnes.isEmpty()){
//                        nature_buisness.setError("Enter Buisness");
//                    }
//                    else if (companyName.isEmpty()) {
//                    company_name.setError("Enter Company Name");
//                    }
//                    else if (addRess.isEmpty()) {
//                    address.setError("Enter Address");
//                    }
//                    else if (mobno.isEmpty()) {
//                    mob_no.setError("Enter Mobile No.");
//                    }
//                    else if (landno.isEmpty()) {
//                        land_no.setError("Enter LandLine no.");
//                    }
//                    else if (eMail.isEmpty()) {
//                        email.setError("Enter Email");
//                    }
//                    else if (noofvac.isEmpty()) {
//                        no_of_vac.setError("Enter Numbers of vacancy");
//                    }
//                    else if (jobtype.isEmpty()) {
//                        job_type.setError("Enter job type");
//                    }
//                    else if (tIme.isEmpty()) {
//                        time.setError("Enter time type");
//                    }
//                    else if (sAlary.isEmpty()) {
//                        salary.setError("Enter salary");
//                    }
//                    else {
//                        saveData(companyName, natBusnes, addRess , mobno , landno, eMail, noofvac, jobtype, tIme, sAlary);
//                }
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//
//        }
//    }
//
//    private void saveData(final String company_name,final String nature_business,final String address,final String mob_no,final String land_no,final String email,final String no_of_vac,final String job_type,final String time,final String salary) {
//        progressDialog.show();
//        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
//        Call<Recruitmentgetset> call = apiInterface.saveData(company_name,nature_business,address,mob_no,land_no,email,no_of_vac,job_type,time,salary);
//
//        call.enqueue(new Callback<Recruitmentgetset>() {
//            @Override
//            public void onResponse(@NonNull Call<Recruitmentgetset> call,@NonNull Response<Recruitmentgetset> response) {
//                progressDialog.dismiss();
//                if(response.isSuccessful() && response.body() != null) {
//                    Boolean success = response.body().getSuccess();
//                    if(success) {
//                        Toast.makeText(RecruitmentActivity.this,
//                                response.body().getMessage(),
//                                Toast.LENGTH_SHORT).show();
//                        finish();
//                    }
//                        else {
//                            Toast.makeText(RecruitmentActivity.this,
//                                    response.body().getMessage(),
//                                    Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//
//
//            @Override
//            public void onFailure(@NonNull Call<Recruitmentgetset> call, @NonNull Throwable t) {
//                progressDialog.dismiss();
//                Toast.makeText(RecruitmentActivity.this,
//                        t.getLocalizedMessage(),
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//    }
//}
