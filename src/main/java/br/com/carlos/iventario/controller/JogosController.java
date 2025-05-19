package br.com.carlos.iventario.controller;
import br.com.carlos.iventario.dto.JogosDto;
import br.com.carlos.iventario.service.JogosService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jogos")
public class JogosController {
    @Autowired
    private JogosService jogosService;

    ///EndPoint para retornar todos Registros
    @Operation(summary = "listar todos", tags = "JogosController")
    @GetMapping
    ResponseEntity<List<JogosDto>> findAll(){
        return ResponseEntity
                .ok()
                .body(jogosService.listarTodos());
    }
    /// EndPoint para retornar Registros por Id
    @Operation(summary = "listar por Id", tags = "JogosController")
    @GetMapping("/{id}")
    ResponseEntity<JogosDto> findById(@PathVariable Long id){
        return ResponseEntity
                .ok()
                .body(jogosService.findByIdJogos(id));
    }
    ///EndPoint para Atualizar um registro
    @Operation(summary = "Atualizar um Registro", tags = "JogosController")
    @PutMapping("/{id}")
    ResponseEntity<JogosDto> updateJogos(@RequestBody JogosDto jogosDto, @PathVariable Long id){
        JogosDto jogosDto1 = jogosService.upDateJogos(jogosDto,id);
        try {
            return ResponseEntity
                    .ok()
                    .body(jogosService.upDateJogos(jogosDto1, id));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
    ///EndPoint para Deletar um Registro (Delete)
    @Operation(summary = "Deletar um Registro", tags = "JogosController")
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteJogos(@PathVariable Long id){
        jogosService.deleteJogos(id);
        return ResponseEntity
                .ok("Registro Excluido");
    }
    ///EndPoint para criar um Registro (create)
    @Operation(summary = "Criar um Registro", tags = "AtivosController")
    @PostMapping
    ResponseEntity<JogosDto> criarJogo(@RequestBody JogosDto jogosDto){
        return ResponseEntity
                .ok()
                .body(new JogosDto(jogosService.criateJogos(jogosDto)));
    }
}

