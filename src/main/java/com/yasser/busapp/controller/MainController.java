package com.yasser.busapp.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import static java.time.temporal.ChronoUnit.MINUTES;

import com.yasser.busapp.model.Ligne;
import com.yasser.busapp.model.Position;
import com.yasser.busapp.model.Station;
import com.yasser.busapp.model.Trajet;
import com.yasser.busapp.service.imp.LigneserviceImp;
import com.yasser.busapp.service.imp.PositionServiceImp;
import com.yasser.busapp.service.imp.StationServiceImp;
import com.yasser.busapp.service.imp.TrajetServiceImp;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    StationServiceImp StationService;
    @Autowired
    PositionServiceImp PositionService;
    @Autowired
    LigneserviceImp LigneService;
    @Autowired
    TrajetServiceImp TrajetService;

    @GetMapping(value="/")
    public String index(Model m){
        m.addAttribute("list",LigneService.getAll());
        return "/index";
    }

    @GetMapping(value="/mapligne")
    public String mapligne(@RequestParam int ligneid,Model m){
        Ligne ligne = LigneService.getById(ligneid);
        m.addAttribute("ligne",ligne);
        List<Station> list = StationService.getByLigne(ligne);
        m.addAttribute("list",list);
        double[][] returnPos;
        returnPos = new double[list.size()][2];
        String[] returnName;
        returnName = new String[list.size()];
        int i=0;
        for (Station station: list) {
            returnPos[i][0]= station.getLocation().getX();
            returnPos[i][1]=station.getLocation().getY();
            returnName[i++] = station.getName();
        }
        m.addAttribute("listnames",returnName);
        m.addAttribute("listpos",returnPos);
        return "/mapligne";
    }

    @GetMapping(value="/mapstation")
    public String mapstation(@RequestParam int ligneid,@RequestParam int stationid, Model m){
        Ligne ligne = LigneService.getById(ligneid);
        m.addAttribute("ligne",ligne);
        List<Station> list = StationService.getByLigne(ligne);
        double[][] returnPos;
        returnPos = new double[list.size()][2];
        String[] returnName;
        returnName = new String[list.size()];
        int i=0;
        for (Station station: list) {
            returnPos[i][0]= station.getLocation().getX();
            returnPos[i][1]=station.getLocation().getY();
            returnName[i++]=station.getName();
        }
        m.addAttribute("listnames",returnName);
        m.addAttribute("listpos",returnPos);
        Station station = StationService.GetById(stationid);
        m.addAttribute("station",station);
        // part of the code for prediction Algorithm
        GeometryFactory geometryFactory = new GeometryFactory(); // to create Geom Types
        Point RealTimeBusPosition = geometryFactory.createPoint(new Coordinate(33.993419623353354,-6.854106187820435));
        List<Trajet> listTrajet = TrajetService.getByLigne(ligne);
        List<Long> listTime = new ArrayList<Long>();
        for (Trajet trajet: listTrajet) {
            List<Position> listPosition = PositionService.getPositionByTrajet(trajet);
            LocalTime t1 = StationService.closestPoint(RealTimeBusPosition,(ArrayList)listPosition).getTime();
            LocalTime t2 = StationService.closestPoint(station.getLocation(),(ArrayList)listPosition).getTime();
            listTime.add(MINUTES.between(t1, t2));
        }
        Long average = listTime.get(0);
        for(int j=1;j<listTime.size();j++){
            average= average+listTime.get(j);
        }
        average = average / listTime.size();
        int prediction = average.intValue();
        // End of Algorithm prediction
        m.addAttribute("prediction",prediction);
        return "/mapstation";
    }
}
