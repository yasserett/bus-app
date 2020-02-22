package com.yasser.busapp.service;

import com.yasser.busapp.model.Ligne;
import com.yasser.busapp.model.Trajet;

import java.util.List;

public interface TrajetService {
    List<Trajet> getAll();

    void save(Trajet trajet);

    List<Trajet> getByLigne(Ligne ligne);
}
