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
    public NinjaModel createNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.createNinja(ninja);
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/all")
    public List<NinjaModel> showAllNinjas() {
        return ninjaService.showAllNinjas();
    }

    //Mostrar ninjas por ID (READ)
    @GetMapping("/all/{id}")
    public NinjaModel showNinjaById(@PathVariable Long id) {
        return ninjaService.showNinjaById(id);
    }

    // Alterar dados ninja (UPDATE)
    @PutMapping("/update/{id}")
    public NinjaModel updateNinjaId(@PathVariable Long id, @RequestBody NinjaModel ninja) {
        return ninjaService.updateNinja(id, ninja);
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteNinjaId(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
    }


}
