package br.com.carlos.iventario.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "jogos")
public class TbJogos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome_jogo", nullable = false)
    private String nome;
    @Column(name = "plataforma_game", nullable = false)
    private String plataforma;
    @Column(name = "genero_game", nullable = false)
    private String genero;

}
