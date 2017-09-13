package com.karthik.springcloudm4secureui;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TollUsage {

    public String id;
    public String stationId;
    public String licensePlate;
    public String timestamp;

    @JsonCreator
    public TollUsage(@JsonProperty("id") final String id, @JsonProperty("stationId") final String stationId,
                     @JsonProperty("licensePlate") final String licensePlate, @JsonProperty("timestamp") final String timestamp){
        this.id = id;
        this.stationId = stationId;
        this.licensePlate = licensePlate;
        this.timestamp = timestamp;
    }
}
