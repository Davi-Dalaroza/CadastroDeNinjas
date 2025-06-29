package dev.java10x.davi.CadastroDeNinjas.Ninjas;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> showAllNinjas(){
        return ninjaRepository.findAll();
    }
}
