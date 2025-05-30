package br.com.carlos.iventario.controller;

import br.com.carlos.iventario.dto.JogosDto;
import br.com.carlos.iventario.dto.UsuarioDto;
import br.com.carlos.iventario.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    ///EndPoint para retornar todos Registros
    @Operation(summary = "listar todos", tags = "UsuarioController")
    @GetMapping
    ResponseEntity<List<UsuarioDto>> findAll(){
        return ResponseEntity
                .ok()
                .body(usuarioService.listarTodos());
    }
    /// EndPoint para retornar Registros por Id
    @Operation(summary = "listar por Id", tags = "UsuarioController")
    @GetMapping("/{id}")
    ResponseEntity<UsuarioDto> findById(@PathVariable Long id){
        return ResponseEntity
                .ok()
                .body(usuarioService.findByIdUsuario(id));
    }
    ///EndPoint para Atualizar um registro
    @Operation(summary = "Atualizar um Registro", tags = "UsuarioController")
    @PutMapping("/{id}")
    ResponseEntity<UsuarioDto> updateUsuario(@RequestBody UsuarioDto usuarioDto, @PathVariable Long id){
        UsuarioDto usuarioDto1 = usuarioService.upDateUsuario(usuarioDto,id);
        try {
            return ResponseEntity
                    .ok()
                    .body(usuarioService.upDateUsuario(usuarioDto1, id));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
    ///EndPoint para Deletar um Registro (Delete)
    @Operation(summary = "Deletar um Registro", tags = "UsuarioController")
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity
                .ok("Registro Excluido");
    }
    ///EndPoint para criar um Registro (create)
    @Operation(summary = "Criar um Registro", tags = "UsuarioController")
    @PostMapping
    ResponseEntity<UsuarioDto> criarUsuario(@RequestBody UsuarioDto usuarioDto){
        return ResponseEntity
                .ok()
                .body(new UsuarioDto(usuarioService.criateUsuario(usuarioDto)));
    }
}
