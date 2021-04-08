package edu.gatech.seclass.jobcompare6300.database;

import edu.gatech.seclass.jobcompare6300.Location;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Jobs")
public class JobEntity {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "company")
    public String company;

    @ColumnInfo(name = "city")
    public String city;

    @ColumnInfo(name = "state")
    public String state;

    @ColumnInfo(name = "cost_of_living")
    public Integer costOfLiving;

    @ColumnInfo(name = "work_remote")
    public Integer workRemote;

    @ColumnInfo(name = "yearly_salary")
    public Double yearlySalary;

    @ColumnInfo(name = "yearly_bonus")
    public Double yearlyBonus;

    @ColumnInfo(name = "retirement_benefits")
    public Double retirementBenefits;

    @ColumnInfo(name = "leave")
    public Integer leave;

    @ColumnInfo(name="is_job_offer")
    public Integer isJobOffer;

    public JobEntity(int uid, String title, String company, String city, String state, Integer costOfLiving, Integer workRemote, Double yearlySalary, Double yearlyBonus, Double retirementBenefits, Integer leave, Integer isJobOffer) {
        this.uid = uid;
        this.title = title;
        this.company = company;
        this.city = city;
        this.state = state;
        this.costOfLiving = costOfLiving;
        this.workRemote = workRemote;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.retirementBenefits = retirementBenefits;
        this.leave = leave;
        this.isJobOffer = isJobOffer;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCostOfLiving() {
        return costOfLiving;
    }

    public void setCostOfLiving(Integer costOfLiving) {
        this.costOfLiving = costOfLiving;
    }

    public Integer getWorkRemote() {
        return workRemote;
    }

    public void setWorkRemote(Integer workRemote) {
        this.workRemote = workRemote;
    }

    public Double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(Double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public Double getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(Double yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }

    public Double getRetirementBenefits() {
        return retirementBenefits;
    }

    public void setRetirementBenefits(Double retirementBenefits) {
        this.retirementBenefits = retirementBenefits;
    }

    public Integer getLeave() {
        return leave;
    }

    public void setLeave(Integer leave) {
        this.leave = leave;
    }

    public Integer getIsJobOffer() {
        return isJobOffer;
    }

    public void setIsJobOffer(Integer isJobOffer) {
        this.isJobOffer = isJobOffer;
    }
}
