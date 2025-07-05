package dev.java10x.davi.CadastroDeNinjas.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ninja/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/all")
    public String showAllNinjas(Model model) {
        List<NinjaDTO> ninjaDTOList = new ArrayList<>();
        ninjaDTOList.addAll(ninjaService.showAllNinjas());
        model.addAttribute("ninjas", ninjaDTOList);
        return "listarNinjas";
    }

    @GetMapping("/all/{id}")
    public String showNinjaById(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.showNinjaById(id);
        if (ninja != null){
            model.addAttribute("ninja", ninja);
            return "detalhesNinja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado.");
            return "listarNinjas";
        }

    }

    @GetMapping("/create")
    public String createNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes){
        ninjaService.createNinja(ninja);
        redirectAttributes.addFlashAttribute("menssagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninja/ui/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteNinjaId(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
        return "redirect:/ninja/ui/all";
    }
}
