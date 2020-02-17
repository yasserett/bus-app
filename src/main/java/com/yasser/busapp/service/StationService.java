package com.yasser.busapp.service;

import com.yasser.busapp.model.Station;
import org.locationtech.jts.geom.Point;

import java.util.List;

public interface StationService {
    List<Station> getAll();
    void save(Station station);
}
