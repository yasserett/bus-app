package com.yasser.busapp.service.imp;

import com.yasser.busapp.dao.PositionRepository;
import com.yasser.busapp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImp implements PositionService {
    @Autowired
    private PositionRepository PositionRepo;
}
