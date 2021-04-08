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
import android.widget.Toast;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.database.JobEntity;

public class EnterJobOffersActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText offerJobTitle;
    private EditText offerJobCompany;
    private EditText offerCostOfLiving;
    private EditText offerCity;
    private Spinner offerState;
    private EditText offerYearlySalary;

    private EditText offerYearlyBonus;
    private Spinner offerRemoteDays;
    private EditText offerRetirementBenefits;
    private EditText offerLeaveTime;

    private String[] dayDropDown; // remote days
    private List<String> statesList; // states

    private AppDatabase mDb;
    private int uid = 0;

    // Creating adapter for spinner
    ArrayAdapter<String> remoteDayDataAdapter;
    ArrayAdapter<String> stateDataAdapter;

    ApplicationContextProvider context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offers_form);

        context = (ApplicationContextProvider) getApplicationContext();
        mDb = AppDatabase.getInstance(getApplicationContext());

        offerJobTitle = (EditText) findViewById(R.id.jobTitleOffer);
        offerJobCompany = (EditText) findViewById(R.id.companyOffer);
        offerCostOfLiving = (EditText) findViewById(R.id.costLivingOffer);
        offerCity = (EditText) findViewById(R.id.cityOffer);
        offerState = (Spinner) findViewById(R.id.stateOffer);
        offerYearlySalary = (EditText) findViewById(R.id.yearlySalaryOffer);

        offerYearlyBonus = (EditText) findViewById(R.id.yearlyBonusOffer);
        offerRemoteDays = (Spinner) findViewById(R.id.teleworkDaysOffer);
        offerRetirementBenefits = (EditText) findViewById(R.id.retirementBenenfitsOffer);
        offerLeaveTime = (EditText) findViewById(R.id.leaveTimeOffer);

        // Spinner click listener
        offerRemoteDays.setOnItemSelectedListener(this);
        offerState.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        statesList = context.getStatesList();
        dayDropDown = context.getRemoteDaysDropDown();

        // Creating adapter for spinner
        remoteDayDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dayDropDown);
        stateDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, statesList);

        // Drop down layout style - list view with radio button
        remoteDayDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        offerRemoteDays.setAdapter(remoteDayDataAdapter);
        offerState.setAdapter(stateDataAdapter);

        Button cancel = (Button) findViewById(R.id.cancelOffer);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainMenu.class);
                startActivityForResult(myIntent, 0);
            }

        });

        // save and exit
        Button saveExit = (Button) findViewById(R.id.saveExitOfferButton);
        saveExit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String titleInput = offerJobTitle.getText().toString();
                String companyInput = offerJobCompany.getText().toString();
                String cityInput = offerCity.getText().toString();
                String costInput = offerCostOfLiving.getText().toString();
                String leaveInput = offerLeaveTime.getText().toString();
                String salaryInput = offerYearlySalary.getText().toString();
                String bonusInput = offerYearlyBonus.getText().toString();
                String retireInput = offerRetirementBenefits.getText().toString();
                String stateInput = stateDataAdapter.getItem(offerState.getSelectedItemPosition());
                int workRemoteInput = Integer.parseInt(remoteDayDataAdapter.getItem(offerRemoteDays.getSelectedItemPosition()));

                if (isValidString(titleInput) && isValidString(companyInput) &&
                        isValidString(cityInput) && isValidString(costInput) &&
                        isValidString(leaveInput) && isValidString(salaryInput) &&
                        isValidString(bonusInput) && isValidString(retireInput)) {

                    // save the job to the offer list
                    //saveJobOffer();
                    //DB Save
                    final JobEntity jobSpecsToSave = new JobEntity(
                            uid,
                            offerJobTitle.getText().toString(),
                            offerJobCompany.getText().toString(),
                            offerCity.getText().toString(), stateInput,
                            Integer.parseInt(offerCostOfLiving.getText().toString()), workRemoteInput,
                            Double.parseDouble(offerYearlySalary.getText().toString()),
                            Double.parseDouble(offerYearlyBonus.getText().toString()),
                            Double.parseDouble(offerRetirementBenefits.getText().toString()),
                            Integer.parseInt(offerLeaveTime.getText().toString()),1);
                            Long newJobId = mDb.appDAO().insertNewJob(jobSpecsToSave);

                    Intent myIntent = new Intent(view.getContext(), MainMenu.class);
                    startActivityForResult(myIntent, 0);
                }

                if (!isValidString(titleInput)) {
                    offerJobTitle.setError("Input cannot be empty");
                }

                if (!isValidString(companyInput)) {
                    offerJobCompany.setError("Input cannot be empty");
                }

                if (!isValidString(cityInput)) {
                    offerCity.setError("Input cannot be empty");
                }

                if (!isValidString(costInput)) {
                    offerCostOfLiving.setError("Input cannot be empty");
                }

                if (!isValidString(leaveInput)) {
                    offerLeaveTime.setError("Input cannot be empty");
                }

                if (!isValidString(salaryInput)) {
                    offerYearlySalary.setError("Input cannot be empty");
                }

                if (!isValidString(bonusInput)) {
                    offerYearlyBonus.setError("Input cannot be empty");
                }

                if (!isValidString(retireInput)) {
                    offerRetirementBenefits.setError("Input cannot be empty");
                }
            }

        });

        // save and enter new job offer
        Button saveAndNewOffer = (Button) findViewById(R.id.saveAndNewOfferButton);
        saveAndNewOffer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String titleInput = offerJobTitle.getText().toString();
                String companyInput = offerJobCompany.getText().toString();
                String cityInput = offerCity.getText().toString();

                String costInput = offerCostOfLiving.getText().toString();
                String leaveInput = offerLeaveTime.getText().toString();
                String salaryInput = offerYearlySalary.getText().toString();
                String bonusInput = offerYearlyBonus.getText().toString();
                String retireInput = offerRetirementBenefits.getText().toString();
                String stateInput = stateDataAdapter.getItem(offerState.getSelectedItemPosition());
                int workRemoteInput = Integer.parseInt(remoteDayDataAdapter.getItem(offerRemoteDays.getSelectedItemPosition()));

                if (isValidString(titleInput) && isValidString(companyInput) &&
                        isValidString(cityInput) && isValidString(costInput) &&
                        isValidString(leaveInput) && isValidString(salaryInput) &&
                        isValidString(bonusInput) && isValidString(retireInput)) {
                    // save the job to the offer list
                    //saveJobOffer();
                    //DB Save
                    final JobEntity jobSpecsToSave = new JobEntity(
                            uid,
                            offerJobTitle.getText().toString(),
                            offerJobCompany.getText().toString(),
                            offerCity.getText().toString(), stateInput,
                            Integer.parseInt(offerCostOfLiving.getText().toString()), workRemoteInput,
                            Double.parseDouble(offerYearlySalary.getText().toString()),
                            Double.parseDouble(offerYearlyBonus.getText().toString()),
                            Double.parseDouble(offerRetirementBenefits.getText().toString()),
                            Integer.parseInt(offerLeaveTime.getText().toString()),1);

                            Long newJobId = mDb.appDAO().insertNewJob(jobSpecsToSave);

                    Intent myIntent = new Intent(view.getContext(), EnterJobOffersActivity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (!isValidString(titleInput)) {
                    offerJobTitle.setError("Input cannot be empty");
                }

                if (!isValidString(companyInput)) {
                    offerJobCompany.setError("Input cannot be empty");
                }

                if (!isValidString(cityInput)) {
                    offerCity.setError("Input cannot be empty");
                }

                if (!isValidString(costInput)) {
                    offerCostOfLiving.setError("Input cannot be empty");
                }

                if (!isValidString(leaveInput)) {
                    offerLeaveTime.setError("Input cannot be empty");
                }

                if (!isValidString(salaryInput)) {
                    offerYearlySalary.setError("Input cannot be empty");
                }

                if (!isValidString(bonusInput)) {
                    offerYearlyBonus.setError("Input cannot be empty");
                }

                if (!isValidString(retireInput)) {
                    offerRetirementBenefits.setError("Input cannot be empty");
                }
            }

        });


        // save and compare
        Button saveAndCompare = (Button) findViewById(R.id.saveAndCompareButton);
        saveAndCompare.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            String titleInput = offerJobTitle.getText().toString();
            String companyInput = offerJobCompany.getText().toString();
            String cityInput = offerCity.getText().toString();

            String costInput = offerCostOfLiving.getText().toString();
            String leaveInput = offerLeaveTime.getText().toString();
            String salaryInput = offerYearlySalary.getText().toString();
            String bonusInput = offerYearlyBonus.getText().toString();
            String retireInput = offerRetirementBenefits.getText().toString();
            String stateInput = stateDataAdapter.getItem(offerState.getSelectedItemPosition());
            int workRemoteInput = Integer.parseInt(remoteDayDataAdapter.getItem(offerRemoteDays.getSelectedItemPosition()));

            if (isValidString(titleInput) && isValidString(companyInput) &&
                    isValidString(cityInput) && isValidString(costInput) &&
                    isValidString(leaveInput) && isValidString(salaryInput) &&
                    isValidString(bonusInput) && isValidString(retireInput)) {
                // save the job to the offer list
                //saveJobOffer();
                //DB Save
                final JobEntity jobSpecsToSave = new JobEntity(
                        uid,
                        offerJobTitle.getText().toString(),
                        offerJobCompany.getText().toString(),
                        offerCity.getText().toString(), stateInput,
                        Integer.parseInt(offerCostOfLiving.getText().toString()), workRemoteInput,
                        Double.parseDouble(offerYearlySalary.getText().toString()),
                        Double.parseDouble(offerYearlyBonus.getText().toString()),
                        Double.parseDouble(offerRetirementBenefits.getText().toString()),
                        Integer.parseInt(offerLeaveTime.getText().toString()),1);

                Long newJobId = mDb.appDAO().insertNewJob(jobSpecsToSave);
                JobEntity currentJob = mDb.appDAO().findCurrentJob();
                if(currentJob != null) {
                    JobOffer jobA = new JobOffer(currentJob.getTitle(), currentJob.getCompany(), new Location(currentJob.getCity(),
                            currentJob.getState()), currentJob.getCostOfLiving(), currentJob.getWorkRemote(), currentJob.getYearlySalary(),
                            currentJob.getYearlyBonus(), currentJob.getRetirementBenefits(), currentJob.getLeave(), (currentJob.isJobOffer == 1)? false : true);

                    JobOffer jobB = new JobOffer(offerJobTitle.getText().toString(), offerJobCompany.getText().toString(), new Location(offerCity.getText().toString(),
                            stateInput),  Integer.parseInt(offerCostOfLiving.getText().toString()), workRemoteInput, Double.parseDouble(offerYearlySalary.getText().toString()),
                            Double.parseDouble(offerYearlyBonus.getText().toString()), Double.parseDouble(offerRetirementBenefits.getText().toString()),  Integer.parseInt(offerLeaveTime.getText().toString()), false);

                    context.setCompareJobs(jobA, jobB);
                    Intent myIntent = new Intent(view.getContext(), TwoJobCompActivity.class);
                    startActivityForResult(myIntent, 0);
                }else{
                    offerJobTitle.setText("");
                    offerJobCompany.setText("");
                    offerCostOfLiving.setText("");
                    offerCity.setText("");
                    offerState.setSelection(0);
                    offerYearlySalary.setText("");
                    offerYearlyBonus.setText("");
                    offerRemoteDays.setSelection(0);
                    offerRetirementBenefits.setText("");
                    offerLeaveTime.setText("");
                    Toast.makeText(context, "No Current Job Established To Compare To Content has been saved", Toast.LENGTH_SHORT).show();
                }
            }

            if (!isValidString(titleInput)) {
                offerJobTitle.setError("Input cannot be empty");
            }

            if (!isValidString(companyInput)) {
                offerJobCompany.setError("Input cannot be empty");
            }

            if (!isValidString(cityInput)) {
                offerCity.setError("Input cannot be empty");
            }

            if (!isValidString(costInput)) {
                offerCostOfLiving.setError("Input cannot be empty");
            }

            if (!isValidString(leaveInput)) {
                offerLeaveTime.setError("Input cannot be empty");
            }

            if (!isValidString(salaryInput)) {
                offerYearlySalary.setError("Input cannot be empty");
            }

            if (!isValidString(bonusInput)) {
                offerYearlyBonus.setError("Input cannot be empty");
            }

            if (!isValidString(retireInput)) {
                offerRetirementBenefits.setError("Input cannot be empty");
            }
        }

    });

    }

    private void saveJobOffer(){

        String stateInput = stateDataAdapter.getItem(offerState.getSelectedItemPosition());
        int workRemoteInput = Integer.parseInt(remoteDayDataAdapter.getItem(offerRemoteDays.getSelectedItemPosition()));

        Job jobOffer = new JobOffer(offerJobTitle.getText().toString(),
                offerJobCompany.getText().toString(),
                new Location(offerCity.getText().toString(), stateInput),
                Integer.parseInt(offerCostOfLiving.getText().toString()), workRemoteInput,
                Double.parseDouble(offerYearlySalary.getText().toString()),
                Double.parseDouble(offerYearlyBonus.getText().toString()),
                Double.parseDouble(offerRetirementBenefits.getText().toString()),
                Integer.parseInt(offerLeaveTime.getText().toString()), false);

        // add to list
        ((JobOffer)jobOffer).updateRank(context.getComparisonSettings());

        context.addJobOffer(jobOffer);
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
