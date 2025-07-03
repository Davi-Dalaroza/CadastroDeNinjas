package dev.java10x.davi.CadastroDeNinjas.Ninjas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.davi.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(name = "img_url")
    private String imgUrl;
    @Column(name = "idade")
    private Integer idade;
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;
    @JoinColumn(name= "rank")
    private String Rank;

}
