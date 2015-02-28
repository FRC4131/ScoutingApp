package org.usfirst.frc.team4131.scoutingapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SurveyActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
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
    public void submit(View view){
        Intent intent = new Intent(this, SubmitActivity.class);
        intent.putExtra(MainActivity.TEAM_NUMBER, ((EditText)findViewById(R.id.team_number)).getText().toString());
        intent.putExtra(MainActivity.TEAM_NAME, ((EditText)findViewById(R.id.team_name)).getText().toString());
        intent.putExtra(MainActivity.ROBOT_NAME, ((EditText)findViewById(R.id.robot_name)).getText().toString());
        intent.putExtra(MainActivity.TOTE_IN, ((EditText)findViewById(R.id.tote_in)).getText().toString());
        intent.putExtra(MainActivity.TOTE_OUT, ((EditText)findViewById(R.id.tote_out)).getText().toString());
        intent.putExtra(MainActivity.APPROACH, ((EditText)findViewById(R.id.approach)).getText().toString());
        intent.putExtra(MainActivity.TRANSPORT, ((EditText)findViewById(R.id.transport)).getText().toString());
        intent.putExtra(MainActivity.STACK, ((EditText)findViewById(R.id.stack)).getText().toString());
        intent.putExtra(MainActivity.COOPERTITION, ((EditText)findViewById(R.id.coopertition)).getText().toString());
        intent.putExtra(MainActivity.AUTONOMOUS, ((EditText)findViewById(R.id.autonomous)).getText().toString());
        intent.putExtra(MainActivity.UPSIDE_DOWN, ((EditText)findViewById(R.id.upside_down)).getText().toString());
        intent.putExtra(MainActivity.RECYCLE_IN, ((EditText)findViewById(R.id.recycle_in)).getText().toString());
        intent.putExtra(MainActivity.RECYCLE_EX, ((EditText)findViewById(R.id.recycle_ex)).getText().toString());
        intent.putExtra(MainActivity.EXTRA, ((EditText)findViewById(R.id.extra)).getText().toString());
        startActivity(intent);
    }
}
