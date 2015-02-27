package org.usfirst.frc.team4131.scoutingapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReviewActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        for(String file : fileList()){
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            String number = file.substring(0, file.indexOf('.'));
            Log.d("Survey Review", "Adding button for team #" + number);
            Button button = new Button(this);
            button.setText("Team " + number);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(ReviewActivity.this, TeamReviewActivity.class);
                    String teamNumber = ((Button) view).getText().toString().substring(5);//Cut off "Team " prefix
                    intent.putExtra(MainActivity.TEAM_NUMBER, teamNumber);
                    BufferedReader in = null;
                    try {
                        in = new BufferedReader(new InputStreamReader(openFileInput(teamNumber + ".survey")));
                        intent.putExtra(MainActivity.TEAM_NAME, in.readLine());
                        intent.putExtra(MainActivity.ROBOT_NAME, in.readLine());
                        intent.putExtra(MainActivity.TOTE_IN, in.readLine());
                        intent.putExtra(MainActivity.TOTE_OUT, in.readLine());
                        intent.putExtra(MainActivity.APPROACH, in.readLine());
                        intent.putExtra(MainActivity.COOPERTITION, in.readLine());
                        intent.putExtra(MainActivity.AUTONOMOUS, in.readLine());
                        intent.putExtra(MainActivity.UPSIDE_DOWN, in.readLine());
                        intent.putExtra(MainActivity.RECYCLE_IN, in.readLine());
                        intent.putExtra(MainActivity.RECYCLE_EX, in.readLine());
                        intent.putExtra(MainActivity.EXTRA, in.readLine());
                    } catch (IOException ex) {
                        Log.e("Survey review", "Error while reading file " + teamNumber + ".survey", ex);
                    } finally {
                        if (in != null) try {
                            in.close();
                        } catch (IOException ex) {
                            Log.e("Survey review", "Error while closing file " + teamNumber + ".survey", ex);
                        }
                    }
                    startActivity(intent);
                }
            });
            row.addView(button, new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1F));//width, height, layout weight
            Button delete = new Button(this);
            delete.setText("Delete");
            delete.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    String fileName = ((TextView)((LinearLayout) view.getParent()).getChildAt(0)).getText().toString().substring(5).concat(".survey");
                    deleteFile(fileName);
                    startActivity(new Intent(getIntent()));//Restart screen to remove the file from the list
                }
            });
            row.addView(delete, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            layout.addView(row);
        }
        layout.addView(new View(this), new LinearLayout.LayoutParams(1, 0, 1F));
        Button back = new Button(this);
        back.setText(R.string.restart);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){startActivity(new Intent(ReviewActivity.this, MainActivity.class));}
        });
        layout.addView(back);
        setContentView(layout);
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
