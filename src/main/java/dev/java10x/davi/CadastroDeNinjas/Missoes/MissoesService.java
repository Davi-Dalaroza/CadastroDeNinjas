package dev.java10x.davi.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> showAllMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel showMissaoById(Long pId){
        Optional<MissoesModel> returnMissoesModel = missoesRepository.findById(pId);
        return returnMissoesModel.orElse(null);
    }

    public MissoesModel createMissoes(MissoesModel pMissoes){
        return missoesRepository.save(pMissoes);
    }
}
