package dev.java10x.davi.CadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Apresenta msg de boas vindas", description = "Rota rota para dar boas vindas.")
    public String BoasVindas() {
        return "Boas vindas ao cadastro de missoes.";
    }

    // POST Adicionar Missão (CREATE)
    @PostMapping("/create")
    @Operation(summary = "Cria a missão", description = "Rota para criar missões.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso."),
    })
    public ResponseEntity<String> createMissoes(@Parameter(description = "Json para criar a missão.") @RequestBody MissoesDTO missoes) {
        MissoesDTO missoesDTO = missoesService.createMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com Sucesso: " + missoesDTO.getNome() + "(ID): " + missoesDTO.getId());
    }

    // GET Mostrar todos os Missão (READ)
    @GetMapping("/all")
    @Operation(summary = "Lista todas as missões.", description = "Rota para listar todas as missões.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missões listadas."),
    })
    public ResponseEntity<List<MissoesDTO>> showAllMissoes() {
        List<MissoesDTO> missoesDTOList = new ArrayList<>();
        missoesDTOList.addAll(missoesService.showAllMissoes());
        return ResponseEntity.ok(missoesDTOList);
    }

    // GET Mostrar Missão por ID (READ)
    @GetMapping("/all/{id}")
    @Operation(summary = "Lista missão por id", description = "Rota lista a missão pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão listada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada para ser listada.")
    })
    public ResponseEntity<?> showMissaoById(@Parameter(description = "Usuario manda por id no caminho da requisição.")@PathVariable Long id) {
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
    @Operation(summary = "Altera missão por id", description = "Rota altera o missão pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão alterada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Missão não encontrado para ser alterada.")
    })
    public ResponseEntity<String> updateMissoesId(
            @Parameter(description = "Usuario manda por id no caminho da requisição.")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados da missão a ser alterada no corpo da requisição.")
            @RequestBody MissoesDTO missoes) {
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
    @Operation(summary = "Exclui a missão por id", description = "Rota Exclui a missão pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão excluida com sucesso."),
            @ApiResponse(responseCode = "404", description = "Missão não encontrado para ser excluida.")
    })
    public ResponseEntity<String> deleteMissoesId( @Parameter(description = "Usuario manda por id no caminho da requisição.") @PathVariable Long id) {
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
