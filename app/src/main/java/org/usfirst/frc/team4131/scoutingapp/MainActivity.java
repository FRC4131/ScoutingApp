package org.usfirst.frc.team4131.scoutingapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {
    public static final String TEAM_NUMBER = "org.usfirst.frc.team4131.scoutingapp.TEAM_NUMBER",
            TEAM_NAME = "org.usfirst.frc.team4131.scoutingapp.TEAM_NAME",
            ROBOT_NAME = "org.usfirst.frc.team4131.scoutingapp.ROBOT_NAME",
            TOTE_IN = "org.usfirst.frc.team4131.scoutingapp.TOTE_IN",
            TOTE_OUT = "org.usfirst.frc.team4131.scoutingapp.TOTE_OUT",
            APPROACH = "org.usfirst.frc.team4131.scoutingapp.APPROACH",
            TRANSPORT = "org.usfirst.frc.team4131.scoutingapp.TRANSPORT",
            COOPERTITION = "org.usfirst.frc.team4131.scoutingapp.COOPERTITION",
            AUTONOMOUS = "org.usfirst.frc.team4131.scoutingapp.AUTONOMOUS",
            UPSIDE_DOWN = "org.usfirst.frc.team4131.scoutingapp.UPSIDE_DOWN",
            RECYCLE_IN = "org.usfirst.frc.team4131.scoutingapp.RECYCLE_IN",
            RECYCLE_EX = "org.usfirst.frc.team4131.scoutingapp.RECYCLE_EX",
            EXTRA = "org.usfirst.frc.team4131.scoutingapp.EXTRA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void startSurvey(View view) {
        startActivity(new Intent(this, SurveyActivity.class));
    }
    public void startReview(View view) {
        startActivity(new Intent(this, ReviewActivity.class));
    }
}
