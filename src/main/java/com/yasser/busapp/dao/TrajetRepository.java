package com.yasser.busapp.dao;

import com.yasser.busapp.model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrajetRepository extends JpaRepository<Trajet,Integer> {
}
