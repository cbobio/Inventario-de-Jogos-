package br.com.carlos.iventario.repository;

import br.com.carlos.iventario.entity.TbUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<TbUsuario, Long> {
}
