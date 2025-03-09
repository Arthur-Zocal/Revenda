package com.garagem.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.garagem.domains.dtos.CarroDTO;
import com.garagem.domains.enums.Conservacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

import java.util.Objects;
@Entity
@Table(name="carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_caminhao")
    private Integer idCarro;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String placa;

    @NotNull
    @NotBlank
    private String marca;

    @NotNull
    @NotBlank
    private String modelo;

    @NotNull
    @NotBlank
    private String cor;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private int anoFabricacao;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal valorCarro;

    @ManyToOne
    @JoinColumn(name = "idgaragem")
    private Garagem garagem;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "estado")
    private Conservacao conservacao;

    public Carro() {
    }

    public Carro(Integer idCarro, String placa, String marca, String modelo, String cor, int anoFabricacao, BigDecimal valorCarro, Garagem garagem, Conservacao conservacao) {
        this.idCarro = idCarro;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
        this.valorCarro = valorCarro;
        this.garagem = garagem;
        this.conservacao = conservacao;
    }

    public Carro(CarroDTO dto) {
        this.idCarro = dto.getIdCarro();
        this.placa = dto.getPlaca();
        this.marca = dto.getMarca();
        this.modelo = dto.getModelo();
        this.cor = dto.getCor();
        this.anoFabricacao = dto.getAnoFabricacao();
        this.valorCarro = dto.getValorCarro();
        this.garagem = new Garagem();
        this.garagem.setIdGaragem(dto.getGaragem());
        this.conservacao = Conservacao.toEnum(dto.getConservacao());
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public @NotNull @NotBlank String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotNull @NotBlank String placa) {
        this.placa = placa;
    }

    public @NotNull @NotBlank String getMarca() {
        return marca;
    }

    public void setMarca(@NotNull @NotBlank String marca) {
        this.marca = marca;
    }

    public @NotNull @NotBlank String getModelo() {
        return modelo;
    }

    public void setModelo(@NotNull @NotBlank String modelo) {
        this.modelo = modelo;
    }

    public @NotNull @NotBlank String getCor() {
        return cor;
    }

    public void setCor(@NotNull @NotBlank String cor) {
        this.cor = cor;
    }

    @NotNull
    @Digits(integer = 4, fraction = 0)
    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(@NotNull @Digits(integer = 4, fraction = 0) int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public @NotNull @Digits(integer = 10, fraction = 2) BigDecimal getValorCarro() {
        return valorCarro;
    }

    public void setValorCarro(@NotNull @Digits(integer = 10, fraction = 2) BigDecimal valorCarro) {
        this.valorCarro = valorCarro;
    }

    public Garagem getGaragem() {
        return garagem;
    }

    public void setGaragem(Garagem garagem) {
        this.garagem = garagem;
    }

    public Conservacao getConservacao() {
        return conservacao;
    }

    public void setConservacao(Conservacao conservacao) {
        this.conservacao = conservacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(idCarro, carro.idCarro) && Objects.equals(placa, carro.placa) && Objects.equals(marca, carro.marca) && Objects.equals(modelo, carro.modelo) && Objects.equals(cor, carro.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCarro, placa, marca, modelo, cor);
    }
}