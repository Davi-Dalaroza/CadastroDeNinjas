package dev.java10x.davi.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    @GetMapping("/boasvindas")
    public String BoasVindas() {
        return "Boas vindas ao cadastro de missoes.";
    }

    // Adicionar Missão (CREATE)
    @PostMapping("/create")
    public String createMissoes(){
        return "Missão criada";
    }

    //Mostrar todos os Missão (READ)
    @GetMapping("/all")
    public String showAllMissoes(){
        return "Aqui estão todas as missões";
    }

    //Mostrar Missão por ID (READ)
    @GetMapping("/allid")
    public String showAllMissoesId(){
        return "Aqui estão todos os ID das missões";
    }

    // Alterar dados Missão (UPDATE)
    @PutMapping("/update")
    public String updateMissoesId(){
        return "Missão atualizada";
    }

    // Deletar Missão (DELETE)
    @DeleteMapping("/delete")
    public String deleteMissoesId(){
        return "Missão deletada";
    }
}
