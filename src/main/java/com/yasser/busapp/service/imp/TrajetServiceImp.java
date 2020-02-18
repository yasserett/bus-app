package com.yasser.busapp.service.imp;

import com.yasser.busapp.dao.TrajetRepository;
import com.yasser.busapp.model.Trajet;
import com.yasser.busapp.service.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrajetServiceImp implements TrajetService {
    @Autowired
    private TrajetRepository TrajetRepo;
    @Override
    public List<Trajet> getAll(){
        return TrajetRepo.findAll();
    }
    @Override
    public void save(Trajet trajet){
        TrajetRepo.save(trajet);
    }


}
