package dev.java10x.davi.CadastroDeNinjas.Ninjas;

import dev.java10x.davi.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private Integer idade;
    private MissoesModel missoes;
    private String Rank;

}
