package com.example.jobportal.Aactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jobportal.R;
import com.jackandphantom.circularimageview.CircleImage;

public class VacancyActivity extends AppCompatActivity {
    private CircleImage iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancy);
        iv = (CircleImage) findViewById(R.id.circleImage1);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), CommanActivity.class);
                startActivity(intent);

            }


        });

        iv = (CircleImage) findViewById(R.id.circleImage2);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), CommanActivity.class);
                startActivity(intent);
            }


        });

        iv = (CircleImage) findViewById(R.id.circleImage3);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), CommanActivity.class);
                startActivity(intent);
            }


        });
        iv = (CircleImage) findViewById(R.id.circleImage4);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), CommanActivity.class);
                startActivity(intent);
            }


        });
        iv = (CircleImage) findViewById(R.id.circleImage5);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), CommanActivity.class);
                startActivity(intent);
            }


        });
    }
}
