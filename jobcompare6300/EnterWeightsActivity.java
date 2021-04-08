package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.database.ComparisonSettingsEntity;

public class EnterWeightsActivity extends AppCompatActivity{

    private EditText yearlySalary;
    private EditText yearlyBonus;
    private EditText teleworkDays;
    private EditText leaveTime;
    private EditText benefits;
    private ComparisonSettings settings;
    private Intent intent;
    private AppDatabase mDb;
    private Boolean hasData = false;
    private Integer uid = 0;

    ApplicationContextProvider context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comparison_settings);
        Button cancel = (Button) findViewById(R.id.cancelSettingsBut);
        Button save = (Button) findViewById(R.id.saveSettingsButton);
        yearlySalary = (EditText) findViewById(R.id.yearlyWeight);
        yearlyBonus = (EditText) findViewById(R.id.yearlyBonusWeight);
        teleworkDays = (EditText) findViewById(R.id.teleworkWeight);
        leaveTime = (EditText) findViewById(R.id.leaveTimeWeight);
        benefits = (EditText) findViewById(R.id.retirementBenefitsWeight);
        mDb = AppDatabase.getInstance(getApplicationContext());
        intent = getIntent();
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainMenu.class);
                startActivityForResult(myIntent, 0);
            }

        });
                ComparisonSettingsEntity settings = mDb.appDAO().findComparisonSettings();
                populateUI(settings);
    }

    public void handleSavingClick(View view){
        if (view.getId() == R.id.saveSettingsButton){
            int totalWeight = 0;
            String yearlySalaryWeight = this.yearlySalary.getText().toString();
            String yearlyBonusWeight = this.yearlyBonus.getText().toString();
            String teleworkWeight = this.teleworkDays.getText().toString();
            String leaveWeight = this.leaveTime.getText().toString();
            String retireWeight = this.benefits.getText().toString();

            boolean allValidWeight = isValidWeight(yearlySalaryWeight)
                    && isValidWeight(yearlyBonusWeight)
                    && isValidWeight(teleworkWeight)
                    && isValidWeight(leaveWeight)
                    && isValidWeight(retireWeight);

            if (allValidWeight) {
                int yearlySalaryWeightInt = Integer.parseInt(yearlySalaryWeight);
                int yearlyBonusWeightInt = Integer.parseInt(yearlyBonusWeight);
                int teleworkWeightInt = Integer.parseInt(teleworkWeight);
                int leaveWeightInt = Integer.parseInt(leaveWeight);
                int retireWeightInt = Integer.parseInt(retireWeight);

                totalWeight = yearlySalaryWeightInt + yearlyBonusWeightInt + teleworkWeightInt
                        + leaveWeightInt + retireWeightInt;

                if (totalWeight == 0) {
                    this.yearlySalary.setError("Total weight sum cannot be zero");
                    this.yearlyBonus.setError("Total weight sum cannot be zero");
                    this.teleworkDays.setError("Total weight sum cannot be zero");
                    this.leaveTime.setError("Total weight sum cannot be zero");
                    this.benefits.setError("Total weight sum cannot be zero");
                }
            }

            if (allValidWeight && totalWeight > 0) {
                final ComparisonSettingsEntity settings = new ComparisonSettingsEntity(
                        1,
                        Integer.parseInt(yearlySalary.getText().toString()),
                        Integer.parseInt(yearlyBonus.getText().toString()),
                        Integer.parseInt(teleworkDays.getText().toString()),
                        Integer.parseInt(benefits.getText().toString()),
                        Integer.parseInt(leaveTime.getText().toString()));

                // save to context
                context = (ApplicationContextProvider) getApplicationContext();

                ComparisonSettings currentSettings = context.getComparisonSettings();

                currentSettings.setYearlySalaryWeight(Integer.parseInt(yearlySalary.getText().toString()));
                currentSettings.setYearlyBonusWeight(Integer.parseInt(yearlyBonus.getText().toString()));
                currentSettings.setWorkRemoteWeight(Integer.parseInt(yearlyBonus.getText().toString()));
                currentSettings.setLeaveWeight(Integer.parseInt(leaveTime.getText().toString()));
                currentSettings.setRetirementBenefitsWeight(Integer.parseInt(benefits.getText().toString()));

                context.setComparisonSettings(currentSettings);
                // end save to context

                        if (!hasData) {
                            mDb.appDAO().insertNewSettings(settings);
                        } else {
                            settings.setUid(uid);
                            mDb.appDAO().updateSettings(settings);
                        }
                Intent myIntent = new Intent(view.getContext(), MainMenu.class);
                startActivityForResult(myIntent, 0);
            }

            if (!isValidWeight(yearlySalaryWeight)) {
                this.yearlySalary.setError("Cannot be empty");
            }
            if (!isValidWeight(yearlyBonusWeight)) {
                this.yearlyBonus.setError("Cannot be empty");
            }
            if (!isValidWeight(teleworkWeight)) {
                this.teleworkDays.setError("Cannot be empty");
            }
            if (!isValidWeight(leaveWeight)) {
                this.leaveTime.setError("Cannot be empty");
            }
            if (!isValidWeight(retireWeight)) {
                this.benefits.setError("Cannot be empty");
            }
        }
        else {
            throw new IllegalArgumentException("The button does not exist");
        }

    }

    private void populateUI(ComparisonSettingsEntity settings) {

        if (settings == null) {
            yearlySalary.setText("1");
            yearlyBonus.setText("1");
            teleworkDays.setText("1");
            leaveTime.setText("1");
            benefits.setText("1");
        }
        else {
            hasData = true;
            uid = settings.getUid();
            yearlySalary.setText(settings.getYearlySalary().toString());
            yearlyBonus.setText(settings.getYearlyBonus().toString());
            teleworkDays.setText(settings.getTeleworkDays().toString());
            leaveTime.setText(settings.getLeaveTime().toString());
            benefits.setText(settings.getRetirementBenefits().toString());
        }
    }

    private boolean isValidWeight(String w) {
        return !w.isEmpty() && w != null;
    }
}
