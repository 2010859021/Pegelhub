package com.stm.pegelhub.controller;

        import com.fasterxml.jackson.core.JsonProcessingException;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.influxdb.exceptions.NotFoundException;
        import com.stm.pegelhub.data.IdentifiableEntity;
        import com.stm.pegelhub.model.DataPoint;
        import com.stm.pegelhub.model.MeasurementData;
        import com.stm.pegelhub.model.TelemetryData;
        import com.stm.pegelhub.service.MeasurementService;
        import com.stm.pegelhub.service.TelemetryService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.time.Instant;
        import java.util.Map;
        import java.util.UUID;


@RestController
@RequestMapping("/datastore/telemetry")
public class TelemetryController {

    @Autowired
    TelemetryService service;

    @GetMapping
    public ResponseEntity getAllMeasurementData() {
        try {
            this.service.queryData();
            // List<DataPoint> dataPoints = service.
            return ResponseEntity.ok("OK 200");
        } catch (NotFoundException exception) {

            return ResponseEntity.status(404).body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity writeMeasurementData(@RequestBody TelemetryData  telemetryData) throws JsonProcessingException {

      //  boolean resultPOJO = inConn.writePointbyPOJO(client);
      //  if (resultPOJO)
        //    System.out.println("Writey POJO done");
     //   ObjectMapper mapper = new ObjectMapper();
     //   TelemetryData telemetryData3 = mapper.readValue(telemetryData, TelemetryData.class);

        TelemetryData telemetryData2 = new TelemetryData();
        telemetryData2.setTimestamp(Instant.now());
        telemetryData2.setCycleTime(10);
        telemetryData2.setTemperatureWater(22.8);
        telemetryData2.setTemperatureAir(18.0);
        telemetryData2.setPerformanceVoltageBattery(13.60);
        telemetryData2.setPerformanceElectricityBattery(-3.323);
        telemetryData2.setPerformanceVoltageSupply(10.0);
        telemetryData2.setPerformanceElectricitySupply(7.321);
        telemetryData2.setFieldStrenghTrasmission(-74.0);
        telemetryData2.setStationIPAddressIntern("192.158.1.38");
        telemetryData2.setStationIPAddressExtern("10.10.1.38");

        TelemetryData responseDataPoint = service.writeTelemetryData(telemetryData2);
        return  ResponseEntity.ok(responseDataPoint);

    }
}
