package com.example.jobportal.Aactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.jobportal.R;
import com.jackandphantom.circularimageview.CircleImage;

public class RecruitmentVacActivity extends AppCompatActivity {
    RelativeLayout manufacture,other,traders,service,consultanc;
    private CircleImage iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitment_vac);

        manufacture = findViewById(R.id.manu);
        other = findViewById(R.id.other);
        traders = findViewById(R.id.trader);
        service = findViewById(R.id.service);
        consultanc = findViewById(R.id.consultancy);

        iv = (CircleImage) findViewById(R.id.circleImage1);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), RecruitmentActivity.class);
                startActivity(intent);

            }


        });

        iv = (CircleImage) findViewById(R.id.circleImage2);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Traders.class);
                startActivity(intent);
            }


        });

        iv = (CircleImage) findViewById(R.id.circleImage3);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Others.class);
                startActivity(intent);
            }


        });
        iv = (CircleImage) findViewById(R.id.circleImage4);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Service.class);
                startActivity(intent);
            }


        });
        iv = (CircleImage) findViewById(R.id.circleImage5);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),Consultancy.class);
                startActivity(intent);
            }


        });
    }
}
