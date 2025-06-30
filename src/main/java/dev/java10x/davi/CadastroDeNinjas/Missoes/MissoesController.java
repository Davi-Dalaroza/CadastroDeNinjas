package dev.java10x.davi.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/boasvindas")
    public String BoasVindas() {
        return "Boas vindas ao cadastro de missoes.";
    }

    // POST Adicionar Missão (CREATE)
    @PostMapping("/create")
    public MissoesModel createMissoes(@RequestBody MissoesModel missoes) {
        return missoesService.createMissoes(missoes);
    }

    // GET Mostrar todos os Missão (READ)
    @GetMapping("/all")
    public List<MissoesModel> showAllMissoes() {
        return missoesService.showAllMissoes();
    }

    // GET Mostrar Missão por ID (READ)
    @GetMapping("/all/{id}")
    public MissoesModel showMissaoById(@PathVariable Long id) {
        return missoesService.showMissaoById(id);
    }

    // PUT Alterar dados Missão (UPDATE)
    @PutMapping("/update/{id}")
    public MissoesModel updateMissoesId(@PathVariable Long id, @RequestBody MissoesModel missoes) {
        return missoesService.updateMissoes(id, missoes);
    }

    // DELETE Deletar Missão (DELETE)
    @DeleteMapping("/delete/{id}")
    void deleteMissoesId(@PathVariable Long id) {
        missoesService.deleteMissoes(id);
    }
}
