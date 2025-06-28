package dev.java10x.davi.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissoesController {
    @GetMapping("/boasvindasmissoes")
    public String BoasVindas() {
        return "Boas vindas ao cadastro de missoes.";
    }

    // Adicionar Missão (CREATE)

    @PostMapping("/createmissoes")
    public String createMissoes(){
        return "Missão criada";
    }

    //Mostrar todos os Missão (READ)
    @GetMapping("/allmissoes")
    public String showAllMissoes(){
        return "Aqui estão todas as missões";
    }

    //Mostrar Missão por ID (READ)
    @GetMapping("/allmissoesid")
    public String showAllMissoesId(){
        return "Aqui estão todos os ID das missões";
    }

    // Alterar dados Missão (UPDATE)
    @PutMapping("/updatemissoesid")
    public String updateMissoesId(){
        return "Missão atualizada";
    }

    // Deletar Missão (DELETE)
    @DeleteMapping("/deletemissoesid")
    public String deleteMissoesId(){
        return "Missão deletada";
    }
}
