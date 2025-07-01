package dev.java10x.davi.CadastroDeNinjas.Ninjas;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository ninjaRepository) {
        this.ninjaMapper = ninjaMapper;
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaDTO> showAllNinjas() {
        List<NinjaDTO> ninjaDTOlist = new ArrayList<>();
        List<NinjaModel> ninjaModelList = ninjaRepository.findAll();

        for(NinjaModel ninjaModel : ninjaModelList){
            ninjaDTOlist.add(ninjaMapper.map(ninjaModel));
        }

        return ninjaDTOlist;
    }

    public NinjaDTO showNinjaById(Long pId) {
        Optional<NinjaModel> returnNinjaModel = ninjaRepository.findById(pId);
        NinjaDTO ninjaDTO = ninjaMapper.map(returnNinjaModel.orElse(null));

        return ninjaDTO;
    }

    public NinjaDTO createNinja(NinjaDTO pNinja) {
        NinjaModel ninjaModel = ninjaMapper.map(pNinja);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public void deleteNinja(Long pId) {
        ninjaRepository.deleteById(pId);
    }

    public NinjaDTO updateNinja(Long pId, NinjaDTO pNinja) {
        if (ninjaRepository.existsById(pId)) {
            pNinja.setId(pId);
            NinjaModel ninjaModel = ninjaMapper.map(pNinja);
            ninjaModel = ninjaRepository.save(ninjaModel);
            return ninjaMapper.map(ninjaModel);
        }
        return null;
    }
}
