package com.yasser.busapp.dao;

import com.yasser.busapp.model.Ligne;
import com.yasser.busapp.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station,Integer> {
    public List<Station> getAllByLignes(Ligne ligne);
    Station findById(int stationid);
}
