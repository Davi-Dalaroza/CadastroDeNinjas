package dev.java10x.davi.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/boasvindas")
    public String BoasVindas() {
        return "Boas vindas ao cadastro de missoes.";
    }

    // POST Adicionar Missão (CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> createMissoes(@RequestBody MissoesDTO missoes) {
        MissoesDTO missoesDTO = missoesService.createMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com Sucesso: " + missoesDTO.getNome() + "(ID): " + missoesDTO.getId());
    }

    // GET Mostrar todos os Missão (READ)
    @GetMapping("/all")
    public ResponseEntity<List<MissoesDTO>> showAllMissoes() {
        List<MissoesDTO> missoesDTOList = new ArrayList<>();
        missoesDTOList.addAll(missoesService.showAllMissoes());
        return ResponseEntity.ok(missoesDTOList);
    }

    // GET Mostrar Missão por ID (READ)
    @GetMapping("/all/{id}")
    public ResponseEntity<?> showMissaoById(@PathVariable Long id) {
        MissoesDTO missoesDTO = missoesService.showMissaoById(id);
        if (missoesDTO != null){
            return ResponseEntity.ok(missoesDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " não encontrada.");
        }
    }

    // PUT Alterar dados Missão (UPDATE)
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMissoesId(@PathVariable Long id, @RequestBody MissoesDTO missoes) {
        MissoesDTO missoesDTO = missoesService.showMissaoById(id);
        if (missoesDTO != null){
            return ResponseEntity.ok("Missão: " + missoesDTO.getNome() + " ID: " + missoesDTO.getId());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " não encontrada.");
        }
    }

    // DELETE Deletar Missão (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMissoesId(@PathVariable Long id) {
        MissoesDTO missoesDTO = missoesService.showMissaoById(id);
        if (missoesDTO != null){
            missoesService.deleteMissoes(id);
            return ResponseEntity.ok("Missão: " + missoesDTO.getNome() + " ID: " + missoesDTO.getId() + " deletada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " não encontrada.");
        }

    }
}
