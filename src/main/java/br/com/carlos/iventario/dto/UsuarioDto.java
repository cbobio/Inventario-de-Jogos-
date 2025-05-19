package br.com.carlos.iventario.dto;

import br.com.carlos.iventario.entity.TbUsuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDto {
    private String nome;
    private String idPsn;
    private String senha;

    private UsuarioDto(TbUsuario tbUsuario){
        this.nome = tbUsuario.getNome();
        this.idPsn = tbUsuario.getIdPsn();
        this.senha = tbUsuario.getSenha();
    }
}
