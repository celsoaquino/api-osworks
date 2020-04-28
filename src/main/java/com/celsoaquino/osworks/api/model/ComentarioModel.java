package com.celsoaquino.osworks.api.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ComentarioModel {

    private Long id;
    private String descricao;
    private OffsetDateTime dataEnvio;
}
