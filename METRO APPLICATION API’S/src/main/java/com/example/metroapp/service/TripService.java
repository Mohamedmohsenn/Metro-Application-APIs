package com.example.metroapp.service;


import com.example.metroapp.interfaces.ITripService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TripService implements ITripService {
    private String[] line1 = {"marg", "ezbt elnakhl", "ain shams", "al matareya", "helmyt elzayton", "hadayek el zayton","sray el koba", "hamamat el koba", "kobry el koba", "manshiet el sadr", "eldemerdash", "ghamra","shohada","ahmed oraby", "gamal abdelnaser","sadat","sad zaghloul","elsayeda zaynab","elmalek el saleh", "mar girgis","zahraa masr el kadima", "dar el salam", "hadayek el maadi", "maadi", "sakanat el maadi", "tora el balad","kozzika", "tora el asmant", "el maasara", "hadayek helwan", "wadi-hof", "gamet helwan", "ain helwan","helwan"};
    private String[] line2 = {"moneb", "sakyet meky", "om elmasryeen", "giza", "faisal", "gamet el kahera","bohos", "dokky", "opera", "sadat", "mohamed nageb", "attaba", "shohada","msara","rod el farag", "sant treza", "khalafawy", "mazallat", "kolyt el zeraa", "shobra el khema"};
    private String[] line3 = {"attaba","bab el shareya", "elgesh", "abdo basha", "abasya", "ard el maared", "stad el kahera","kolyt el banat", "elahram", "haron el rashed", "heliopolis", "alf maskan", "nady el shams", "el nozha", "hesham barakat","qebaa"};
    private Map<String, Integer> lines ;
    private Map<Integer,String> linesOpposite;
    private int vertexSize;
    private int pred[];
    private List<ArrayList<Integer>> graph;

    private void initializeAndBuildGraph()
    {
        lines = new HashMap<>();
        linesOpposite = new HashMap<>();
        vertexSize = line1.length+line2.length+line3.length - 3;
        pred = new int[vertexSize];
        graph = new ArrayList<>(vertexSize);
        for (int i = 0; i < vertexSize; i++) {
            graph.add(new ArrayList<Integer>());
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
        int i = 0;
        for (; i < line1.length; i++) {
            lines.put(line1[i], i);
        }
        for (int m = 0; m < line2.length; m++) {
            if (!lines.containsKey(line2[m])) {
                lines.put(line2[m], i);
                i++;
            }
        }
        for (int m = 0; m < line3.length; m++) {
            if (!lines.containsKey(line3[m])) {
                lines.put(line3[m], i);
                i++;
            }
        }

        for (int m = 0; m < line1.length - 1; m++) {
            addEdge(lines.get(line1[m]), lines.get(line1[m + 1]));
            addEdge(lines.get(line1[m + 1]), lines.get(line1[m]));
        }

        for (int m = 0; m < line2.length - 1; m++) {
            addEdge(lines.get(line2[m]), lines.get(line2[m + 1]));
            addEdge(lines.get(line2[m + 1]), lines.get(line2[m]));
        }

        for (int m = 0; m < line3.length - 1; m++) {
            addEdge(lines.get(line3[m]), lines.get(line3[m + 1]));
            addEdge(lines.get(line3[m + 1]), lines.get(line3[m]));
        }
    }

    private void updatePred(String source, String destination)
    {
        initializeAndBuildGraph();
        boolean visited[] = new boolean[vertexSize];
        LinkedList<Integer> queue = new LinkedList<Integer>();

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
        Map<String,Boolean> station = new LinkedHashMap<>();
        for(int i = 0 ; i < path.size() ; i++)
        {
            if(path.get(i).equals("shohada"))
            {
                if((i == 0 || i == path.size()-1) || (path.get(i-1).equals("ghamra") && path.get(i+1).equals("ahmed oraby")) ||  (path.get(i-1).equals("ahmed oraby") && path.get(i+1).equals("ghamra")) || (path.get(i-1).equals("attaba") && path.get(i+1).equals("msara")) || (path.get(i-1).equals("msara") && path.get(i+1).equals("attaba")))
                    station.put("shohada",false);
                else
                    station.put("shohada",true);
            }
            else if(path.get(i).equals("sadat"))
            {
                if( (i == 0 || i == path.size()-1) || (path.get(i-1).equals("opera") && path.get(i+1).equals("mohamed nageb")) || (path.get(i-1).equals("mohamed nageb") && path.get(i+1).equals("opera")) || (path.get(i-1).equals("sad zaghloul") && path.get(i+1).equals("gamal abdelnaser")) || (path.get(i-1).equals("gamal abdelnaser") && path.get(i+1).equals("sad zaghloul")))
                    station.put("sadat",false);
                else
                    station.put("sadat",true);

            }
            else if(path.get(i).equals("attaba"))
            {
                if( (i == 0 || i == path.size()-1) || (path.get(i-1).equals("mohamed nageb") && path.get(i+1).equals("shohada")) || (path.get(i-1).equals("shohada") && path.get(i+1).equals("mohamed nageb")))
                    station.put("attaba",false);
                else
                    station.put("attaba",true);
            }
            else
                station.put(path.get(i),false);
        }
        return station;
    }

    @Override
    public Integer getTripEstimatedTime(String source,String destination)
    {
        Map<String,Boolean> stations = getTripPath(source,destination);
        int time = 0;
        for(Map.Entry<String,Boolean> mp : stations.entrySet())
        {
            if(mp.getValue() == true)
                time+=7;
            else
                time+=2;
        }
        return time;
    }
}




