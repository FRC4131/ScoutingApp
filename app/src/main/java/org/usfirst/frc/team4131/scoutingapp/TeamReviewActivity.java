package org.usfirst.frc.team4131.scoutingapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class TeamReviewActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_team_review);
        ((TextView)findViewById(R.id.team_number)).setText(intent.getStringExtra(MainActivity.TEAM_NUMBER));
        ((TextView)findViewById(R.id.team_name)).setText(intent.getStringExtra(MainActivity.TEAM_NAME));
        ((TextView)findViewById(R.id.robot_name)).setText(intent.getStringExtra(MainActivity.ROBOT_NAME));
        ((TextView)findViewById(R.id.tote_in)).setText(intent.getStringExtra(MainActivity.TOTE_IN));
        ((TextView)findViewById(R.id.tote_out)).setText(intent.getStringExtra(MainActivity.TOTE_OUT));
        ((TextView)findViewById(R.id.approach)).setText(intent.getStringExtra(MainActivity.APPROACH));
        ((TextView)findViewById(R.id.coopertition)).setText(intent.getStringExtra(MainActivity.COOPERTITION));
        ((TextView)findViewById(R.id.autonomous)).setText(intent.getStringExtra(MainActivity.AUTONOMOUS));
        ((TextView)findViewById(R.id.upside_down)).setText(intent.getStringExtra(MainActivity.UPSIDE_DOWN));
        ((TextView)findViewById(R.id.recycle_in)).setText(intent.getStringExtra(MainActivity.RECYCLE_IN));
        ((TextView)findViewById(R.id.recycle_ex)).setText(intent.getStringExtra(MainActivity.RECYCLE_EX));
        ((TextView)findViewById(R.id.extra)).setText(intent.getStringExtra(MainActivity.EXTRA));
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
    public void back(View view){startActivity(new Intent(this, ReviewActivity.class));}
}
