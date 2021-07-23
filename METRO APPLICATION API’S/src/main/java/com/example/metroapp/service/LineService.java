package com.example.metroapp.service;

import com.example.metroapp.interfaces.ILineService;
import com.example.metroapp.model.Line;
import com.example.metroapp.repository.LineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineService implements ILineService {
    @Autowired
    LineRepo lineRepo;

    @Override
    public List<Line> getAllLines() {
        return lineRepo.findAll();
    }

}
