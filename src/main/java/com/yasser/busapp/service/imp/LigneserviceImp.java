package com.yasser.busapp.service.imp;

import com.yasser.busapp.dao.LigneRepository;
import com.yasser.busapp.model.Ligne;
import com.yasser.busapp.service.LigneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneserviceImp implements LigneService {

    @Autowired
    LigneRepository LigneRepo;

    @Override
    public void save(Ligne ligne) {
        LigneRepo.save(ligne);
    }

    @Override
    public List<Ligne> getAll() {
        return LigneRepo.findAll();
    }

    @Override
    public Ligne getById(int id) {
        return LigneRepo.findById(id);
    }
}
