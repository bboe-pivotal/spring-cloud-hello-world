#!/bin/sh
cd ${0%/*}
echo Creating services
cf cs p-service-registry standard service-registry
cf cs p-circuit-breaker-dashboard standard circuit-breaker

echo Build and deploy Hello Server
cd hello-server
./mvnw clean package
cf p

echo Build and deploy Hello Client
cd ../hello-client
./mvnw clean package
cf p
