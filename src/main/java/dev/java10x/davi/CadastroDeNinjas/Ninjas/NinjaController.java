package dev.java10x.davi.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninja")
public class NinjaController {
    @GetMapping("/boasvindas")
    public String BoasVindas() {
        return "Boas vindas ao cadastro de ninjas.";
    }

    // Adicionar ninja (CREATE)

    @PostMapping("/create")
    public String createNinja(){
        return "Ninja criado";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/all")
    public String showAllNinjas(){
        return "Aqui estão todos os ninjas";
    }

    //Mostrar ninjas por ID (READ)
    @GetMapping("/allid")
    public String showAllNinjasId(){
        return "Aqui estão todos os ID dos ninjas";
    }

    // Alterar dados ninja (UPDATE)
    @PutMapping("/update")
    public String updateNinjaId(){
        return "Ninja atualizado";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/delete")
    public String deleteNinjaId(){
        return "Ninja deletado";
    }


}
