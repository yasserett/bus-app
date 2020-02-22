package com.yasser.busapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Station {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Column(columnDefinition = "point")
    private Point location;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "stations")
    private List<Ligne> lignes = new ArrayList<>();

    public double[] getLngLat() {
        double[] returnLngLat = new double[2];
        returnLngLat[0]=location.getX();
        returnLngLat[1]=location.getY();
        return returnLngLat;
    }
}
