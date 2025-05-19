package br.com.carlos.iventario.dto;
import br.com.carlos.iventario.entity.TbJogos;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor

public class JogosDto {
    private String nome;
    private String plataforma;
    private String genero;

    public JogosDto(TbJogos tbJogos){
        this.nome = tbJogos.getNome();
        this.plataforma = tbJogos.getPlataforma();
        this.genero = tbJogos.getGenero();
    }


}
