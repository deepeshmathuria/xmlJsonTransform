package com.example.demo.batch;

import com.example.demo.batch.processors.ApiItemProcessor;
import com.example.demo.batch.readers.ApiItemReader;
import com.example.demo.batch.writers.ApiItemWriter;
import com.example.demo.model.JsonModel;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.function.Function;

@Configuration
@EnableBatchProcessing
public class BatchFlow {

    @Autowired
    ApiItemReader itemReader;

    @Autowired
    ApiItemProcessor apiItemProcessor;

    @Autowired
    ApiItemWriter apiItemWriter;

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean(name="step1")
    public Step step(){
       return stepBuilderFactory.get("read_step").<JsonModel,JsonModel>chunk(1).reader(itemReader).processor(apiItemProcessor).writer(apiItemWriter).build();
    }

    @Bean(name="conversionJob")
    public Job sampleJob(@Qualifier("step1") Step step) {
        return this.jobBuilderFactory.get("sampleJob").start(step).build();

    }






}
