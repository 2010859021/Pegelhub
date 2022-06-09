package com.stm.pegelhub.service;

import com.influxdb.client.InfluxDBClient;

import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.stm.pegelhub.InfluxDBConfiguration;
import com.stm.pegelhub.InfluxDBConnection;

import com.stm.pegelhub.model.TelemetryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TelemetryService {

    @Autowired
    private InfluxDBConnection inConn;

    @Autowired
    @Qualifier("telemetryClient")
    private  InfluxDBClient client;

    public TelemetryData writeTelemetryData(TelemetryData telemetryDataPoint) {

        Point telemetryData = Point.measurement(telemetryDataPoint.getMeasurement())
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
                .time(Instant.now(), WritePrecision.MS);


        boolean resultPoint = this.inConn.writePointbyPoint(this.client, telemetryData);

        if (resultPoint) {
            return telemetryDataPoint;
        } else {
            return null;
        }
    }
    public List<TelemetryData> queryData(String range) {

        String query = "from(bucket: \"TelemetryData\") |> range(start: -" + range +")";
       this.inConn.queryData(this.client, query);

       return  null;
    }


    public TelemetryData queryLastData(String uuiId) {

        String query = "from(bucket: \"TelemetryData\") |> range(start: -72h) |> filter(fn: (r) => r._measurement == \"" + uuiId +" \") |> first()";

        this.inConn.queryData(this.client, query);

        return  null;
    }
}
