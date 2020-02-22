package com.yasser.busapp.service;

import com.yasser.busapp.model.Ligne;

import java.util.List;

public interface LigneService {
    void save(Ligne ligne);
    List<Ligne> getAll();

    Ligne getById(int id);
}
