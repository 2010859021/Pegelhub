package com.stm.pegelhub;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.exceptions.InfluxException;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
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

    public boolean writePointbyPOJO(InfluxDBClient influxDBClient) {
        boolean flag = false;
        try {
            WriteApiBlocking writeApi = influxDBClient.getWriteApiBlocking();

            MeasurementData measurementData = new MeasurementData();
            measurementData.setId(UUID.randomUUID());
            measurementData.setTimestamp(Instant.now());
            measurementData.setTimetype("W");
            measurementData.setErrorCode("0x90");
            measurementData.setChannelUse("0Q");
            measurementData.setQuality("000");
            measurementData.setTyp("Test");
            measurementData.setValue(233.81);

            // writeApi.writeRecord(bucket, org, WritePrecision.NS, measurementData);
            writeApi.writeMeasurement(WritePrecision.MS, measurementData);
            flag = true;
        } catch (

                InfluxException e) {
            System.out.println("Exception!!" + e.getMessage());
        }
        return flag;
    }

    public boolean writePointbyPoint(InfluxDBClient influxDBClient) {
        boolean flag = false;
        try {

            WriteApiBlocking writeApi = influxDBClient.getWriteApiBlocking();

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

    public void queryData(InfluxDBClient influxDBClient) {
        String query = "from(bucket: \"Pegelhub\") |> range(start: -1h)";
        // from(bucket: "myFirstBucket")
        // |> range(start: v.timeRangeStart, stop: v.timeRangeStop)
        // |> filter(fn: (r) => r["_measurement"] == "sensor")
        // |> filter(fn: (r) => r["_field"] == "model_number")
        // |> filter(fn: (r) => r["sensor_id"] == "TLM0100" or r["sensor_id"] ==
        // "TLM0101" or r["sensor_id"] == "TLM0103" or r["sensor_id"] == "TLM0200")
        // |> sort()
        // |> yield(name: "sort")

        List<FluxTable> tables = influxDBClient.getQueryApi().query(query, org);

        for (FluxTable table : tables) {
            for (FluxRecord record : table.getRecords()) {
                System.out.println(record);
            }
        }
    }
}
