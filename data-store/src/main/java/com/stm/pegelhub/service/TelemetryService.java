package com.stm.pegelhub.service;

import com.influxdb.client.InfluxDBClient;

import com.stm.pegelhub.InfluxDBConnection;

import com.stm.pegelhub.model.TelemetryData;
import org.springframework.stereotype.Service;


@Service
public class TelemetryService {

    private InfluxDBConnection inConn;
    private  InfluxDBClient client;
    private String token;
    private String bucket;
    private String org;
    private  String url;

    public TelemetryData writeTelemetryData(TelemetryData telemetryDataPoint) {

        if(this.inConn == null || this.client == null){
            this.buildConnection();
        }
        boolean resultPoint = this.inConn.writePointbyPOJO(this.client, telemetryDataPoint);
        this.client.close();
        if (resultPoint) {
            return telemetryDataPoint;
        } else {
            return null;
        }
    }
    public void queryData() {
        if(this.inConn == null || this.client == null){
            this.buildConnection();
        }

        String query = "from(bucket: \"Pegelhub\") |> range(start: -72h) |> filter(fn: (r) => r._measurement == \"telemetryData\")";
        // from(bucket: "myFirstBucket")
        // |> range(start: v.timeRangeStart, stop: v.timeRangeStop)
        // |> filter(fn: (r) => r["_measurement"] == "sensor")
        // |> filter(fn: (r) => r["_field"] == "model_number")
        // |> filter(fn: (r) => r["sensor_id"] == "TLM0100" or r["sensor_id"] ==
        // "TLM0101" or r["sensor_id"] == "TLM0103" or r["sensor_id"] == "TLM0200")
        // |> sort()
        // |> yield(name: "sort")

        this.inConn.queryData(this.client, query);

    }
    private void buildConnection(){

        this.token = "WtI-pEnFIxNCbeeVQ_PyUXrfM6cR81vJcYNGiA6JXxCrU1ZEoc2oQLqAPWe3pNfWD316yfWuKwjO0IeqiGlMmw==";
        this.bucket = "Pegelhub";
        this.org = "2020859001@fh-burgenland.at";
        this.url = "https://eu-central-1-1.aws.cloud2.influxdata.com";
        this.inConn = new InfluxDBConnection();
        this.client = inConn.buildConnection(url, token, org, bucket);
    }
}
