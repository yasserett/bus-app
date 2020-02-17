package com.yasser.busapp.controller;

import java.util.List;

import com.yasser.busapp.model.Ligne;
import com.yasser.busapp.model.Station;
import com.yasser.busapp.model.Trajet;
import com.yasser.busapp.service.imp.LigneserviceImp;
import com.yasser.busapp.service.imp.StationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

@Controller
public class TestController {

    @Autowired
    StationServiceImp StationService;

    @Autowired
    LigneserviceImp LigneService;

    @GetMapping(value = "/map")
    public String map(Model m){
        List<Ligne> listLigne = LigneService.getAll();
        List<Station> listStation = StationService.getAll();
        m.addAttribute("station",listStation.get(0));
        m.addAttribute("trajet",listLigne.get(0));
        return "/MapTest";
    }

    @GetMapping(value = "/stations")
    public String getStations(Model m){
        List<Station> list = StationService.getAll();
        m.addAttribute("list",list);
        return "/test";
    }

    @GetMapping(value="/closest")
    public String getClosestStation(Model m) {
        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint(new Coordinate(34.010792, -6.849247));
        m.addAttribute("point", point);
        return "/test";
    }

    @GetMapping(value = "/test",produces = MediaType.APPLICATION_JSON_VALUE)
    public String addStation(){
        GeometryFactory geometryFactory = new GeometryFactory();
        //Station 1
        Station station1 = new Station();
        Point point1 = geometryFactory.createPoint(new Coordinate(34.011347, -6.832693));
        station1.setLocation(point1);
        station1.setName("station1");
        StationService.save(station1);
        //Station 2
        Station station2 = new Station();
        Point point2 = geometryFactory.createPoint(new Coordinate(34.026116, -6.814574));
        station2.setLocation(point2);
        station2.setName("station2");
        StationService.save(station2);
        return "OK";
    }

    @GetMapping(value = "/trajets")
    public String lignes(Model m){
        List<Ligne> list = LigneService.getAll();
        m.addAttribute("list",list);
        return "/test2";
    }
}
