package com.example.metroapp.service;


import com.example.metroapp.interfaces.ITripService;
import com.example.metroapp.model.Line;
import com.example.metroapp.model.Station;
import com.example.metroapp.repository.LineRepo;
import com.example.metroapp.repository.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TripService implements ITripService {

    @Autowired
    StationRepo stationRepo;

    @Autowired
    LineRepo lineRepo;

    private Map<String, Integer> lines ;
    private Map<Integer,String> linesOpposite;
    List<Station> stations;
    private int vertexSize;
    private int pred[];
    private List<ArrayList<Integer>> graph;

    private void initializeAndBuildGraph()
    {
        stations = stationRepo.findAll();
        lines = new HashMap<>();
        for (int i = 0 ; i < stations.size() ; i++) {
            lines.put(stations.get(i).getName(), i);
        }
        vertexSize = stations.size();
        linesOpposite = new HashMap<>();
        pred = new int[vertexSize];
        graph = new ArrayList<>(vertexSize);
        for (int i = 0; i < vertexSize; i++) {
            graph.add(new ArrayList<>());
        }
        buildGraph();
        for(Map.Entry<String,Integer> mp : lines.entrySet()){
            linesOpposite.put(mp.getValue(),mp.getKey());
        }
    }

    private void addEdge(int i, int j)
    {
        graph.get(i).add(j);
        graph.get(j).add(i);
    }

    private void buildGraph() {
        for (int m = 0; m < stations.size() ; m++)
        {
            List<Station> after = stations.get(m).getAfter();
            for(int j = 0 ; j < after.size() ; j++)
                addEdge(lines.get(stations.get(m).getName()), lines.get(after.get(j).getName()));
        }
    }

    private void updatePred(String source, String destination)
    {
        initializeAndBuildGraph();
        boolean visited[] = new boolean[vertexSize];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < vertexSize; i++) {
            visited[i] = false;
            pred[i] = -1;
        }

        visited[lines.get(source)] = true;
        queue.add(lines.get(source));
        boolean isDestFound = false;
        while (!queue.isEmpty())
        {
            int start = queue.remove();
            for(int i = 0 ; i < graph.get(start).size() ; i++)
            {
                if(!visited[graph.get(start).get(i)]) {
                    visited[graph.get(start).get(i)] = true;
                    pred[graph.get(start).get(i)] = start;
                    queue.add(graph.get(start).get(i));

                    if(graph.get(start).get(i) == lines.get(destination))
                    {
                        isDestFound = true;
                        break;
                    }
                }
            }
            if(isDestFound)
                break;
        }
    }

    private boolean isSameLineStations(String station1,String station2,String station3)
    {
        List<Line> stationOneLines = stationRepo.findByName(station1).getLines();
        List<Line> stationTwoLines = stationRepo.findByName(station2).getLines();
        List<Line> stationThreeLines = stationRepo.findByName(station3).getLines();
        List<Line> allLines = lineRepo.findAll();
        for(int i = 0 ; i < allLines.size() ; i++)
        {
            if(stationOneLines.contains(allLines.get(i)) && stationTwoLines.contains(allLines.get(i)) && stationThreeLines.contains(allLines.get(i)))
                return true;
        }
        return false;
    }

    private Map<String,Boolean> SetChangableStations(List<String> path)
    {
        Map<String,Boolean> station = new LinkedHashMap<>();

        for(int i = 0 ; i < path.size() ; i++)
        {
            if( i == 0 || i == path.size()-1 || isSameLineStations(path.get(i-1),path.get(i),path.get(i+1)))
                 station.put(path.get(i),false);
            else
                station.put(path.get(i),true);
        }
        return station;
    }

    @Override
    public Map<String,Boolean> getTripPath(String source, String destination)
    {
        updatePred(source,destination);
        List<String> path = new ArrayList<>();
        path.add(linesOpposite.get(lines.get(destination)));
        for(int i = lines.get(destination) ; pred[i]!=-1 ; )
        {
            path.add(linesOpposite.get(pred[i]));
            i = pred[i];
        }
        Collections.reverse(path);
        return SetChangableStations(path);
    }

    @Override
    public Integer getTripEstimatedTime(String source,String destination)
    {
        Map<String,Boolean> stations = getTripPath(source,destination);
        int time = 0;
        for(Map.Entry<String,Boolean> mp : stations.entrySet())
        {
            if(mp.getValue())
                time+=7;
            else
                time+=2;
        }
        return time;
    }
}




