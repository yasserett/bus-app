package com.yasser.busapp.dao;

import com.yasser.busapp.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Integer> {
}
