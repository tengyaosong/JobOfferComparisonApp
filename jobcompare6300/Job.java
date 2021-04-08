package edu.gatech.seclass.jobcompare6300;

public class Job {

    private String title;
    private String company;
    private Location location;
    private int costOfLiving;
    private int workRemote;
    private double yearlySalary;
    private double yearlyBonus;
    private double retirementBenefits;
    private int leave;
    private boolean isCurrentJob;


    public boolean isCurrentJob() {
        return isCurrentJob;
    }

    // constructor
    public Job(String title, String company, Location location, int costOfLiving,
               int workRemote, double yearlySalary, double yearlyBonus,
               double retirementBenefits, int leave, boolean isCurrentJob){
        this.title = title;
        this.company = company;
        this.location = location;
        this.costOfLiving = costOfLiving;
        this.workRemote = workRemote;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.retirementBenefits = retirementBenefits;
        this.leave = leave;
        this.isCurrentJob = isCurrentJob;
    }

    public String getListName(){ // TODO: redundant - remove?
        if(title != ""){
            return String.format("Current job: %s at %s ", title, company);
        }
        return String.format("Current job not set.");
    }

    // getters and setters
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getCostOfLiving() {
        return costOfLiving;
    }

    public void setCostOfLiving(int costOfLiving) {
        this.costOfLiving = costOfLiving;
    }

    public int getWorkRemote() {
        return workRemote;
    }

    public void setWorkRemote(int workRemote) {
        this.workRemote = workRemote;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public double getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(double yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }

    public double getRetirementBenefits() {
        return retirementBenefits;
    }

    public void setRetirementBenefits(double retirementBenefits) {
        this.retirementBenefits = retirementBenefits;
    }

    public int getLeave() {
        return leave;
    }

    public void setLeave(int leave) {
        this.leave = leave;
    }

}
