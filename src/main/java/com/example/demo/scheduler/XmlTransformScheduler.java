package com.example.demo.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class XmlTransformScheduler {

    @Autowired
    Job conversionJob;
    @Autowired
    JobLauncher jobLauncher;

    @Scheduled(cron = "0 0/1 * * * *")
    public void scheduleTransformJob(){
        try {
            jobLauncher.run(conversionJob,new JobParameters());
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            System.out.printf("failed to execute properly");
            e.printStackTrace();
        }
    }


}
