package com.ms.cuponcompra.controller.advice;

import com.ms.cuponcompra.dto.ErrorDto;
import com.ms.cuponcompra.exception.ExcepcionCuponCompra;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {
    @ExceptionHandler(value = ExcepcionCuponCompra.class)
    public ResponseEntity<ErrorDto> runTimeExeptionHandler(ExcepcionCuponCompra ex){
        return ResponseEntity.status(ex.getCodeHttp()).body(ErrorDto.builder().codigoError(ex.getCodigoError()).descripcion(ex.getDescripcion()).build());
    }
}
