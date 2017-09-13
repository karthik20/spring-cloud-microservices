package com.karthik.springcloudm4secureservice;

public class TollUsage {

    public String id;
    public String stationId;
    public String licensePlate;
    public String timestamp;

    public TollUsage(final String id, final String stationId, final String licensePlate, final String timestamp){
        this.id = id;
        this.stationId = stationId;
        this.licensePlate = licensePlate;
        this.timestamp = timestamp;
    }
}
