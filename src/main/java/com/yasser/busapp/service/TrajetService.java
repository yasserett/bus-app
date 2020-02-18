package com.yasser.busapp.service;

import com.yasser.busapp.model.Trajet;

import java.util.List;

public interface TrajetService {
    List<Trajet> getAll();

    void save(Trajet trajet);
}
