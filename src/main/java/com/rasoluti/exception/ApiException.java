package com.rasoluti.exception;

import org.springframework.http.HttpStatus;

//@Getter
public class ApiException extends RuntimeException {

    private HttpStatus status;

    private String artefato;

    /* ------------------------------------------------------------------------------------------------------*/

    public ApiException(String mensagem, HttpStatus status) {
        super(mensagem);
        this.status = status;
    }

    /* ------------------------------------------------------------------------------------------------------*/

    public ApiException(Throwable causa) {
        ApiException.resolveCausa(causa);
    }

    /* ------------------------------------------------------------------------------------------------------*/

    public ApiException(String mensagem, String artefato, HttpStatus status) {
        super(mensagem);
        this.artefato = artefato;
        this.status = status;
    }

    /* ------------------------------------------------------------------------------------------------------*/

    public static void resolveCausa(Throwable cause){}

    /* ------------------------------------------------------------------------------------------------------*/
}
