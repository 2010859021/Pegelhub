package com.stm.pegelhub;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.exceptions.InfluxException;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import com.stm.pegelhub.model.DataPoint;
import com.stm.pegelhub.model.MeasurementData;
import com.stm.pegelhub.model.TelemetryData;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

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

    public boolean writePointbyPoint(InfluxDBClient influxDBClient, DataPoint dataPoint) {
        boolean flag = false;
        try {

            WriteApiBlocking writeApi = influxDBClient.getWriteApiBlocking();

//measurementData
            Point measurementData = Point.measurement(UUID.randomUUID().toString())
                    .addTag("timeType", "S")
                    .addTag("error", "0x80")
                    .addTag("quality", "000")
                    .addField("0P", 15.7)
                    .addField("0Q", 18.3)
                    .time(Instant.now(), WritePrecision.MS);

            Point telemetryData = Point.measurement(UUID.randomUUID().toString())
                    .addTag("stationIPAddressIntern", "192.158.1.38")
                    .addTag("stationIPAddressExtern", "10.10.1.38")
                    .addField("cycleTime", 10)
                    .addField("temperatureWater", 22.8)
                    .addField("temperatureAir", 30.5)
                    .addField("performanceVoltageBattery", 13.6)
                    .addField("performanceVoltageSupply", 10.0)
                    .addField("performanceElectricityBattery", -3.323)
                    .addField("performanceElectricitySupply", 7.321)
                    .addField("fieldStrengthTransmission", -74.0)
                    .time(Instant.now(), WritePrecision.MS);

            Point point = Point.measurement("measurementData").addTag("Id", UUID.randomUUID().toString())
                    .addTag("timetype", "S")
                    .addTag("error", "0x80")
                    .addTag("channelUse", "0Q")
                    .addTag("quality", "000")
                    .addTag("typ", "Pegel")
                    .addField("value", 233.81)
                    .addField("model_number", "TLM89092A") // string kann auch field sein
                    .time(Instant.now(), WritePrecision.MS);

            writeApi.writePoint(point);
            flag = true;
        } catch (InfluxException e) {
            System.out.println("Exception!!" + e.getMessage());
        }
        return flag;
    }

    public void queryData(InfluxDBClient influxDBClient, String query) {

        List<FluxTable> tables = influxDBClient.getQueryApi().query(query, this.org);
        //influxDBClient.getQueryApi().

        for (FluxTable table : tables) {
            for (FluxRecord record : table.getRecords()) {
                System.out.println(record);
                System.out.println(record.getTime().toString() + " " + record.getValueByKey("_field") );
            }
        }
    }

    private void disposeClient(){

    }
}
