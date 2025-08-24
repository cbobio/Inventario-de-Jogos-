package br.com.carlos.iventario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario")
public class TbUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_usuario", nullable = false, length = 400)
    private String nome;

    @Column(name = "nome_Psn", nullable = false, length = 300)
    private String nomePsn;

    @Column(name = "senha", nullable = false, length = 200)
    private String senha;

    @Column(name = "tipo_usuario", nullable = false, length = 40)
    private String tipo;
}
