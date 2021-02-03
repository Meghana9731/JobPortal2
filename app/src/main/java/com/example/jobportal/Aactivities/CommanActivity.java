package com.example.jobportal.Aactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
//
//import com.example.jobportal.Adapter.RecyAdapter;
import com.example.jobportal.R;
import com.jackandphantom.circularimageview.CircleImage;

import java.util.ArrayList;

public class CommanActivity extends AppCompatActivity {
   private Button btn;
//    private ArrayList<Recy> mExampleList;
//    private RecyclerView mRecyclerView;
//    private RecyAdapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comman);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), VaccancyFormActivity.class);
                startActivity(intent);

            }


        });

        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), ApplicationActivity.class);
                startActivity(intent);
            }


        });
    }
}
