package br.com.carlos.iventario.repository;

import br.com.carlos.iventario.entity.TbJogos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosRepository extends JpaRepository<TbJogos, Long> {
}
