package dev.java10x.davi.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vinda", description = "Essa rota da uma msg de boas vinda para quem acessa ela")
    public String BoasVindas() {
        return "Boas vindas ao cadastro de ninjas.";
    }

    // Adicionar ninja (CREATE)

    @PostMapping("/create")
    @Operation(summary = "Cria um novo ninja.", description = "Rota cria um novo ninja e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja.")
    })
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja: " + ninjaDTO.getNome() + " ID: " + ninjaDTO.getId() + "criado com sucesso!");
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/all")
    @Operation(summary = "Lista todos os ninjas", description = "Rota lista todos os ninjas do banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listou todos os ninjas."),
    })
    public ResponseEntity<List<NinjaDTO>> showAllNinjas() {
        List<NinjaDTO> ninjaDTOList = new ArrayList<>();
        ninjaDTOList.addAll(ninjaService.showAllNinjas());
        return ResponseEntity.ok(ninjaDTOList);
    }

    //Mostrar ninjas por ID (READ)
    @GetMapping("/all/{id}")
    @Operation(summary = "Lista ninja por id", description = "Rota lista o ninja pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")
    })
    public ResponseEntity<?> showNinjaById(@Parameter(description = "Usuario manda por id no caminho da requisição.") @PathVariable Long id) {
        if (ninjaService.showNinjaById(id) != null) {
            NinjaDTO ninjaDTO = ninjaService.showNinjaById(id);
            return ResponseEntity.ok(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe ninja com o ID: " + id);
        }

    }

    // Alterar dados ninja (UPDATE)
    @PutMapping("/update/{id}")
    @Operation(summary = "Altera ninja por id", description = "Rota altera o ninja pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado para ser alterado.")
    })
    public ResponseEntity<String> updateNinjaId(
            @Parameter(description = "Usuario manda por id no caminho da requisição.")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser alterado no corpo da requisição.")
            @RequestBody NinjaDTO ninja) {
        if (ninjaService.showNinjaById(id) != null) {
            NinjaDTO ninjaDTO = ninjaService.updateNinja(id, ninja);
            return ResponseEntity.ok("Ninja: " + ninjaDTO.getNome() + " ID: " + ninjaDTO.getId() + " atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe ninja com o ID:" + id);
        }
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Exclui o ninja por id", description = "Rota Exclui o ninja pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja excluido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado para ser excluido.")
    })
    public ResponseEntity<String> deleteNinjaId(@Parameter(description = "Usuario manda por id no caminho da requisição.") @PathVariable Long id) {
        if (ninjaService.showNinjaById(id) != null) {
            NinjaDTO ninjaDTO = ninjaService.showNinjaById(id);
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok("Ninja: " + ninjaDTO.getNome() + " ID: " + ninjaDTO.getId() + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe ninja com o ID:" + id);
        }
    }


}
