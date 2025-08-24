package br.com.carlos.iventario.dto;

import br.com.carlos.iventario.entity.TbUsuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDto {
    private String nome;
    private String nomePsn;
    private String senha;
    private String tipo;

    public UsuarioDto(TbUsuario tbUsuario){
        this.nome = tbUsuario.getNome();
        this.nomePsn = tbUsuario.getNomePsn();
        this.senha = tbUsuario.getSenha();
        this.tipo = tbUsuario.getTipo();
    }
}
