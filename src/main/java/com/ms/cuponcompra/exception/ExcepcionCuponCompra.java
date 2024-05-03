package com.ms.cuponcompra.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ExcepcionCuponCompra extends RuntimeException {

    private static final long serialVersionUID = -5778897315177742714L;

    private final String codigoError;

    private final HttpStatus codeHttp;

    private final String descripcion;
}
