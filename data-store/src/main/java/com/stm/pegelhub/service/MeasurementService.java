package com.stm.pegelhub.service;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.stm.pegelhub.InfluxDBConnection;
import com.stm.pegelhub.model.MeasurementData;
import com.stm.pegelhub.model.TelemetryData;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class MeasurementService {

    private InfluxDBConnection inConn;
    private  InfluxDBClient client;
    private String token;
    private String bucket;
    private String org;
    private  String url;


    public MeasurementData writeDataPoint(MeasurementData dataPoint) {
        //measurementData
        Point measurementData = Point.measurement(UUID.randomUUID().toString())
                .addTag("timeType", "S")
                .addTag("error", "0x80")
                .addTag("quality", "000")
                .addField("0P", 15.7)
                .addField("0Q", 18.3)
                .time(Instant.now(), WritePrecision.MS);

        if(this.inConn == null ||this.client == null){
            this.buildConnection();
        }
        boolean resultPoint = this.inConn.writePointbyPoint(this.client, measurementData);
       // this.client.close();
        if (resultPoint) {
            return dataPoint;
        } else {
            return null;
        }
    }

    public List<MeasurementData> queryData(String range) {
        if(this.inConn == null || this.client == null){
            this.buildConnection();
        }

        String query = "from(bucket: \"MeasurementData\") |> range(start: -" + range +")";

        this.inConn.queryData(this.client, query);

        return  null;
    }

    private void buildConnection(){

        this.token = "WtI-pEnFIxNCbeeVQ_PyUXrfM6cR81vJcYNGiA6JXxCrU1ZEoc2oQLqAPWe3pNfWD316yfWuKwjO0IeqiGlMmw==";
        this.bucket = "MeasurementData";
        this.org = "2020859001@fh-burgenland.at";
        this.url = "https://eu-central-1-1.aws.cloud2.influxdata.com";
        this.inConn = new InfluxDBConnection();
        this.client = inConn.buildConnection(url, token, org, bucket);
    }

    public Object queryLastData(String uuiId) {
        if(this.inConn == null || this.client == null){
            this.buildConnection();
        }

        String query = "from(bucket: \"MeasurementData\") |> range(start: -72h) |> filter(fn: (r) => r._measurement == \"" + uuiId +" \") |> first()";

        this.inConn.queryData(this.client, query);

        return  null;
    }

    public MeasurementData writeTelemetryData(MeasurementData measurementDataPoint) {

      Point measurementData = Point.measurement(measurementDataPoint.getMeasurement());
      /*          .addField("cycleTime", measurementDataPoint.getCycleTime())
                .addField("temperatureWater", measurementDataPoint.getTemperatureWater())
                .addField("temperatureAir", measurementDataPoint.getTemperatureAir())
                .addField("performanceVoltageBattery", measurementDataPoint.getPerformanceVoltageBattery())
                .addTag("stationIPAddressIntern", measurementDataPoint.ge)
                .addTag("stationIPAddressExtern", measurementDataPoint.getStationIPAddressExtern())
                .time(measurementDataPoint.getTimestamp(), WritePrecision.MS);

*/
        if(this.inConn == null || this.client == null){
            this.buildConnection();
        }
        boolean resultPoint = this.inConn.writePointbyPoint(this.client, measurementData);
        this.client.close();
        if (resultPoint) {
            return measurementDataPoint;
        } else {
            return null;
        }

    }
}
