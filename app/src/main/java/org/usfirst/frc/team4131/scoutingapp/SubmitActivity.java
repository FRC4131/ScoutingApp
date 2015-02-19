package org.usfirst.frc.team4131.scoutingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.io.FileOutputStream;
import java.io.IOException;

public class SubmitActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if(intent==null) Log.e("Intent", "INTENT==NULL");
        int teamNumber = 0;
        try{
            teamNumber = Integer.parseInt(intent.getStringExtra(MainActivity.TEAM_NUMBER));
        }catch(NumberFormatException ex){
            Log.e("SURVEY", "Invalid team number", ex);
        }catch(NullPointerException ex){
            Log.e("SURVEY", "Null intent", ex);
        }
        String teamName = intent.getStringExtra(MainActivity.TEAM_NAME);
        String robotName = intent.getStringExtra(MainActivity.ROBOT_NAME);
        String text = "Team " + teamNumber + " (" + teamName + ")";
        if(robotName!=null && robotName.length()>0) text = text.concat(": " + robotName);
        Log.w("Collected survey data", text);
        FileOutputStream out = null;
        try{
            out = openFileOutput(teamNumber+".survey", Context.MODE_PRIVATE);
            out.write(teamName.concat("\r\n").getBytes());
            out.write(robotName.concat("\r\n").getBytes());
        }catch(IOException ex){
            Log.e("Writing survey results", "Error while writing file", ex);
        }finally{
            if(out!=null) try{
                out.close();
            }catch(IOException ex){Log.e("Writing survey results", "Error while closing file", ex);}
        }
        setContentView(R.layout.activity_submit);
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
    public void restart(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}
