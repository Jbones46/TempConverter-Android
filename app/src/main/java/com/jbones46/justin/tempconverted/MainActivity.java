package com.jbones46.justin.tempconverted;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.BatchUpdateException;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {


    private EditText tempEditText;
    private Button celButton;
    private Button fButton;
    private TextView showTempTextView;

    DecimalFormat round = new DecimalFormat("0.0");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    tempEditText = (EditText) findViewById(R.id.editText);
    celButton = (Button) findViewById(R.id.celsiusButtonId);
    fButton = (Button) findViewById(R.id.f_buttonId);
    showTempTextView = (TextView) findViewById(R.id.showResultTextView);


    celButton.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            //call convertToCelsius()
            String editTextVal = tempEditText.getText().toString();
            if (editTextVal.isEmpty()) {

                Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();


            } else {

                //we are good

                double intEditId = Double.parseDouble(editTextVal);



                double convertedVal = convertToCelsius(intEditId);
                String result = String.valueOf(round.format(convertedVal));

                showTempTextView.setText(result + " C");

            }

        }



    });

    fButton.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View v) {


            String editTextVal = tempEditText.getText().toString();
            if (editTextVal.isEmpty()) {

                Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();


            } else {

                //we are good

                double intEditId = Double.parseDouble(editTextVal);



                double convertedVal = convertToFar(intEditId);
                String result = String.valueOf(round.format(convertedVal));

                showTempTextView.setText(result + " F");





            }


        }
    });





        };







    public double convertToCelsius(double farVal){

        double resultCelsius;
        resultCelsius = (farVal - 32) *5/9;


        return resultCelsius;

    }

    public double convertToFar(double celVal){

        double resultFar;
        resultFar = (celVal * 9/5) + 32;

        return resultFar;

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







}
