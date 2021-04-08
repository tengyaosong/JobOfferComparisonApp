package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TwoJobCompActivity extends AppCompatActivity {

    private JobOffer jobA;
    private JobOffer jobB;
    private ApplicationContextProvider context;

    TextView jobATitle;
    TextView jobBTitle;

    TextView jobACompany;
    TextView jobBCompany;

    TextView jobALocation;
    TextView jobBLocation;

    TextView jobACostOfLiving;
    TextView jobBCostOfLiving;

    TextView jobAYearlySalary;
    TextView jobBYearlySalary;

    TextView jobAYearlyBonus;
    TextView jobBYearlyBonus;

    TextView jobARemoteDays;
    TextView jobBRemoteDays;

    TextView jobARetirementBenefits;
    TextView jobBRetirementBenefits;

    TextView jobALeaveTime;
    TextView jobBLeaveTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_two);

        context = (ApplicationContextProvider) getApplicationContext();
        context.setCompareList(new ArrayList<>());

        jobATitle = (TextView)findViewById(R.id.jobATitle);
        jobBTitle = (TextView)findViewById(R.id.jobBTitle);

        jobACompany = (TextView)findViewById(R.id.jobACompany);
        jobBCompany = (TextView)findViewById(R.id.jobBCompany);

        jobALocation = (TextView)findViewById(R.id.jobALocation);
        jobBLocation = (TextView)findViewById(R.id.jobBLocation);

        jobACostOfLiving = (TextView)findViewById(R.id.jobACostOfLiving);
        jobBCostOfLiving = (TextView)findViewById(R.id.jobBCostOfLiving);

        jobAYearlySalary = (TextView)findViewById(R.id.jobAYearlySalary);
        jobBYearlySalary = (TextView)findViewById(R.id.jobBYearlySalary);

        jobAYearlyBonus = (TextView)findViewById(R.id.jobAYearlyBonus);
        jobBYearlyBonus = (TextView)findViewById(R.id.jobBYearlyBonus);

        jobARemoteDays = (TextView)findViewById(R.id.jobARemoteDays);
        jobBRemoteDays = (TextView)findViewById(R.id.jobBRemoteDays);

        jobARetirementBenefits = (TextView)findViewById(R.id.jobARetirementBenefits);
        jobBRetirementBenefits = (TextView)findViewById(R.id.jobBRetirementBenefts);

        jobALeaveTime = (TextView)findViewById(R.id.jobALeaveTime);
        jobBLeaveTime = (TextView)findViewById(R.id.jobBLeaveTime);

        jobA = context.getCompareJobA();
        jobB = context.getCompareJobB();

        if(jobA == null || jobB == null){
            System.out.print("One or more jobs null");
        }
        else{
            jobATitle.setText(jobA.getTitle());
            jobACompany.setText(jobA.getCompany());
            jobALocation.setText(jobA.getLocation().toString());
            jobACostOfLiving.setText(String.valueOf(jobA.getCostOfLiving()));
            jobAYearlySalary.setText(String.valueOf(jobA.getYearlySalary()));
            jobAYearlyBonus.setText(String.valueOf(jobA.getYearlyBonus()));
            jobARemoteDays.setText(String.valueOf(jobA.getWorkRemote()));
            jobARetirementBenefits.setText(String.valueOf(jobA.getRetirementBenefits()));
            jobALeaveTime.setText(String.valueOf(jobA.getLeave()));

            jobBTitle.setText(jobB.getTitle());
            jobBCompany.setText(jobB.getCompany());
            jobBLocation.setText(jobB.getLocation().toString());
            jobBCostOfLiving.setText(String.valueOf(jobB.getCostOfLiving()));
            jobBYearlySalary.setText(String.valueOf(jobB.getYearlySalary()));
            jobBYearlyBonus.setText(String.valueOf(jobB.getYearlyBonus()));
            jobBRemoteDays.setText(String.valueOf(jobB.getWorkRemote()));
            jobBRetirementBenefits.setText(String.valueOf(jobB.getRetirementBenefits()));
            jobBLeaveTime.setText(String.valueOf(jobB.getLeave()));

        }

        // return to main menu
        Button returnToMainMenuButton = (Button) findViewById(R.id.returnToMainButton);
        returnToMainMenuButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainMenu.class);
                startActivityForResult(myIntent, 0);
            }
        });

        // setup new comparison
        Button newComparisonButton = (Button) findViewById(R.id.newComparisonButton);
        newComparisonButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), CompareJobsActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });













    }



}
