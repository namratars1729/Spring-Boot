package com.water.bengaluru_usage.service.impl;

import com.water.bengaluru_usage.model.BengaluruWaterUsageModel;
import com.water.bengaluru_usage.repository.BengaluruWaterUsageModelRepository;
import com.water.bengaluru_usage.service.BengaluruWaterUsageServiceInterface;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.List;

@Service
public class BengaluruWaterUsageServiceInterfaceImpl implements BengaluruWaterUsageServiceInterface{
    @Autowired
    BengaluruWaterUsageModelRepository bmRepository;

    enum DataHeaders{
        WardNumber, WardName, blank, xcoord, ycoord, AvgML
    }

    public void saveCSV(){
        List<BengaluruWaterUsageModel> dataList = bmRepository.findAll();

        if ( dataList.isEmpty() ) {
            System.out.println("No data in the table......loading data");
           // String filename = "/trial_data.csv";
            String filename = "/bengaluru_wards_water_data.csv";


            try(InputStream inputStream = getClass().getResourceAsStream( filename);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){

                final Iterable<CSVRecord> records = CSVFormat.Builder.create()
                        .setHeader( DataHeaders.class )
                        .setSkipHeaderRecord( true )
                        .build()
                        .parse( reader );

                for( CSVRecord record : records ) {
                    // ----- Extract data
                    String strWardNumber = record.get( DataHeaders.WardNumber );
                    String strWardName = record.get( DataHeaders.WardName );
                    String strBlank = record.get( DataHeaders.blank ).trim();
                    String strXcoord = record.get( DataHeaders.xcoord ).trim();
                    String strYcoord = record.get( DataHeaders.ycoord ).trim();
                    String strAvgML = record.get( DataHeaders.AvgML ).trim();

                    // ----- Transform data
                    Integer avgML = Integer.valueOf( strAvgML );
                    Double doubleXcoord = Double.parseDouble( strXcoord );
                    Double doubleYcoord = Double.parseDouble( strYcoord );

                    Coordinate coordinates = new Coordinate( doubleXcoord, doubleYcoord );
                    Point geom = new GeometryFactory().createPoint( coordinates );

                    // ------- LOAD the transformed data into our model
                    BengaluruWaterUsageModel bwuModel  = new BengaluruWaterUsageModel();
                    bwuModel.setWardNumber( strWardNumber );
                    bwuModel.setWardName( strWardName );
                    bwuModel.setAvgMl( avgML );
                    bwuModel.setGeom( geom );

                    bmRepository.save( bwuModel );
                }
                System.out.println( "Data Loaded" );

            } catch( IOException ioe ) {
                ioe.printStackTrace();
            }
        }
        else {
            System.out.println("Data present in the table");
        }
    }

    @Override
    public List<BengaluruWaterUsageModel> findAll() {
        saveCSV();
        return bmRepository.findAll();
    }

    @Override
    public List<BengaluruWaterUsageModel> findHighestConsumer() {
        return bmRepository.findHighestConsumer();
    }

    @Override
    public List<BengaluruWaterUsageModel> findTopTen() {
        return bmRepository.findTopTen();
    }

    @Override
    public List<BengaluruWaterUsageModel> findBetween150and200() {
        return bmRepository.findBetween150and200();
    }

    @Override
    public List<BengaluruWaterUsageModel> findBetween70and130() {
        return bmRepository.findBetween70and130();
    }

    @Override
    public List<BengaluruWaterUsageModel> findLessThan50() {
        return bmRepository.findLessThan50();
    }

}
