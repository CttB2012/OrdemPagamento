package com.example.teste.Teste.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Getter
@Setter
public class ExceptionApiOrdem extends ResponseStatusException  {

    private static final long serialVersionUID = 1L;

    private String codigoErro;
    private Object objetoEntrada;
    private String msgCustom;
    private List<?> objetosSaida;

    public ExceptionApiOrdem(HttpStatus status, String codigoErro) {
        super(status, (String)null, (Throwable)null );
        this.codigoErro = codigoErro;
        this.objetoEntrada = null;
        this.msgCustom = ExceptionMessage.buscarMessage(codigoErro);
    }
    public ExceptionApiOrdem(HttpStatus status, Object objetoEntrada, String codigoErro, String mensagemFormatada ) {
        super(status, (String) null, (Throwable) null);
        this.codigoErro = codigoErro;
        this.objetoEntrada = objetoEntrada;
        this.msgCustom = mensagemFormatada;
    }
    public ExceptionApiOrdem(HttpStatus status, String codigoErro, Object... args) {
        super(status, (String) null, (Throwable) null);
        Assert.notNull(args, "Args is required");
        this.codigoErro = codigoErro;
        this.objetoEntrada = null;
        this.msgCustom = String.format(ExceptionMessage.buscarMessage(codigoErro), args);
    }
    public ExceptionApiOrdem(HttpStatus status, String codigoErro, String arg1) {
        super(status, (String)null, (Throwable)null );
        this.codigoErro = codigoErro;
        this.objetoEntrada = null;
        this.msgCustom = String.format(ExceptionMessage.buscarMessage(codigoErro), arg1);
    }
    public ExceptionApiOrdem(HttpStatus status, String reason,String codigoErro,Object objetoEntrada ,@Nullable Throwable cause) {
        super(status, reason, cause );
        this.codigoErro = codigoErro;
        this.objetoEntrada = objetoEntrada;
        this.msgCustom = ExceptionMessage.buscarMessage(codigoErro);
    }
    public ExceptionApiOrdem(HttpStatus status,String codigoErro, List<?>objetosSaida) {
        super(status, (String)null, (Throwable)null );
        this.codigoErro = codigoErro;
        this.objetosSaida = objetosSaida;
        this.msgCustom = ExceptionMessage.buscarMessage(codigoErro);
    }
}
