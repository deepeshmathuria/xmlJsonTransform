package com.example.demo.batch.writers;


import com.example.demo.model.JsonModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Random;

@Component
public class ApiItemWriter implements ItemWriter<JsonModel> {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void write(List<? extends JsonModel> list) throws Exception {
        String jsonString = objectMapper.writeValueAsString(list.get(0));
        BufferedWriter writer = new BufferedWriter(new FileWriter("weather"+ Math.random()));
        writer.write(jsonString);
        writer.close();
    }
}
