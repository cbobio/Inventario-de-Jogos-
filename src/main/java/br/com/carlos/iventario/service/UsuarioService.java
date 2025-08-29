package br.com.carlos.iventario.service;
import br.com.carlos.iventario.dto.UsuarioDto;
import br.com.carlos.iventario.entity.TbUsuario;
import br.com.carlos.iventario.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ModelMapper modelMapper;

    /// Método de buscar todos (findAll)
    public List<UsuarioDto> listarTodos(){
        List<TbUsuario> tbUsuarioList = usuarioRepository.findAll();
        if (tbUsuarioList.isEmpty()) {
            throw new RuntimeException("Não foi Encontrado Nenhum Registro!!!!");
        }
        return tbUsuarioList
                .stream()
                .map(UsuarioDto::new)
                .collect(Collectors.toList());
    }
    /// Método de buscar por id (finbyId)
    public UsuarioDto findByIdUsuario(Long id){
        Optional<TbUsuario> tbUsuarioOptional = usuarioRepository.findById(id);
        if (tbUsuarioOptional.isEmpty()) {
            throw new RuntimeException("Não foi Encontrado Nenhum Registro!!!!");
        }
        return new UsuarioDto(tbUsuarioOptional.get());
    }
    /// Método de Atualizar um Registro (update)
    public UsuarioDto upDateUsuario(UsuarioDto usuarioDto, Long id){
        Optional<TbUsuario> tbUsuarioOptional = usuarioRepository.findById(id);
        try {
            modelMapper.map(usuarioDto, tbUsuarioOptional.get());
            return new UsuarioDto(usuarioRepository.save(tbUsuarioOptional.get()));
        } catch (Exception e) {
            throw new RuntimeException("Não foi Encontrado Nenhum Registro!!!!");
        }
    }
    ///Método de Deletar um Registro (Delete)
    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
    /// Método de Criação de um Registro (Create)
    public TbUsuario criateUsuario(UsuarioDto usuarioDto){
        TbUsuario tbUsuario = modelMapper
                .map(usuarioDto, TbUsuario.class);
        return usuarioRepository.save(tbUsuario);
    }

}
