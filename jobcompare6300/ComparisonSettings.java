package edu.gatech.seclass.jobcompare6300;

import android.app.Activity;

public class ComparisonSettings { // extends Activity {

    private int yearlySalaryWeight;
    private int yearlyBonusWeight;
    private int workRemoteWeight;
    private int retirementBenefitsWeight;
    private int leaveWeight;

    // constructors
    public ComparisonSettings(){
        yearlySalaryWeight = 1;
        yearlyBonusWeight = 1;
        workRemoteWeight = 1;
        retirementBenefitsWeight = 1;
        leaveWeight = 1;
    }

    public ComparisonSettings(int yearlySalaryWeight, int yearlyBonusWeight, int workRemoteWeight,
                              int retirementBenefitsWeight, int leaveWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
        this.yearlyBonusWeight = yearlyBonusWeight;
        this.workRemoteWeight = workRemoteWeight;
        this.retirementBenefitsWeight = retirementBenefitsWeight;
        this.leaveWeight = leaveWeight;
    }

    // getters
    public int getYearlySalaryWeight() {
        return yearlySalaryWeight;
    }

    public int getYearlyBonusWeight() {
        return yearlyBonusWeight;
    }

    public int getWorkRemoteWeight() {
        return workRemoteWeight;
    }

    public int getRetirementBenefitsWeight() {
        return retirementBenefitsWeight;
    }

    public int getLeaveWeight() {
        return leaveWeight;
    }

    // setters
    public void setYearlySalaryWeight(int yearlySalaryWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
    }

    public void setYearlyBonusWeight(int yearlyBonusWeight) {
        this.yearlyBonusWeight = yearlyBonusWeight;
    }

    public void setWorkRemoteWeight(int workRemoteWeight) {
        this.workRemoteWeight = workRemoteWeight;
    }

    public void setRetirementBenefitsWeight(int retirementBenefitsWeight) {
        this.retirementBenefitsWeight = retirementBenefitsWeight;
    }

    public void setLeaveWeight(int leaveWeight) {
        this.leaveWeight = leaveWeight;
    }



}
