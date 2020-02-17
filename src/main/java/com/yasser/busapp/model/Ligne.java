package com.yasser.busapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data   @Entity   @NoArgsConstructor
public class Ligne {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Column(columnDefinition = "LineString")
    private LineString route;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "StationLigne",joinColumns = @JoinColumn(name = "ligneId"),inverseJoinColumns = @JoinColumn(name = "stationId"))
    public List<Station> stations = new ArrayList<Station>();

    public double[][] getLngLat() {
        double[][] returnArray;
        Coordinate[] coArray = route.getCoordinates();
        int coArrayLength = coArray.length;
        returnArray = new double[coArrayLength][2];
        for(int i=0;i<coArrayLength;i++) {
            returnArray[i][0]=coArray[i].getX();
            returnArray[i][1]=coArray[i].getY();
        }
        return returnArray;
    }
}
