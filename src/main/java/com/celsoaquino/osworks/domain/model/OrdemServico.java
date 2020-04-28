package com.celsoaquino.osworks.domain.model;

import com.celsoaquino.osworks.api.model.Comentario;
import com.celsoaquino.osworks.domain.exception.NegocioException;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;
    private String descricao;
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private StatusOrdemServico status;
    private OffsetDateTime dataAbertura;
    private OffsetDateTime dataFinalizacao;

    @OneToMany(mappedBy = "ordemServico")
    private List<Comentario> comentarios = new ArrayList<>();

    public Boolean podeSerFinalizada() {
        return StatusOrdemServico.ABERTA.equals(getStatus());
    }

    public Boolean naoPodeSerFinalizada() {
        return !podeSerFinalizada();
    }

    public void finalizar() {
        if (naoPodeSerFinalizada()) {
            throw new NegocioException("Ordem de serviço não pode ser finalizada.");
        }

        setStatus(StatusOrdemServico.FINALIZADA);
        setDataFinalizacao(OffsetDateTime.now());
    }
}
