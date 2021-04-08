package edu.gatech.seclass.jobcompare6300;

import java.text.DecimalFormat;

public class JobsListViewModel {
    private boolean isSelected;
    private String jobStringTitle ;
    private String jobStringCompany;
    private boolean isCurrentJob;

//    public boolean isCurrentJob() {
//        return isCurrentJob;
//    }

    public void setIsCurrentJob(boolean currentJob) {
        isCurrentJob = currentJob;
    }

    public double getJobRank() {
        return jobRank;
    }

    public void setJobRank(double jobRank) {
        this.jobRank = jobRank;
    }

    private double jobRank;

    public boolean getSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getJobStringTitle() {
        return jobStringTitle;
    }

    public void setJobStringTitle(String jobStringTitle) {
        this.jobStringTitle = jobStringTitle;
    }

    public String getJobStringCompany() {
        return jobStringCompany;
    }

    public void setJobStringCompany(String jobStringCompany) {
        this.jobStringCompany = jobStringCompany;
    }

    public JobsListViewModel(String jobStringTitle, String jobStringCompany, boolean isSelected) {
        this.jobStringTitle = jobStringTitle;
        this.jobStringCompany = jobStringCompany;
        this.isSelected = isSelected;
    }
    public JobsListViewModel(String jobStringTitle, String jobStringCompany) {
        this.jobStringTitle = jobStringTitle;
        this.jobStringCompany = jobStringCompany;
    }

    public String getFullBanner (){
        if(this.isCurrentJob){
            return  "Current Job Title: " + this.jobStringTitle + " | Company: " + this.jobStringCompany ;
        }else{
            return  "Job Offer Title: " + this.jobStringTitle + " | Company: " + this.jobStringCompany ;
        }
    }
    public JobsListViewModel() {
    }
}
