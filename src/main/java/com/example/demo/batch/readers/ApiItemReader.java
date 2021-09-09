package com.example.demo.batch.readers;

import com.example.demo.model.JsonModel;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ApiItemReader implements ItemReader<JsonModel> {

    @Value("${url.websimulator}")
    private String apiUrl;


    @Override
    public JsonModel read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        JsonModel jsonModel = null;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(apiUrl);
            doc.getDocumentElement().normalize();

            jsonModel = new JsonModel(doc.getElementsByTagName("id").item(0).getTextContent(),doc.getElementsByTagName("temperature").item(0).getTextContent(),
                    doc.getElementsByTagName("humidity").item(0).getTextContent(),doc.getElementsByTagName("location").item(0).getTextContent(),null);

        }catch (Exception e){
            System.out.printf("Error in handling the API input");
            e.printStackTrace();
        }

        return jsonModel;
    }
}
