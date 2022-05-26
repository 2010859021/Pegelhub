package com.stm.pegelhub.service;

import com.influxdb.client.InfluxDBClient;

import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.stm.pegelhub.InfluxDBConnection;

import com.stm.pegelhub.model.TelemetryData;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;


@Service
public class TelemetryService {

    private InfluxDBConnection inConn;
    private  InfluxDBClient client;
    private String token;
    private String bucket;
    private String org;
    private  String url;

    public TelemetryData writeTelemetryData(TelemetryData telemetryDataPoint) {

        Point telemetryData = Point.measurement(UUID.randomUUID().toString())
                .addTag("stationIPAddressIntern", telemetryDataPoint.getStationIPAddressIntern())
                .addTag("stationIPAddressExtern", telemetryDataPoint.getStationIPAddressExtern())
                .addField("cycleTime", telemetryDataPoint.getCycleTime())
                .addField("temperatureWater", telemetryDataPoint.getTemperatureWater())
                .addField("temperatureAir", telemetryDataPoint.getTemperatureAir())
                .addField("performanceVoltageBattery", telemetryDataPoint.getPerformanceVoltageBattery())
                .addField("performanceVoltageSupply", telemetryDataPoint.getPerformanceVoltageSupply())
                .addField("performanceElectricityBattery", telemetryDataPoint.getPerformanceElectricityBattery())
                .addField("performanceElectricitySupply", telemetryDataPoint.getPerformanceElectricitySupply())
                .addField("fieldStrengthTransmission", telemetryDataPoint.getFieldStrengthTransmission())
                .time(telemetryDataPoint.getTimestamp(), WritePrecision.MS);

        if(this.inConn == null || this.client == null){
            this.buildConnection();
        }
        boolean resultPoint = this.inConn.writePointbyPoint(this.client, telemetryData);
        this.client.close();
        if (resultPoint) {
            return telemetryDataPoint;
        } else {
            return null;
        }
    }
    public List<TelemetryData> queryData(String range) {
        if(this.inConn == null || this.client == null){
            this.buildConnection();
        }

        String query = "from(bucket: \"TelemetryData\") |> range(start: -" + range +")";
        // from(bucket: "myFirstBucket")
        // |> range(start: v.timeRangeStart, stop: v.timeRangeStop)
        // |> filter(fn: (r) => r["_measurement"] == "sensor")
        // |> filter(fn: (r) => r["_field"] == "model_number")
        // |> filter(fn: (r) => r["sensor_id"] == "TLM0100" or r["sensor_id"] ==
        // "TLM0101" or r["sensor_id"] == "TLM0103" or r["sensor_id"] == "TLM0200")
        // |> sort()
        // |> yield(name: "sort")

       this.inConn.queryData(this.client, query);

       return  null;
    }
    private void buildConnection(){

        this.token = "WtI-pEnFIxNCbeeVQ_PyUXrfM6cR81vJcYNGiA6JXxCrU1ZEoc2oQLqAPWe3pNfWD316yfWuKwjO0IeqiGlMmw==";
        this.bucket = "TelemetryData";
        this.org = "2020859001@fh-burgenland.at";
        this.url = "https://eu-central-1-1.aws.cloud2.influxdata.com";
        this.inConn = new InfluxDBConnection();
        this.client = inConn.buildConnection(url, token, org, bucket);
    }

    public TelemetryData queryLastData(String uuiId) {
        if(this.inConn == null || this.client == null){
            this.buildConnection();
        }

        String query = "from(bucket: \"TelemetryData\") |> range(start: -72h) |> filter(fn: (r) => r._measurement == \"" + uuiId +" \") |> first()";

        this.inConn.queryData(this.client, query);

        return  null;
    }
}
