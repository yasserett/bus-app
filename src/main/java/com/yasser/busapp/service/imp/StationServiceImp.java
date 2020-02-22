package com.yasser.busapp.service.imp;

import com.yasser.busapp.dao.StationRepository;
import com.yasser.busapp.model.Ligne;
import com.yasser.busapp.model.Position;
import com.yasser.busapp.model.Station;
import com.yasser.busapp.service.StationService;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Override
    public List<Station> getByLigne(Ligne ligne) {
        return StationRepo.getAllByLignes(ligne);
    }
    @Override
    public Station GetById(int stationid) {
        return StationRepo.findById(stationid);
    }
    //Working : Method to return the closest position amnong a list of position TO a Point
    @Override
    public Position closestPoint(Point point, ArrayList<Position> list){
        double d = point.distance(list.get(0).getLocation());
        int c=0;
        for(int i=1;i<list.size();i++){
            double dt = point.distance(list.get(i).getLocation());
            if(dt<d){
                d=dt;c=i;
            }
        }
        return list.get(c);
    }
}
