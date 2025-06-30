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

    public NinjaModel showNinjaById(Long pId){
        Optional<NinjaModel> returnNinjaModel = ninjaRepository.findById(pId);
        return returnNinjaModel.orElse(null);
    }

    public NinjaModel createNinja(NinjaModel pNinja){
        return ninjaRepository.save(pNinja);
    }

    public void deleteNinja(Long pId){
        ninjaRepository.deleteById(pId);
    }
}
