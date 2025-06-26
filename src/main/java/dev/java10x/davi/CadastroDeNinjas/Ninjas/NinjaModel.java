package dev.java10x.davi.CadastroDeNinjas.Ninjas;

import dev.java10x.davi.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

}
