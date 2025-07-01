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
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.createNinja(ninja);
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/all")
    public List<NinjaDTO> showAllNinjas() {
        return ninjaService.showAllNinjas();
    }

    //Mostrar ninjas por ID (READ)
    @GetMapping("/all/{id}")
    public NinjaDTO showNinjaById(@PathVariable Long id) {
        return ninjaService.showNinjaById(id);
    }

    // Alterar dados ninja (UPDATE)
    @PutMapping("/update/{id}")
    public NinjaDTO updateNinjaId(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.updateNinja(id, ninja);
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteNinjaId(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
    }


}
