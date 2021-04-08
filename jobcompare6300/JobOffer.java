package edu.gatech.seclass.jobcompare6300;

public class JobOffer extends Job implements Comparable<JobOffer>{

    private double rank;

    // constructor
    public JobOffer(String title, String company, Location location, int costOfLiving,
                    int workRemote, double yearlySalary, double yearlyBonus,
                    double retirementBenefits, int leave, boolean isCurrentJob){
        super(title, company, location, costOfLiving, workRemote, yearlySalary,
                yearlyBonus, retirementBenefits, leave, isCurrentJob);
    }

    @Override
    public String getListName(){
        //System.out.println("Rank: " + this.rank);
        return String.format("%s: %s at %s", this.getRank(), super.getTitle(), super.getCompany());
    }

    public double getRank() {
        return rank;
    }

    public void updateRank(ComparisonSettings comparisonSettings){
        // AYS + AYB + (RBP * AYS) + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8)
        double ays = getYearlySalary() * 100.0 / getCostOfLiving();
        double ayb = getYearlyBonus() * 100.0 / getCostOfLiving();
        double rbp = getRetirementBenefits();
        double lt = getLeave();
        double rwt = getWorkRemote();

        // weights
        double w1 = comparisonSettings.getYearlySalaryWeight();
        double w2 = comparisonSettings.getYearlyBonusWeight();
        double w3 = comparisonSettings.getRetirementBenefitsWeight();
        double w4 = comparisonSettings.getLeaveWeight();
        double w5 = comparisonSettings.getWorkRemoteWeight();
        double sum = w1 + w2 + w3 + w4 + w5;
        w1 = w1 / sum;
        w2 = w2 / sum;
        w3 = w3 / sum;
        w4 = w4 / sum;
        w5 = w5 / sum;

        rank = (w1 * ays) + (w2 * ayb) + (w3 * (rbp * ays)) + (w4 * (lt * ays / 260.0))
                - (w5 * ((260.0 - 52.0 * rwt) * (ays / 260.0) / 8.0));

        if(this.isCurrentJob()){
            rank = 9999999999999999999999.0;
        }
    }

    @Override
    public int compareTo(JobOffer jobOffer) {

        return (int)(jobOffer.getRank() - this.getRank());
    }
}