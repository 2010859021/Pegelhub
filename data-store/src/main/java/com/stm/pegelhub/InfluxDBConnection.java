package com.stm.pegelhub;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.exceptions.InfluxException;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import com.stm.pegelhub.model.TelemetryData;
import lombok.Data;

import java.util.List;

@Data
public class InfluxDBConnection {

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
            writeApi.writePoint(dataPoint);
            flag = true;

        } catch (InfluxException e) {
            System.out.println("Exception!!" + e.getMessage());
        }
        return flag;
    }

    public void queryData(InfluxDBClient influxDBClient, String query) {

        List<FluxTable> tables = influxDBClient.getQueryApi().query(query, this.org);

        for (FluxTable table : tables) {
            for (FluxRecord record : table.getRecords()) {
                System.out.println(record);
              //  System.out.println(record.getTime().toString() + " " + record.getValueByKey("_field") );
            }
        }
    }

    private void disposeClient(){


    }
}
