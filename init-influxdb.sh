#!/bin/bash

set -e
influx setup --username $ADMIN_USER --password $ADMIN_PASSWORD --org $STORE_USER --bucket $BUCKET_INTERNAL
influx user create --name $STORE_USER --password $STORE_PASSWORD

influx bucket create --name $BUCKET_TELEMETRY
influx bucket create --name $BUCKET_DATA

TOKEN=$(influx auth create --user $STORE_USER --read-buckets --write-buckets | tail -n -1 | cut -f 4)

touch /etc/influxdb2/storeapp
echo "data:" > /etc/influxdb2/storeapp
echo "  org: $STORE_USER" >> /etc/influxdb2/storeapp
echo "  token: $TOKEN" >> /etc/influxdb2/storeapp
echo "  bucket: $BUCKET_DATA" >> /etc/influxdb2/storeapp
echo "telemetry:" >> /etc/influxdb2/storeapp
echo "  org: $STORE_USER" >> /etc/influxdb2/storeapp
echo "  token: $TOKEN" >> /etc/influxdb2/storeapp
echo "  bucket: $BUCKET_TELEMETRY" >> /etc/influxdb2/storeapp