package com.itau.test.exception;

import lombok.Getter;

@Getter
public enum ProblemType {

    DADOS_INVALIDOS("Invalid data"),
    ERRO_DE_SISTEMA("System error"),
    PARAMETRO_INVALIDO("Invalid parameter"),
    MENSAGEM_INCOMPREENSIVEL("Incomprehensible message"),
    RECURSO_NAO_ENCONTRADO("Resource not found"),
    ENTIDADE_EM_USO("Entity in use"),
    ERRO_NEGOCIO("Business rule violation");

    private String title;

    ProblemType(String title) {
        this.title = title;
    }

}
