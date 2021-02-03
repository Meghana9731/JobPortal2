package com.example.jobportal.Aactivities;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.jobportal.Adapter.MyAdapter;
import com.example.jobportal.R;
import com.jackandphantom.circularimageview.CircleImage;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private TextView tx;
    private CircleImage iv;
    private static ViewPager mPager;
    private CircleIndicator indicator;
    private static int currentPage = 0;
    private static final Integer[] XMEN = {R.drawable.man, R.drawable.meeting, R.drawable.ppt};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        iv = (CircleImage) findViewById(R.id.circleImage);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), VacancyActivity.class);
                startActivity(intent);

            }


        });

        iv = (CircleImage) findViewById(R.id.circleImage1);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), ApplicationActivity.class);
                startActivity(intent);
            }


        });

        iv = (CircleImage) findViewById(R.id.circleImage2);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), RecruitmentVacActivity.class);
                startActivity(intent);
            }


        });

        dl = (DrawerLayout) findViewById(R.id.activity_dash);
//        DrawerLayout d1 = (DrawerLayout) findViewById(R.id.activity_dash);
//        d1.closeDrawer(GravityCompat.START);
        t = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);


        dl.addDrawerListener(t);
        t.syncState();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.drawable.ic_home_black_24dp);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        nv = (NavigationView) findViewById(R.id.nv);


        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {

                    case R.id.nav_home:
                        Intent navHome = new Intent(getApplicationContext(), HomeActivity.class);
                        HomeActivity.this.startActivity(navHome);
                        break;

                    case R.id.nav_about:
                        Intent navLive = new Intent(getApplicationContext(), AboutActivity.class);
                        HomeActivity.this.startActivity(navLive);
                        break;

                    case R.id.nav_terms:
                        Intent navSchedule = new Intent(getApplicationContext(), TermsActivity.class);
                        HomeActivity.this.startActivity(navSchedule);
                        break;
                    case R.id.nav_language:
                        Intent navLang = new Intent(getApplicationContext(), LanguageActivity.class);
                        HomeActivity.this.startActivity(navLang);
                        break;


                    default:
                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_dash);
                        //  drawer.closeDrawer(GravityCompat.START);
                        return true;
                }
                //

                return true;

            }
        });
        init();
    }


    private void init() {
        for (int i = 0; i < XMEN.length; i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(HomeActivity.this, XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 9500, 10000);
    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

}
