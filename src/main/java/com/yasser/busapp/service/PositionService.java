package com.yasser.busapp.service;

import com.yasser.busapp.model.Position;
import com.yasser.busapp.model.Trajet;

import java.util.List;

public interface PositionService {
    List<Position> getPositionByTrajet(Trajet trajet);
}
