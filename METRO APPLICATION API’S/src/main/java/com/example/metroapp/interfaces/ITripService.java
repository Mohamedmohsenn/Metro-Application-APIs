package com.example.metroapp.interfaces;

import java.util.Map;

public interface ITripService {
    public Integer getTripEstimatedTime(String source,String destination);
    public Map<String,Boolean> getTripPath(String source, String destination);
    public Integer getNumberOfRegions(String source, String destination);

}
