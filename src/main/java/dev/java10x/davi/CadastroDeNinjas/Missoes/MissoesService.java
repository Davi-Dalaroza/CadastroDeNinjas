package dev.java10x.davi.CadastroDeNinjas.Missoes;

import dev.java10x.davi.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesMapper missoesMapper, MissoesRepository missoesRepository) {
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesDTO> showAllMissoes(){

        List<MissoesModel> missoesModelList = missoesRepository.findAll();
        return missoesModelList.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO showMissaoById(Long pId){
        Optional<MissoesModel> returnMissoesModel = missoesRepository.findById(pId);
        return returnMissoesModel.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO createMissoes(MissoesDTO pMissoes){
        MissoesModel missoesModel = missoesMapper.map(pMissoes);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    public void deleteMissoes(Long pId){
        missoesRepository.deleteById(pId);
    }

    public MissoesDTO updateMissoes(Long pId, MissoesDTO pMissoes) {
        Optional<MissoesModel> missoesExistente = missoesRepository.findById(pId);
        if (missoesExistente.isPresent()) {
            MissoesModel missoesModel = missoesMapper.map(pMissoes);
            missoesModel.setId(pId);
            MissoesModel missoesModelSalvo = missoesRepository.save(missoesModel);
            return missoesMapper.map(missoesModelSalvo);
        }
        return null;
    }
}
