package com.yasser.busapp.dao;

import com.yasser.busapp.model.Ligne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneRepository extends JpaRepository<Ligne,Integer> {
    Ligne findById(int id);
}
