package com.example.demo.batch;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;

import javax.sql.DataSource;

public class BatchConfig extends DefaultBatchConfigurer {
    @Override
    public void setDataSource(DataSource dataSource) {
        //This BatchConfigurer ignores any DataSource
    }
}
