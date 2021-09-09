package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.w3c.dom.NodeList;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class JsonModel {
    @JsonProperty("id")
    private String id;
    @JsonProperty("temperature")
    private String temperature;
    @JsonProperty("humidity")
    private String humidity;
    @JsonProperty("location")
    private String location;
    @JsonProperty("timestamp")
    private String timestamp;

}
