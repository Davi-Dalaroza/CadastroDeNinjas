package dev.java10x.davi.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String BoasVindas() {
        return "Boas vindas ao cadastro de ninjas.";
    }

    // Adicionar ninja (CREATE)

    @PostMapping("/create")
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja: " + ninjaDTO.getNome() + " ID: " + ninjaDTO.getId() + "criado com sucesso!");
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/all")
    public ResponseEntity<List<NinjaDTO>> showAllNinjas() {
        List<NinjaDTO> ninjaDTOList = new ArrayList<>();
        ninjaDTOList.addAll(ninjaService.showAllNinjas());
        return ResponseEntity.ok(ninjaDTOList);
    }

    //Mostrar ninjas por ID (READ)
    @GetMapping("/all/{id}")
    public ResponseEntity<?> showNinjaById(@PathVariable Long id) {
        if (ninjaService.showNinjaById(id) != null){
            NinjaDTO ninjaDTO = ninjaService.showNinjaById(id);
            return ResponseEntity.ok(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe ninja com o ID: " + id);
        }

    }

    // Alterar dados ninja (UPDATE)
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateNinjaId(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        if (ninjaService.showNinjaById(id) != null){
            NinjaDTO ninjaDTO = ninjaService.updateNinja(id, ninja);
            return ResponseEntity.ok("Ninja: " + ninjaDTO.getNome() + " ID: " + ninjaDTO.getId() + " atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe ninja com o ID:" + id);
        }
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNinjaId(@PathVariable Long id) {
        if (ninjaService.showNinjaById(id) != null) {
            NinjaDTO ninjaDTO = ninjaService.showNinjaById(id);
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok("Ninja: " + ninjaDTO.getNome() + " ID: " + ninjaDTO.getId() + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe ninja com o ID:" + id);
        }
    }


}
