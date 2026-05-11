package br.com.carlos.iventario.exceptions.globalException;

import br.com.carlos.iventario.exceptions.AcessoNegadoException;
import br.com.carlos.iventario.exceptions.DuplicateResourceException;
import br.com.carlos.iventario.exceptions.erroResponse.ErrorResponse;
import br.com.carlos.iventario.exceptions.RegistroNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeptionHandler {
    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleRegistroNaoEncontrado(RegistroNaoEncontradoException ex){
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AcessoNegadoException.class)
    public ResponseEntity<ErrorResponse> handleAcessoNegado(AcessoNegadoException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.FORBIDDEN.value(),
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioExistenteException(
            DuplicateResourceException ex) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(
                        HttpStatus.CONFLICT.value(),
                        ex.getMessage()
                ));
    }
}
