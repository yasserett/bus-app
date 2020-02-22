package com.yasser.busapp.dao;

import com.yasser.busapp.model.Ligne;
import com.yasser.busapp.model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrajetRepository extends JpaRepository<Trajet,Integer> {
    List<Trajet> findByLigne(Ligne ligne);
}
