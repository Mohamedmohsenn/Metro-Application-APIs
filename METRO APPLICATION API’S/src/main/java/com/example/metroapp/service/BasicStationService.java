package com.example.metroapp.service;

import com.example.metroapp.interfaces.IBasicStationService;
import com.example.metroapp.model.Line;
import com.example.metroapp.model.Station;
import com.example.metroapp.repository.LineRepo;
import com.example.metroapp.repository.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicStationService implements IBasicStationService {
    @Autowired
    StationRepo stationRepo;

    @Autowired
    LineRepo lineRepo;

    private boolean isSameLineStations(List<Line> stationOneLines, List<Line> stationTwoLines, List<Line> stationThreeLines)
    {
        List<Integer> firstStations = new ArrayList<>();
        for (Line line : stationOneLines)
            firstStations.add(line.getId());

        List<Integer> secondStations = new ArrayList<>();
        for (Line line : stationTwoLines)
            secondStations.add(line.getId());

        List<Integer> thirdStations = new ArrayList<>();
        for (Line line : stationThreeLines)
            thirdStations.add(line.getId());

        List<Line> allLines = lineRepo.findAll();
        for(int i = 0 ; i < allLines.size() ; i++)
        {
            if(firstStations.contains(allLines.get(i).getId()) && secondStations.contains(allLines.get(i).getId()) && thirdStations.contains(allLines.get(i).getId()))
                return true;
        }
        return false;
    }
    private boolean isSameLineStations(List<Line> stationOneLines,List<Line> stationTwoLines)
    {
        List<Integer> firstStations = new ArrayList<>();
        for (Line line : stationOneLines)
            firstStations.add(line.getId());

        List<Integer> secondStations = new ArrayList<>();
        for (Line line : stationTwoLines)
            secondStations.add(line.getId());

        List<Line> allLines = lineRepo.findAll();
        for(int i = 0 ; i < allLines.size() ; i++)
        {
            if(firstStations.contains(allLines.get(i).getId()) && secondStations.contains(allLines.get(i).getId()) )
                return true;
        }
        return false;
    }


    @Override
    public List<Station> getAllStations()
    {
        return stationRepo.findAll();
    }

    ///add station in the middle
    @Override
    public boolean addStation(String[] prevStation,Station station,String[] afterStation)
    {
        if(prevStation.length != afterStation.length)
            return false;
        List<Station> prevSt = new ArrayList<>();
        List<Station> afterSt = new ArrayList<>();
        Station newStation = stationRepo.findByName(station.getName());
        if(newStation != null) {
            return false;
        }
        for(String pre : prevStation)
        {
            Station previous = stationRepo.findByName(pre);
            if(previous == null)
                return false;
            prevSt.add(previous);
        }
        for(String aft : afterStation)
        {
            Station after = stationRepo.findByName(aft);
            if(after == null)
                return false;
            afterSt.add(after);
        }
        boolean ok = true;
        for(int i = 0 ; i < prevSt.size() ; i++)
        {
            if(!isSameLineStations(prevSt.get(i).getLines(),station.getLines(),afterSt.get(i).getLines()))
                return false;
            if(prevSt.get(i).getAfter().contains(afterSt.get(i)))
            {
                prevSt.get(i).getAfter().remove(afterSt.get(i));
                afterSt.get(i).getPrevious().remove(prevSt.get(i));
                prevSt.get(i).getAfter().add(station);
                station.getPrevious().add(prevSt.get(i));
                station.getAfter().add(afterSt.get(i));
                afterSt.get(i).getPrevious().add(station);
            }
            else {
                ok = false;
                break;
            }
        }
        if(ok)
        {
            for(Line line : station.getLines())
            {
                line.getStations().add(station);
            }
            stationRepo.save(station);
            for(Station pre : prevSt)
            {
                stationRepo.save(pre);
            }
            for(Station aft : afterSt)
            {
                stationRepo.save(aft);
            }
            return true;
        }
        return false;
    }

    //add in the last
    @Override
    public boolean addStation(String[] prevStation,Station station)
    {
        Station newStation = stationRepo.findByName(station.getName());
        if(newStation != null) {
            return false;
        }
        List<Station> prevSt = new ArrayList<>();
        for(String pre : prevStation)
        {
            Station previous = stationRepo.findByName(pre);
            if(previous == null || previous.getAfter().size() > 0 || (!isSameLineStations(previous.getLines(),station.getLines())) )
                return false;
            prevSt.add(previous);
        }
        for(int i = 0 ; i < prevSt.size() ; i++)
        {
            prevSt.get(i).getAfter().add(station);
            station.getPrevious().add(prevSt.get(i));
        }
        for(Line line : station.getLines())
        {
            line.getStations().add(station);
        }
        stationRepo.save(station);
        for(Station pre : prevSt)
        {
            stationRepo.save(pre);
        }
        return true;
    }

    //add in the first
    @Override
    public boolean addStation(Station station,String[] afterStation)
    {
        Station newStation = stationRepo.findByName(station.getName());
        if(newStation != null) {
            return false;
        }
        List<Station> afterSt = new ArrayList<>();
        for(String aft : afterStation)
        {
            Station after = stationRepo.findByName(aft);
            if(after == null || after.getPrevious().size() > 0 || (!isSameLineStations(after.getLines(),station.getLines())))
                return false;
            afterSt.add(after);
        }
        for(int i = 0 ; i < afterSt.size() ; i++)
        {
            station.getAfter().add(afterSt.get(i));
            afterSt.get(i).getPrevious().add(station);
        }
        for(Line line : station.getLines())
        {
            line.getStations().add(station);
        }
        stationRepo.save(station);
        for(Station after : afterSt)
        {
            stationRepo.save(after);
        }
        return true;
    }

    // add to new line doesnt contain any stations
    @Override
    public boolean addStation(Station station)
    {
        Station newStation = stationRepo.findByName(station.getName());
        if(newStation != null) {
            return false;
        }
        for(Line line : station.getLines())
        {
            Line newLine = lineRepo.getById(line.getId());
            if(newLine.getStations().size() > 0)
                return false;
            line.getStations().add(station);
        }
        stationRepo.save(station);
        return true;
    }

    @Override
    public boolean updateStation(Integer id,Station newStation)
    {
        Station station = stationRepo.findById(id).get();
        if(station == null)
            return false;
        if(newStation.getName() != null)
            station.setName(newStation.getName());
        if(newStation.getLatitude() != null)
            station.setLatitude(newStation.getLatitude());
        if(newStation.getLongitude() != null)
            station.setLongitude(newStation.getLongitude());
        if(newStation.getLines() != null)
            station.setLines(newStation.getLines());
        stationRepo.save(station);
        return true;
    }

}
