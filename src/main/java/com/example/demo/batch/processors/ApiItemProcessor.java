package com.example.demo.batch.processors;

import com.example.demo.model.JsonModel;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ApiItemProcessor implements ItemProcessor<JsonModel, JsonModel> {

    @Override
    public JsonModel process(JsonModel o) throws Exception {
        if (o != null) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSSS");
            o.setTimestamp(simpleDateFormat.format(date));
            return o;
        }

        return null;
    }
}
