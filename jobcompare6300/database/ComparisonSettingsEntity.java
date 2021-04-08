package edu.gatech.seclass.jobcompare6300.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Settings")
public class ComparisonSettingsEntity {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "yearly_salary")
    public Integer yearlySalary;

    @ColumnInfo(name = "yearly_bonus")
    public Integer yearlyBonus;

    @ColumnInfo(name = "telework_days")
    public Integer teleworkDays;

    @ColumnInfo(name = "retirement_benefits")
    public Integer retirementBenefits;

    @ColumnInfo(name = "leave_time")
    public Integer leaveTime;

    public ComparisonSettingsEntity(int uid, Integer yearlySalary, Integer yearlyBonus, Integer teleworkDays, Integer retirementBenefits, Integer leaveTime) {
        this.uid = uid;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.teleworkDays = teleworkDays;
        this.retirementBenefits = retirementBenefits;
        this.leaveTime = leaveTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Integer getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(Integer yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public Integer getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(Integer yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }

    public Integer getTeleworkDays() {
        return teleworkDays;
    }

    public void setTeleworkDays(Integer teleworkDays) {
        this.teleworkDays = teleworkDays;
    }

    public Integer getRetirementBenefits() {
        return retirementBenefits;
    }

    public void setRetirementBenefits(Integer retirementBenefits) {
        this.retirementBenefits = retirementBenefits;
    }

    public Integer getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Integer leaveTime) {
        this.leaveTime = leaveTime;
    }
}
