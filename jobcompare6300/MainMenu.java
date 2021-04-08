package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {

    private Button entryCompareJobsBut;
    private Button entryComparisonSetBut;
    private Button entryJobOffersBut;
    private Button entryCurrentJobButton;

    private  ApplicationContextProvider context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = (ApplicationContextProvider)getApplicationContext();
        context.setCompareList(new ArrayList<>());

        //Initialize all components
        entryCurrentJobButton = (Button) findViewById(R.id.entryCurrentJob);
        entryCompareJobsBut = (Button) findViewById(R.id.entryCompareJobs);
        entryComparisonSetBut = (Button) findViewById(R.id.entryComparisonSet);
        entryJobOffersBut = (Button) findViewById(R.id.entryJobOffers);

        entryCurrentJobButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                openJobForm();
            }

        });

        entryJobOffersBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               openJobOfferForm();
            }

        });

        entryCompareJobsBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                openCompareJobList();
            }

        });

        entryComparisonSetBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                openSettingsForm();
            }

        });

    }

    public void openJobForm(){
        Intent intent = new Intent(this, EnterJobActivity.class);
        startActivity(intent);
    }

    public void openSettingsForm(){
        Intent intent = new Intent(this, EnterWeightsActivity.class);
        startActivity(intent);
    }

    public void openCompareJobList(){

        // check 2+ jobs
        context.getJobList();

        int numberOfJobs = context.numberOfJobOffers();

        if(numberOfJobs < 2){
            Toast.makeText(getBaseContext(),
                    "Please enter at least two jobs to compare (including Current job).",
                    Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(this, CompareJobsActivity.class);
            startActivity(intent);
        }
    }

    public void openJobOfferForm(){
        Intent intent = new Intent(this, EnterJobOffersActivity.class);
        startActivity(intent);
    }


}