package com.stm.pegelhub.service;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.stm.pegelhub.InfluxDBConfiguration;
import com.stm.pegelhub.InfluxDBConnection;
import com.stm.pegelhub.model.MeasurementData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MeasurementService {
    @Autowired
    private InfluxDBConnection inConn;

    @Autowired
    @Qualifier("dataClient")
    private  InfluxDBClient client;

    @Autowired
    @Qualifier("dataConfiguration")
    private InfluxDBConfiguration.DBProps configuration;

    public MeasurementData writeDataPoint(MeasurementData dataPoint) {

        Point measurementData = Point.measurement(dataPoint.getMeasurement()).time(Instant.parse(dataPoint.getTimestamp()), WritePrecision.MS);

        for (Map.Entry<String, String> entry: dataPoint.getInfos().entrySet()) {
            measurementData.addTag(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Double> entry: dataPoint.getFields().entrySet()) {
            measurementData.addField(entry.getKey(), entry.getValue());
        }

        boolean resultPoint = this.inConn.writePointbyPoint(this.client, measurementData);

        if (resultPoint) {
            return dataPoint;
        } else {
            return null;
        }
    }

    public Object queryData(String range) {
        String query = "from(bucket: \"" + configuration.getBucket() + "\") |> range(start: -" + range +")";

     var points =   this.inConn.queryData(this.client, query);

        return  points;
    }

    public Object queryLastData(String uuiId) {String query = "from(bucket: \"" + configuration.getBucket() + "\") |> range(start: -72h) |> filter(fn: (r) => r._measurement == \"" + uuiId +"\") |> first()";

        var point =  this.inConn.queryData(this.client, query);

        return  point;
    }
}
