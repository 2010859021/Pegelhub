package com.stm.pegelhub;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.ObjectExpression;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.exceptions.InfluxException;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import com.stm.pegelhub.model.TelemetryData;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

@Data
@Service
public class InfluxDBConnection {
  /*  @Autowired
    private InfluxDBConfiguration.DBProps */

    private String token;
    private String bucket;
    private String org;
    private String url;

    public InfluxDBClient buildConnection(String url, String token, String org, String bucket) {
        setToken(token);
        setBucket(bucket);
        setOrg(org);
        setUrl(url);
        return InfluxDBClientFactory.create(getUrl(), getToken().toCharArray(), getOrg(), getBucket());
    }

    public boolean writePointbyPOJO(InfluxDBClient influxDBClient, TelemetryData telemetryData) {
        boolean flag = false;
        try {
            WriteApiBlocking writeApi = influxDBClient.getWriteApiBlocking();

            // writeApi.writeRecord(bucket, org, WritePrecision.NS, measurementData);
            writeApi.writeMeasurement(WritePrecision.MS, telemetryData);
            flag = true;
        } catch (

                InfluxException e) {
            System.out.println("Exception!!" + e.getMessage());
        }
        return flag;
    }

    public boolean writePointbyPoint(InfluxDBClient influxDBClient, Point dataPoint) {
        boolean flag = false;
        try {

            WriteApiBlocking writeApi = influxDBClient.getWriteApiBlocking();
           // writeApi.writePoint(this.bucket, this.org, dataPoint);
            writeApi.writePoint( dataPoint);
            flag = true;

        } catch (InfluxException e) {
            System.out.println("Exception!!" + e.getMessage());
        }
        return flag;
    }

    public void queryData(InfluxDBClient influxDBClient, String query) {
        List<FluxTable> tables = influxDBClient.getQueryApi().query(query);

        HashMap<String, HashMap<String, HashMap<String, Object>>> points = new HashMap<>();
        //     measurement,    timestamp,        field,   value
        for (FluxTable table : tables) {

            for (FluxRecord record : table.getRecords()) {

                var time = record.getTime().toString();
                var measurement = record.getMeasurement();
                var field = record.getField();
                var tags = record.getValues();

              //  var tag = record.getField().
                var value = record.getValue();

                //putifabsent
                HashMap<String, HashMap<String, Object>> valuesTime = new HashMap<>();
                HashMap<String, Object> fieldValue = new HashMap<>();
                fieldValue.put(field, value);
                valuesTime.put(time, fieldValue);

                if(!points.containsKey(measurement) ){
                    points.put(measurement, valuesTime);
                } else if(points.containsKey(measurement) && !points.get(measurement).containsKey(time)){
                    points.get(measurement).put(time,fieldValue);
                } else  if (points.containsKey(measurement) && points.get(measurement).containsKey(time)){
                    points.get(measurement).get(time).put(field, value);
                }

            }
        }
        System.out.println(points);
    }

    private void disposeClient() {


    }
}
