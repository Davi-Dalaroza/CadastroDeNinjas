package dev.java10x.davi.CadastroDeNinjas.Missoes;

import dev.java10x.davi.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nome;
    private String Rank;
    private List<NinjaModel> ninjas;

}
