package com.celsoaquino.osworks.api.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ComentarioInput {

    @NotBlank
    public String descricao;
}
