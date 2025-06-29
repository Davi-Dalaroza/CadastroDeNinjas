package dev.java10x.davi.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String BoasVindas() {
        return "Boas vindas ao cadastro de ninjas.";
    }

    // Adicionar ninja (CREATE)

    @PostMapping("/create")
    public String createNinja() {
        return "Ninja criado";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/all")
    public List<NinjaModel> showAllNinjas() {
        return ninjaService.showAllNinjas();
    }

    //Mostrar ninjas por ID (READ)
    @GetMapping("/allid")
    public String showAllNinjasId() {
        return "Aqui estão todos os ID dos ninjas";
    }

    // Alterar dados ninja (UPDATE)
    @PutMapping("/update")
    public String updateNinjaId() {
        return "Ninja atualizado";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/delete")
    public String deleteNinjaId() {
        return "Ninja deletado";
    }


}
