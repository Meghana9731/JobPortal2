package com.example.jobportal.Aactivities;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.jobportal.R;



public class AboutActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);



        WebView myWebView =  findViewById(R.id.webview);

        myWebView.loadUrl("file:///C:/Users/VIPIN/Downloads/about.php");


        dl = (DrawerLayout) findViewById(R.id.activity_dash);
//        DrawerLayout d1 = (DrawerLayout) findViewById(R.id.activity_dash);
//        d1.closeDrawer(GravityCompat.START);
        t = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);


        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.drawable.ic_home_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        nv = (NavigationView) findViewById(R.id.nv);


        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {

                    case R.id.nav_home:
                        Intent navHome = new Intent(getApplicationContext(), HomeActivity.class);
                        AboutActivity.this.startActivity(navHome);
                        break;

                    case R.id.nav_about:
                        Intent navLive = new Intent(getApplicationContext(), AboutActivity.class);
                        AboutActivity.this.startActivity(navLive);
                        break;

                    case R.id.nav_terms:
                        Intent navSchedule = new Intent(getApplicationContext(), TermsActivity.class);
                        AboutActivity.this.startActivity(navSchedule);
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

    }








    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

}
