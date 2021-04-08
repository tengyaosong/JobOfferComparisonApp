package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class EnterJobActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText currentJobTitle;
    private EditText currentJobCompany;
    private EditText currentCostOfLiving;
    private EditText currentCity;
    private EditText currentYearlySalary;

    private EditText currentYearlyBonus;
    private Spinner currentRemoteDays;
    private Spinner currentState;
    private EditText currentRetirementBenefits;
    private EditText currentLeaveTime;
    private String[] dayDropDown;

    private List<String> statesList;

    ApplicationContextProvider context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_form);

        context = (ApplicationContextProvider) getApplicationContext();

        currentJobTitle = (EditText) findViewById(R.id.currentJobTitle);
        currentJobCompany = (EditText) findViewById(R.id.currentJobCompany);
        currentCostOfLiving = (EditText) findViewById(R.id.currentCostOfLiving);
        currentCity = (EditText) findViewById(R.id.currentCity);
        currentYearlySalary = (EditText) findViewById(R.id.currentYearlySalary);

        currentYearlyBonus = (EditText) findViewById(R.id.currentYearlyBonus);
        currentRemoteDays = (Spinner) findViewById(R.id.currentRemoteDays);
        currentState = (Spinner) findViewById(R.id.currentState);
        currentRetirementBenefits = (EditText) findViewById(R.id.currentRetirementBenefits);
        currentLeaveTime = (EditText) findViewById(R.id.currentLeaveTime);

        // Spinner click listener
        currentRemoteDays.setOnItemSelectedListener(this);
        currentState.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        statesList = context.getStatesList();
        dayDropDown = context.getRemoteDaysDropDown();

        // Creating adapter for spinner
        ArrayAdapter<String> remoteDayDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dayDropDown);
        ArrayAdapter<String> stateDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, statesList);

        // Drop down layout style - list view with radio button
        remoteDayDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        currentRemoteDays.setAdapter(remoteDayDataAdapter);
        currentState.setAdapter(stateDataAdapter);

        // populate job details for edit
        if(context.getCurrentJob() != null){
            Job currentJob = context.getCurrentJob();

            currentJobTitle.setText(currentJob.getTitle());
            currentJobCompany.setText(currentJob.getCompany());
            currentCostOfLiving.setText(String.valueOf(currentJob.getCostOfLiving()));

            // populate location
            Location currentJobLocation = currentJob.getLocation();

            String state = currentJobLocation.getState();
            int statePosition = statesList.indexOf(state); // TODO: check for null, indexoutofrange
            currentState.setSelection(statePosition);

            String city = currentJobLocation.getCity();
            currentCity.setText(city);

            currentYearlySalary.setText(String.valueOf(currentJob.getYearlySalary()));
            currentYearlyBonus.setText(String.valueOf(currentJob.getYearlyBonus()));
            currentRemoteDays.setSelection(currentJob.getWorkRemote()); // TODO: checking?
            currentRetirementBenefits.setText(String.valueOf(currentJob.getRetirementBenefits()));
            currentLeaveTime.setText(String.valueOf(currentJob.getLeave()));
        }


        // cancel and return to menu discarding data
        Button cancel = (Button) findViewById(R.id.CancelCurrentJob);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainMenu.class);
                startActivityForResult(myIntent, 0);
            }
        });

        // save and return to menu
        Button save = (Button) findViewById(R.id.SaveCurrentJob);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainMenu.class);

                String titleInput = currentJobTitle.getText().toString();
                String companyInput = currentJobCompany.getText().toString();
                String cityInput = currentCity.getText().toString();
                String stateInput = stateDataAdapter.getItem(currentState.getSelectedItemPosition());
                int workRemoteInput = Integer.parseInt(remoteDayDataAdapter.getItem(currentRemoteDays.getSelectedItemPosition()));
                String costInput = currentCostOfLiving.getText().toString();
                String leaveInput = currentLeaveTime.getText().toString();
                String salaryInput = currentYearlySalary.getText().toString();
                String bonusInput = currentYearlyBonus.getText().toString();
                String retireInput = currentRetirementBenefits.getText().toString();

                if (isValidString(titleInput) && isValidString(companyInput) &&
                        isValidString(cityInput) && isValidString(costInput) &&
                        isValidString(leaveInput) && isValidString(salaryInput) &&
                        isValidString(bonusInput) && isValidString(retireInput)) {


                    Job currentJob = new Job(currentJobTitle.getText().toString(),
                            currentJobCompany.getText().toString(),
                            new Location(cityInput, stateInput),
                            Integer.parseInt(currentCostOfLiving.getText().toString()), workRemoteInput,
                            Double.parseDouble(currentYearlySalary.getText().toString()),
                            Double.parseDouble(currentYearlyBonus.getText().toString()),
                            Double.parseDouble(currentRetirementBenefits.getText().toString()),
                            Integer.parseInt(currentLeaveTime.getText().toString()), true);

                    // enter job
                    context.setCurrentJob(currentJob);

                    startActivityForResult(myIntent, 0);
                }

                if (!isValidString(titleInput)) {
                    currentJobTitle.setError("Input cannot be empty");
                }

                if (!isValidString(companyInput)) {
                    currentJobCompany.setError("Input cannot be empty");
                }

                if (!isValidString(cityInput)) {
                    currentCity.setError("Input cannot be empty");
                }

                if (!isValidString(costInput)) {
                    currentCostOfLiving.setError("Input cannot be empty");
                }

                if (!isValidString(leaveInput)) {
                    currentLeaveTime.setError("Input cannot be empty");
                }

                if (!isValidString(salaryInput)) {
                    currentYearlySalary.setError("Input cannot be empty");
                }

                if (!isValidString(bonusInput)) {
                    currentYearlyBonus.setError("Input cannot be empty");
                }

                if (!isValidString(retireInput)) {
                    currentRetirementBenefits.setError("Input cannot be empty");
                }
            }

        });
    }

    private boolean isValidString(String text) {
        return !text.isEmpty() && text != null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
