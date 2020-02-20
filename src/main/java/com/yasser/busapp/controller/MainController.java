package com.yasser.busapp.controller;

import java.util.List;

import com.yasser.busapp.model.Ligne;
import com.yasser.busapp.model.Station;
import com.yasser.busapp.service.imp.LigneserviceImp;
import com.yasser.busapp.service.imp.PositionServiceImp;
import com.yasser.busapp.service.imp.StationServiceImp;
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
        int prediction = 9;//will be replaced by the result of the prediction algorithm
        m.addAttribute("prediction",prediction);
        return "/mapstation";
    }
}
