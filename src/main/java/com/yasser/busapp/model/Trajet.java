package com.yasser.busapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor
public class Trajet {
    @Id @GeneratedValue
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Ligne ligne;

}
