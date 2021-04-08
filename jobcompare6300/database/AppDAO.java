package edu.gatech.seclass.jobcompare6300.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface AppDAO {
    @Query("SELECT * From Settings Limit 1")
    ComparisonSettingsEntity findComparisonSettings();

    @Insert
    void insertNewSettings(ComparisonSettingsEntity settings);

    @Update
    void updateSettings(ComparisonSettingsEntity settings);

    @Query("SELECT * From Jobs")
    List<JobEntity> findAllJobs();

    @Query("SELECT * From Jobs WHERE is_job_offer = 0")
    JobEntity findCurrentJob();

    @Query("SELECT * from Jobs WHERE uid IN (:uids)")
    public List<JobEntity> loadComparisonJobs(List<Integer> uids);

    @Insert
    Long insertNewJob(JobEntity job);

    @Update
    void updateCurrentJob(JobEntity job);


}
