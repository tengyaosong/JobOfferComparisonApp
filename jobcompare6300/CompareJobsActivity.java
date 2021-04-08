package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

//https://demonuts.com/android-listview-tutorial/#ch

public class CompareJobsActivity extends AppCompatActivity{

    ApplicationContextProvider context;
    ArrayList<JobOffer> jobList;
    ArrayList<Integer> compareJobsIndices;
    private ListView listView;
    private ArrayList<JobsListViewModel> modelArrayList;
    private ListViewAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_and_compare);
        jobList = new ArrayList<>();
        context = (ApplicationContextProvider) getApplicationContext();

        jobList = context.getJobList();
        listView = (ListView)findViewById(R.id.listView);
        modelArrayList = getModel(false);
        customAdapter = new ListViewAdapter(this, modelArrayList);
        listView.setAdapter(customAdapter);

        Button cancel = (Button) findViewById(R.id.mainMenuJobList);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainMenu.class);
                startActivityForResult(myIntent, 0);
            }

        });
        Button compare = (Button) findViewById(R.id.compareJobsMainScreen);
        compare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                compareJobsIndices =  context.getCompareList();
                if (compareJobsIndices.size() == 2) {
                    context.setCompareJobs(jobList.get(compareJobsIndices.get(0)), jobList.get(compareJobsIndices.get(1)));
                    Intent myIntent = new Intent(view.getContext(), TwoJobCompActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                else{
                    Toast.makeText(context, "Invalid number of jobs to compare", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private ArrayList<JobsListViewModel> getModel(boolean isSelect){
        ArrayList<JobsListViewModel> list = new ArrayList<>();
        for(JobOffer job : jobList){
            JobsListViewModel model = new JobsListViewModel();
            model.setSelected(false);
            model.setJobStringTitle(job.getTitle());
            model.setJobStringCompany(job.getCompany());
            model.setJobRank(job.getRank());
            model.setIsCurrentJob(job.isCurrentJob());
            list.add(model);
        }
        return list;
    }

}
