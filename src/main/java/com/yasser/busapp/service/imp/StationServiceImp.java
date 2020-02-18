package com.yasser.busapp.service.imp;

import com.yasser.busapp.dao.StationRepository;
import com.yasser.busapp.model.Station;
import com.yasser.busapp.service.StationService;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImp implements StationService {
    @Autowired
    StationRepository StationRepo;
    @Override
    public List<Station> getAll() {
        return StationRepo.findAll();
    }
    @Override
    public void save(Station station) {
        StationRepo.save(station);
    }
}
