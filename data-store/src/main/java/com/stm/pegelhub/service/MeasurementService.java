package com.stm.pegelhub.service;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientOptions;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.stm.pegelhub.InfluxDBConfiguration;
import com.stm.pegelhub.InfluxDBConnection;
import com.stm.pegelhub.model.MeasurementData;
import com.stm.pegelhub.model.TelemetryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MeasurementService {
    @Autowired
    private InfluxDBConnection inConn;

    @Autowired
    @Qualifier("dataClient")
    private  InfluxDBClient client;

    public MeasurementData writeDataPoint(MeasurementData dataPoint) {

        Point measurementData = Point.measurement(dataPoint.getMeasurement()).time(Instant.now(), WritePrecision.MS);

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

    public List<MeasurementData> queryData(String range) {
        String query = "from(bucket: \"MeasurementData\") |> range(start: -" + range +")";

        this.inConn.queryData(this.client, query);

        return  null;
    }

    public Object queryLastData(String uuiId) {String query = "from(bucket: \"MeasurementData\") |> range(start: -72h) |> filter(fn: (r) => r._measurement == \"" + uuiId +" \") |> first()";

        this.inConn.queryData(this.client, query);

        return  null;
    }
}
