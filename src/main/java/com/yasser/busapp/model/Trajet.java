package com.yasser.busapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Data @NoArgsConstructor
public class Trajet {
    @Id @GeneratedValue
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Ligne ligne;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "trajet")
    private List<Position> position;
}
