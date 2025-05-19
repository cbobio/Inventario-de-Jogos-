package br.com.carlos.iventario.service;
import br.com.carlos.iventario.dto.JogosDto;
import br.com.carlos.iventario.entity.TbJogos;
import br.com.carlos.iventario.repository.JogosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class JogosService {
    @Autowired
    JogosRepository jogosRepository;
    @Autowired
    ModelMapper modelMapper;

    /// Método de buscar todos (findAll)
    public List<JogosDto> listarTodos(){
        List<TbJogos> tbJogosList = jogosRepository.findAll();
        if(tbJogosList.isEmpty()){
            throw new RuntimeException("Não foi Encontrado Nenhum Registro!!!!");
        }
        return tbJogosList
                .stream()
                .map(JogosDto::new)
                .collect(Collectors.toList());
    }
    /// Método de buscar por id (finbyId)
    public JogosDto findByIdJogos(Long id){
        Optional<TbJogos> tbJogosOptional = jogosRepository.findById(id);
        if (tbJogosOptional.isEmpty()) {
            throw new RuntimeException("Não foi Encontrado Nenhum Registro!!!!");
        }
        return new JogosDto(tbJogosOptional.get());
    }
    /// Método de Atualizar um Registro (update)
    public JogosDto upDateJogos(JogosDto jogosDto, Long id){
        Optional<TbJogos> tbJogosOptional = jogosRepository.findById(id);
        try {
            modelMapper.map(jogosDto, tbJogosOptional.get());
            return new JogosDto(jogosRepository.save(tbJogosOptional.get()));
        } catch (Exception e) {
            throw new RuntimeException("Não foi Encontrado Nenhum Registro!!!!");
        }
    }
    ///Método de Deletar um Registro (Delete)
    public void deleteJogos(Long id){
        jogosRepository.deleteById(id);
    }
    /// Método de Criação de um Registro (Create)
    public TbJogos criateJogos(JogosDto jogosDto){
        TbJogos tbJogos = modelMapper
                .map(jogosDto, TbJogos.class);
        return jogosRepository.save(tbJogos);
    }
}

