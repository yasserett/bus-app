package com.yasser.busapp.controller;
import com.yasser.busapp.model.Ligne;
import com.yasser.busapp.model.Position;
import com.yasser.busapp.model.Station;
import com.yasser.busapp.model.Trajet;
import com.yasser.busapp.service.imp.LigneserviceImp;
import com.yasser.busapp.service.imp.StationServiceImp;
import org.apache.tomcat.jni.Local;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestTestController {

    @Autowired
    StationServiceImp StationService;
    @Autowired
    LigneserviceImp LigneService;

    @GetMapping(value = "/addData",produces = MediaType.APPLICATION_JSON_VALUE)
    public String addData(){
        //geometry factory to create geometry types
        GeometryFactory geometryFactory = new GeometryFactory();
        // creation d'une liste de stations pour la ligne
        List<Station> stationList = new ArrayList<>();
        // creation de la station de départ
        Point location = geometryFactory.createPoint(new Coordinate(33.99051970698684,-6.85671329498291));
        Station station = new Station();
        station.setLocation(location);
        station.setName("Station de départ");
        stationList.add(station); // Ajout de la station dans la liste de la ligne
        // creation de la deuxieme station
        Point location2 = geometryFactory.createPoint(new Coordinate(	33.99592361261128,-6.851853132247925));
        Station station2 = new Station();
        station2.setLocation(location2);
        station2.setName("Station deux");
        stationList.add(station2); // Ajout de la station dans la liste de la ligne
        // creation de la troisième station
        Point location3 = geometryFactory.createPoint(new Coordinate(	34.000266502452384,-6.843827962875366));
        Station station3 = new Station();
        station3.setLocation(location3);
        station3.setName("Station trois");
        stationList.add(station3); // Ajout de la station dans la liste de la ligne
        // creation de la quatrième station
        Point location4 = geometryFactory.createPoint(new Coordinate(	34.00745524275185,-6.8413496017456055));
        Station station4 = new Station();
        station4.setLocation(location4);
        station4.setName("Station quatre");
        stationList.add(station4); // Ajout de la station dans la liste de la ligne
        // creation de la station de fin
        Point location5 = geometryFactory.createPoint(new Coordinate(	34.012844731169515,-6.838324069976807));
        Station station5 = new Station();
        station5.setLocation(location5);
        station5.setName("Station de fin");
        stationList.add(station5); // Ajout de la station dans la liste de la ligne
        // creation of a ligne
        Coordinate[] cooList = new Coordinate[] { new Coordinate(33.99051970698684,-6.85671329498291),
                new Coordinate(33.99653292032535,-6.851305961608887),
                new Coordinate(33.998970107481576,-6.844203472137451),
                new Coordinate(34.00379090677527,-6.842808723449707),
                new Coordinate(34.00672594576666,-6.842014789581298),
                new Coordinate(34.009892116516696,-6.839118003845214),
                new Coordinate(34.012844731169515,-6.838324069976807)};
        LineString route = geometryFactory.createLineString(cooList);
        Ligne ligne = new Ligne();
        ligne.setName("Ligne de test");
        ligne.setRoute(route);
        ligne.setStations(stationList);
        LigneService.save(ligne);
        //return
        return "OK";
    }

    @GetMapping(value = "/addHistory",produces = MediaType.APPLICATION_JSON_VALUE)
    public String addHistory(){
        //creation de la liste de position pour UN trajet
        List<Position> positionList = new ArrayList<>();
        //creation de la position 1
        Position position1 = new Position();
        position1.setTime(LocalTime.of(12,0,0));
        positionList.add(position1);
        //creation de la position 2
        Position position2 = new Position();
        position2.setTime(LocalTime.of(12,2,0));
        positionList.add(position2);
        //creation de la position 3
        Position position3 = new Position();
        position3.setTime(LocalTime.of(12,4,0));
        positionList.add(position3);
        //creation de la position 4
        Position position4 = new Position();
        position4.setTime(LocalTime.of(12,6,0));
        positionList.add(position4);
        //creation de la position 5
        Position position5 = new Position();
        position5.setTime(LocalTime.of(12,8,0));
        positionList.add(position5);
        //creation de la position 6
        Position position6 = new Position();
        position6.setTime(LocalTime.of(12,10,0));
        positionList.add(position6);
        //creation de la position 7
        Position position7 = new Position();
        position7.setTime(LocalTime.of(12,12,0));
        positionList.add(position7);
        //creation de la position 8
        Position position8 = new Position();
        position8.setTime(LocalTime.of(12,14,0));
        positionList.add(position8);
        //creation de la position 9
        Position position9 = new Position();
        position9.setTime(LocalTime.of(12,16,0));
        positionList.add(position9);
        //creation de la position 10
        Position position10 = new Position();
        position9.setTime(LocalTime.of(12,18,0));
        positionList.add(position10);
        //creation du trajet
        Trajet trajet = new Trajet();
        trajet.setLigne(LigneService.getAll().get(0));
        trajet.setPosition(positionList);
        return "OK";
    }

    @GetMapping(value = "/containsTest",produces = MediaType.APPLICATION_JSON_VALUE)
    public String containsTest(){
        LineString route = LigneService.getAll().get(0).getRoute();
        Point point = StationService.getAll().get(0).getLocation();
        GeometryFactory geometryFactory = new GeometryFactory();
        Point point2 = geometryFactory.createPoint(new Coordinate(35.99051970698684,-6.85671329498291));
        double distance = point.distance(point2);
        if(point2.isWithinDistance(point,10))   return "OK"+distance;
        else    return "NOT OK"+distance;
    }
}