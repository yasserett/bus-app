package com.yasser.busapp.controller;
import com.yasser.busapp.model.Ligne;
import com.yasser.busapp.model.Position;
import com.yasser.busapp.model.Station;
import com.yasser.busapp.model.Trajet;
import com.yasser.busapp.service.imp.LigneserviceImp;
import com.yasser.busapp.service.imp.StationServiceImp;
import com.yasser.busapp.service.imp.TrajetServiceImp;
import org.locationtech.jts.geom.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SecondaryController {

    @Autowired
    StationServiceImp StationService;
    @Autowired
    LigneserviceImp LigneService;
    @Autowired
    TrajetServiceImp TrajetService;

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
        station.setName("Station Souissi");
        stationList.add(station); // Ajout de la station dans la liste de la ligne
        // creation de la deuxieme station
        Point location2 = geometryFactory.createPoint(new Coordinate(	33.99592361261128,-6.851853132247925));
        Station station2 = new Station();
        station2.setLocation(location2);
        station2.setName("Station Ibn Sina");
        stationList.add(station2); // Ajout de la station dans la liste de la ligne
        // creation de la troisième station
        Point location3 = geometryFactory.createPoint(new Coordinate(	34.000266502452384,-6.843827962875366));
        Station station3 = new Station();
        station3.setLocation(location3);
        station3.setName("Station Nations Unies");
        stationList.add(station3); // Ajout de la station dans la liste de la ligne
        // creation de la quatrième station
        Point location4 = geometryFactory.createPoint(new Coordinate(	34.00745524275185,-6.8413496017456055));
        Station station4 = new Station();
        station4.setLocation(location4);
        station4.setName("Station Bibliothèque Nationale");
        stationList.add(station4); // Ajout de la station dans la liste de la ligne
        // creation de la station de fin
        Point location5 = geometryFactory.createPoint(new Coordinate(	34.012844731169515,-6.838324069976807));
        Station station5 = new Station();
        station5.setLocation(location5);
        station5.setName("Station Bab Rouah");
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

    @GetMapping(value = "/addHistory1",produces = MediaType.APPLICATION_JSON_VALUE)
    public String addHistory1(){
        //geometry factory to create geometry types
        GeometryFactory geometryFactory = new GeometryFactory();
        //creation du trajet 1
        Trajet trajet = new Trajet();
        //creation de la liste de position pour UN trajet
        List<Position> positionList = new ArrayList<>();
        //creation de la position 1 checked
        Position position1 = new Position();
        position1.setTime(LocalTime.of(12,0,0));
        position1.setLocation(geometryFactory.createPoint(new Coordinate(33.99051970698684,-6.85671329498291)));
        position1.setTrajet(trajet);
        positionList.add(position1);
        //creation de la position 2 checked
        Position position2 = new Position();
        position2.setTime(LocalTime.of(12,2,0));
        position2.setLocation(geometryFactory.createPoint(new Coordinate(33.9935085762786,-6.854095458984375)));
        position2.setTrajet(trajet);
        positionList.add(position2);
        //creation de la position 3 checked
        Position position3 = new Position();
        position3.setTime(LocalTime.of(12,4,0));
        position3.setLocation(geometryFactory.createPoint(new Coordinate(33.99614154068982,-6.851692199707031)));
        position3.setTrajet(trajet);
        positionList.add(position3);
        //creation de la position 4 checked
        Position position4 = new Position();
        position4.setTime(LocalTime.of(12,6,0));
        position4.setLocation(geometryFactory.createPoint(new Coordinate(33.99799168308225,-6.8465423583984375)));
        position4.setTrajet(trajet);
        positionList.add(position4);
        //creation de la position 5 checked
        Position position5 = new Position();
        position5.setTime(LocalTime.of(12,8,0));
        position5.setLocation(geometryFactory.createPoint(new Coordinate(34.00048219575074,-6.843752861022949)));
        position5.setTrajet(trajet);
        positionList.add(position5);
        //creation de la position 6 checked
        Position position6 = new Position();
        position6.setTime(LocalTime.of(12,10,0));
        position6.setLocation(geometryFactory.createPoint(new Coordinate(34.003257252424646,-6.842937469482421)));
        position6.setTrajet(trajet);
        positionList.add(position6);
        //creation de la position 7 checked
        Position position7 = new Position();
        position7.setTime(LocalTime.of(12,12,0));
        position7.setLocation(geometryFactory.createPoint(new Coordinate(34.00766869434317,-6.841135025024414)));
        position7.setTrajet(trajet);
        positionList.add(position7);
        //creation de la position 8 checked
        Position position8 = new Position();
        position8.setTime(LocalTime.of(12,14,0));
        position8.setLocation(geometryFactory.createPoint(new Coordinate(34.01051466429266,-6.8389892578125)));
        position8.setTrajet(trajet);
        positionList.add(position8);
        //creation de la position 9 checked
        Position position9 = new Position();
        position9.setTime(LocalTime.of(12,16,0));
        position9.setLocation(geometryFactory.createPoint(new Coordinate(34.012844731169515,-6.838324069976807)));
        position9.setTrajet(trajet);
        positionList.add(position9);
        //initialisation du trajet
        trajet.setLigne(LigneService.getAll().get(0));
        trajet.setPosition(positionList);
        //Persistance du trajet avec les positions en cascade
        TrajetService.save(trajet);
        return "OK";
    }

    @GetMapping(value = "/addHistory2",produces = MediaType.APPLICATION_JSON_VALUE)
    public String addHistory2(){
        //geometry factory to create geometry types
        GeometryFactory geometryFactory = new GeometryFactory();
        //creation du trajet 2
        Trajet trajet = new Trajet();
        //creation de la liste de position pour UN trajet
        List<Position> positionList = new ArrayList<>();
        //creation de la position 1 checked
        Position position1 = new Position();
        position1.setTime(LocalTime.of(13,45,0));
        position1.setLocation(geometryFactory.createPoint(new Coordinate(33.99051970698684,-6.85671329498291)));
        position1.setTrajet(trajet);
        positionList.add(position1);
        //creation de la position 2 checked
        Position position2 = new Position();
        position2.setTime(LocalTime.of(13,47,0));
        position2.setLocation(geometryFactory.createPoint(new Coordinate(33.992743578078084,-6.854631900787353)));
        position2.setTrajet(trajet);
        positionList.add(position2);
        //creation de la position 3 checked
        Position position3 = new Position();
        position3.setTime(LocalTime.of(13,49,0));
        position3.setLocation(geometryFactory.createPoint(new Coordinate(33.995696788915396,-6.852014064788818)));
        position3.setTrajet(trajet);
        positionList.add(position3);
        //creation de la position 4 checked
        Position position4 = new Position();
        position4.setTime(LocalTime.of(13,51,0));
        position4.setLocation(geometryFactory.createPoint(new Coordinate(33.99792052450453,-6.84722900390625)));
        position4.setTrajet(trajet);
        positionList.add(position4);
        //creation de la position 5
        Position position5 = new Position();
        position5.setTime(LocalTime.of(13,53,0));
        position5.setLocation(geometryFactory.createPoint(new Coordinate(34.00025983151689,-6.843752861022949)));
        position5.setTrajet(trajet);
        positionList.add(position5);
        //creation de la position 6
        Position position6 = new Position();
        position6.setTime(LocalTime.of(13,55,0));
        position6.setLocation(geometryFactory.createPoint(new Coordinate(34.00289258668993,-6.843023300170898)));
        position6.setTrajet(trajet);
        positionList.add(position6);
        //creation de la position 7
        Position position7 = new Position();
        position7.setTime(LocalTime.of(13,57,0));
        position7.setLocation(geometryFactory.createPoint(new Coordinate(34.00730404755003,-6.841510534286499)));
        position7.setTrajet(trajet);
        positionList.add(position7);
        //creation de la position 8 checked
        Position position8 = new Position();
        position8.setTime(LocalTime.of(13,59,0));
        position8.setLocation(geometryFactory.createPoint(new Coordinate(34.009776499998615,-6.839203834533691)));
        position8.setTrajet(trajet);
        positionList.add(position8);
        //creation de la position 9 checked
        Position position9 = new Position();
        position9.setTime(LocalTime.of(14,1,0));
        position9.setLocation(geometryFactory.createPoint(new Coordinate(34.012320027031365,-6.838474273681641)));
        position9.setTrajet(trajet);
        positionList.add(position9);
        //creation de la position 9 checked
        Position position10 = new Position();
        position10.setTime(LocalTime.of(14,3,0));
        position10.setLocation(geometryFactory.createPoint(new Coordinate(34.012844731169515,-6.838324069976807)));
        position10.setTrajet(trajet);
        positionList.add(position9);
        //initialisation du trajet
        trajet.setLigne(LigneService.getAll().get(0));
        trajet.setPosition(positionList);
        //Persistance du trajet avec les positions en cascade
        TrajetService.save(trajet);
        return "OK";
    }

    @GetMapping(value = "/addHistory3",produces = MediaType.APPLICATION_JSON_VALUE)
    public String addHistory3(){
        //geometry factory to create geometry types
        GeometryFactory geometryFactory = new GeometryFactory();
        //creation du trajet 3
        Trajet trajet = new Trajet();
        //creation de la liste de position pour UN trajet
        List<Position> positionList = new ArrayList<>();
        //creation de la position 1 checked
        Position position1 = new Position();
        position1.setTime(LocalTime.of(15,12,0));
        position1.setLocation(geometryFactory.createPoint(new Coordinate(33.99051970698684,-6.85671329498291)));
        position1.setTrajet(trajet);
        positionList.add(position1);
        //creation de la position 2 checked
        Position position2 = new Position();
        position2.setTime(LocalTime.of(15,14,0));
        position2.setLocation(geometryFactory.createPoint(new Coordinate(33.99176508196857,-6.855565309524536)));
        position2.setTrajet(trajet);
        positionList.add(position2);
        //creation de la position 3 checked
        Position position3 = new Position();
        position3.setTime(LocalTime.of(15,16,0));
        position3.setLocation(geometryFactory.createPoint(new Coordinate(33.99438031001771,-6.853247880935669)));
        position3.setTrajet(trajet);
        positionList.add(position3);
        //creation de la position 4 checked
        Position position4 = new Position();
        position4.setTime(LocalTime.of(15,18,0));
        position4.setLocation(geometryFactory.createPoint(new Coordinate(33.995696788915396,-6.852014064788818)));
        position4.setTrajet(trajet);
        positionList.add(position4);
        //creation de la position 5
        Position position5 = new Position();
        position5.setTime(LocalTime.of(15,20,0));
        position5.setLocation(geometryFactory.createPoint(new Coordinate(33.997208935448995,-6.8488168716430655)));
        position5.setTrajet(trajet);
        positionList.add(position5);
        //creation de la position 6
        Position position6 = new Position();
        position6.setTime(LocalTime.of(15,22,0));
        position6.setLocation(geometryFactory.createPoint(new Coordinate(33.998703265581184,-6.8451690673828125)));
        position6.setTrajet(trajet);
        positionList.add(position6);
        //creation de la position 7
        Position position7 = new Position();
        position7.setTime(LocalTime.of(15,24,0));
        position7.setLocation(geometryFactory.createPoint(new Coordinate(34.00063340309725,-6.843677759170531)));
        position7.setTrajet(trajet);
        positionList.add(position7);
        //creation de la position 8
        Position position8 = new Position();
        position8.setTime(LocalTime.of(15,26,0));
        position8.setLocation(geometryFactory.createPoint(new Coordinate(34.00539184970853,-6.8424224853515625)));
        position8.setTrajet(trajet);
        positionList.add(position8);
        //creation de la position 9 checked
        Position position9 = new Position();
        position9.setTime(LocalTime.of(15,28,0));
        position9.setLocation(geometryFactory.createPoint(new Coordinate(34.00761088459016,-6.8411993980407715)));
        position9.setTrajet(trajet);
        positionList.add(position9);
        //creation de la position 10
        Position position10 = new Position();
        position10.setTime(LocalTime.of(15,30,0));
        position10.setLocation(geometryFactory.createPoint(new Coordinate(34.009776499998615,-6.839203834533691)));
        position10.setTrajet(trajet);
        positionList.add(position10);
        //creation de la position 11
        Position position11 = new Position();
        position11.setTime(LocalTime.of(15,32,0));
        position11.setLocation(geometryFactory.createPoint(new Coordinate(34.01168859910852,-6.838624477386474)));
        position11.setTrajet(trajet);
        positionList.add(position11);
        //creation de la position 12
        Position position12 = new Position();
        position12.setTime(LocalTime.of(15,34,0));
        position12.setLocation(geometryFactory.createPoint(new Coordinate(34.012844731169515,-6.838324069976807)));
        position12.setTrajet(trajet);
        positionList.add(position12);
        //initialisation du trajet
        trajet.setLigne(LigneService.getAll().get(0));
        trajet.setPosition(positionList);
        //Persistance du trajet avec les positions en cascade
        TrajetService.save(trajet);
        return "OK";
    }
}