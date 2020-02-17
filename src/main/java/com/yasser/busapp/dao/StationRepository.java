package com.yasser.busapp.dao;

import com.yasser.busapp.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station,Integer> {
}
