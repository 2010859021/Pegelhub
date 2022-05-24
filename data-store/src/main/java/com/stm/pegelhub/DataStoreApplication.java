package com.stm.pegelhub;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;

public class DataStoreApplication {

    public static void main(final String[] args) {

        // You can generate an API token from the "API Tokens Tab" in the UI
        String token = "WtI-pEnFIxNCbeeVQ_PyUXrfM6cR81vJcYNGiA6JXxCrU1ZEoc2oQLqAPWe3pNfWD316yfWuKwjO0IeqiGlMmw==";
        String bucket = "Pegelhub";
        String org = "2020859001@fh-burgenland.at";
        String url = "https://eu-central-1-1.aws.cloud2.influxdata.com";

        InfluxDBConnection inConn = new InfluxDBConnection();
        InfluxDBClient client = inConn.buildConnection(url, token, org, bucket);

        boolean resultPOJO = inConn.writePointbyPOJO(client);
        if (resultPOJO)
            System.out.println("Writey POJO done");

        boolean resultPoint = inConn.writePointbyPoint(client);
        if (resultPoint)
            System.out.println("Writey Point done");

        inConn.queryData(client);
        client.close();
    }
}
