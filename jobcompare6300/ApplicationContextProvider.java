package edu.gatech.seclass.jobcompare6300;

import android.app.Application;
import android.content.Context;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.database.JobEntity;

public class ApplicationContextProvider extends Application {

    // Keeps a reference of the application context
    private static Context context;

    private ArrayList<JobOffer> jobList;
    private ArrayList<Integer> compareList;
    private Job currentJob;
    private ComparisonSettings comparisonSettings;

    private List<String> statesList;

    private int currentJobUid;

    public String[] getRemoteDaysDropDown() {
        return dayDropDown;
    }

    private String[] dayDropDown;

    private AppDatabase mDb;
    private Boolean hasData = false;
    private Integer uid = 0;

    private JobOffer compareJobA;
    private JobOffer compareJobB;

    @Override
    public void onCreate() {
        super.onCreate();

        mDb = AppDatabase.getInstance(getApplicationContext());

        context = getApplicationContext();
        comparisonSettings = new ComparisonSettings();

        jobList = new ArrayList<>();

        statesList = new ArrayList<String>(){{
            add("AK");
            add("AR");
            add("AS");
            add("AZ");
            add("CA");
            add("CO");
            add("CT");
            add("DC");
            add("DE");
            add("FL");
            add("GA");
            add("GU");
            add("HI");
            add("IA");
            add("ID");
            add("IL");
            add("IN");
            add("KS");
            add("KY");
            add("LA");
            add("MA");
            add("MD");
            add("ME");
            add("MI");
            add("MN");
            add("MO");
            add("MS");
            add("MT");
            add("NC");
            add("ND");
            add("NE");
            add("NH");
            add("NJ");
            add("NM");
            add("NV");
            add("NY");
            add("OH");
            add("OK");
            add("OR");
            add("PA");
            add("PR");
            add("RI");
            add("SC");
            add("SD");
            add("TN");
            add("TX");
            add("UT");
            add("VA");
            add("VI");
            add("VT");
            add("WA");
            add("WI");
            add("WV");
            add("WY");
        }};

        dayDropDown = new String[]{"0", "1", "2", "3", "4", "5"};  //  TODO: do as ints? Why strings?
        currentJob = getCurrentJob(); // TODO: what about first run? return null?

    }

    // Returns the application context
    public static Context getContext() {
        return context;
    }

    public Job getCurrentJob() {

                JobEntity jobSpecs = mDb.appDAO().findCurrentJob();
                if(jobSpecs != null) {

                    currentJob = new Job(jobSpecs.getTitle(), jobSpecs.getCompany(), new Location(jobSpecs.getCity(),
                            jobSpecs.getState()), jobSpecs.getCostOfLiving(), jobSpecs.getWorkRemote(), jobSpecs.getYearlySalary(),
                            jobSpecs.getYearlyBonus(), jobSpecs.getRetirementBenefits(), jobSpecs.getLeave(), true);

                    uid = jobSpecs.getUid();
                    hasData = true;
                    setCurrentJobUid(uid);

                }

        getJobList();
        return currentJob;
    }

    public void setCurrentJob(Job newCurrentJob) {

        this.currentJob = newCurrentJob;

        final JobEntity jobSpecsToSave = new JobEntity(
                uid,
                currentJob.getTitle(),
                currentJob.getCompany(),
                currentJob.getLocation().getCity(), currentJob.getLocation().getState(),
                currentJob.getCostOfLiving(),
                currentJob.getWorkRemote(),
                currentJob.getYearlySalary(),
                currentJob.getYearlyBonus(),
                currentJob.getRetirementBenefits(),
                currentJob.getLeave(),
                0);
                if (hasData==false) {
                    mDb.appDAO().insertNewJob(jobSpecsToSave);
                } else {
                    mDb.appDAO().updateCurrentJob(jobSpecsToSave);
                }
    }

    public ArrayList<JobOffer> getJobList() {

        jobList.clear();

        List<JobEntity> jobEntityList = mDb.appDAO().findAllJobs();
        if(jobEntityList != null) {

            for(JobEntity jobEntity : jobEntityList){

                JobOffer job = new JobOffer(jobEntity.getTitle(), jobEntity.getCompany(), new Location(jobEntity.getCity(),
                        jobEntity.getState()), jobEntity.getCostOfLiving(), jobEntity.getWorkRemote(), jobEntity.getYearlySalary(),
                        jobEntity.getYearlyBonus(), jobEntity.getRetirementBenefits(), jobEntity.getLeave(), (jobEntity.isJobOffer == 1)? false : true);

                job.updateRank(comparisonSettings);
                jobList.add(job);

            }
        }

        // TODO: necessary?
        for(JobOffer job : jobList){
            job.updateRank(this.getComparisonSettings());
        }

        // order jobOffers by rank
        Collections.sort(jobList);

        return jobList;
    }

    public int numberOfJobOffers(){
        return jobList.size();
    }

    public void addJobOffer(Job jobOffer){

        // DB Save
        final JobEntity jobSpecsToSave = new JobEntity(
                uid,
                jobOffer.getTitle(),
                jobOffer.getCompany(),
                jobOffer.getLocation().getCity(), jobOffer.getLocation().getState(),
                jobOffer.getCostOfLiving(),
                jobOffer.getWorkRemote(),
                jobOffer.getYearlySalary(),
                jobOffer.getYearlyBonus(),
                jobOffer.getRetirementBenefits(),
                jobOffer.getLeave(),1);
                Long newJobId = mDb.appDAO().insertNewJob(jobSpecsToSave);
    }

    public ComparisonSettings getComparisonSettings() {
        return comparisonSettings;
    }

    public void setComparisonSettings(ComparisonSettings comparisonSettings) {
        this.comparisonSettings = comparisonSettings;
    }

    public List<String> getStatesList() {
        return statesList;
    }

    public int getCurrentJobUid() {
        return currentJobUid;
    }

    public void setCurrentJobUid(int currentJobUid) {
        this.currentJobUid = currentJobUid;
    }

    public JobOffer getCompareJobA() {
        return compareJobA;
    }

    public JobOffer getCompareJobB() {
        return compareJobB;
    }

    public void setCompareJobs(JobOffer jobA, JobOffer jobB) {
        this.compareJobA = jobA;
        this.compareJobB = jobB;
    }

    public ArrayList<Integer> getCompareList() {
        return compareList;
    }

    public void setCompareList(ArrayList<Integer> compareList) {
        this.compareList = compareList;
    }
}