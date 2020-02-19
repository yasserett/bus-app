package com.yasser.busapp.service;

import com.yasser.busapp.model.Ligne;

import java.util.List;
import java.util.Optional;

public interface LigneService {
    void save(Ligne ligne);
    List<Ligne> getAll();

    Ligne getById(int id);
}
