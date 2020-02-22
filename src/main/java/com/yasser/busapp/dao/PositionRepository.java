package com.yasser.busapp.dao;

import com.yasser.busapp.model.Position;
import com.yasser.busapp.model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position,Integer> {
    List<Position> findByTrajet(Trajet trajet);
}
