package dev.java10x.davi.CadastroDeNinjas.Missoes;

import dev.java10x.davi.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes_dos_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String Rank;
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;


}
