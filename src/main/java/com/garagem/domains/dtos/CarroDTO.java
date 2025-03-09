package com.garagem.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.garagem.domains.Carro;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CarroDTO {
    private Integer idCarro;

    @NotNull(message = "O campo placa não pode ser nulo!")
    @NotBlank(message = "O campo placa não pode ser vazio!")
    private String placa;

    @NotNull(message = "O campo marca não pode ser nulo!")
    @NotBlank(message = "O campo marca não pode ser vazio!")
    private String marca;

    @NotNull(message = "O campo modelo não pode ser nulo!")
    @NotBlank(message = "O campo modelo não pode ser vazio!")
    private String modelo;

    @NotNull(message = "O campo cor não pode ser nulo!")
    @NotBlank(message = "O campo cor não pode ser vazio!")
    private String cor;

    @NotNull(message = "O campo anoFabricacao não pode ser nulo!")
    @Digits(integer = 4, fraction = 0)
    private int anoFabricacao;

    @NotNull(message = "O campo valorDiaria não pode ser nulo!")
    @Digits(integer = 20, fraction = 2)
    private BigDecimal valorCarro;


    private int garagem;

    private String razaoSocialGaragem;

    private int conservacao;

    public CarroDTO() {
    }

    public CarroDTO(Carro carro) {
        this.idCarro = carro.getIdCarro();
        this.placa = carro.getPlaca();
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.cor = carro.getCor();
        this.anoFabricacao = carro.getAnoFabricacao();
        this.valorCarro = carro.getValorCarro();
        this.garagem = carro.getGaragem().getIdGaragem();
        this.razaoSocialGaragem = carro.getGaragem().getRazaoSocial();
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public @NotNull(message = "O campo placa não pode ser nulo!") @NotBlank(message = "O campo placa não pode ser vazio!") String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotNull(message = "O campo placa não pode ser nulo!") @NotBlank(message = "O campo placa não pode ser vazio!") String placa) {
        this.placa = placa;
    }

    public @NotNull(message = "O campo marca não pode ser nulo!") @NotBlank(message = "O campo marca não pode ser vazio!") String getMarca() {
        return marca;
    }

    public void setMarca(@NotNull(message = "O campo marca não pode ser nulo!") @NotBlank(message = "O campo marca não pode ser vazio!") String marca) {
        this.marca = marca;
    }

    public @NotNull(message = "O campo modelo não pode ser nulo!") @NotBlank(message = "O campo modelo não pode ser vazio!") String getModelo() {
        return modelo;
    }

    public void setModelo(@NotNull(message = "O campo modelo não pode ser nulo!") @NotBlank(message = "O campo modelo não pode ser vazio!") String modelo) {
        this.modelo = modelo;
    }

    public @NotNull(message = "O campo cor não pode ser nulo!") @NotBlank(message = "O campo cor não pode ser vazio!") String getCor() {
        return cor;
    }

    public void setCor(@NotNull(message = "O campo cor não pode ser nulo!") @NotBlank(message = "O campo cor não pode ser vazio!") String cor) {
        this.cor = cor;
    }

    @NotNull(message = "O campo anoFabricacao não pode ser nulo!")
    @Digits(integer = 4, fraction = 0)
    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(@NotNull(message = "O campo anoFabricacao não pode ser nulo!") @Digits(integer = 4, fraction = 0) int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public @NotNull(message = "O campo valorDiaria não pode ser nulo!") @Digits(integer = 20, fraction = 2) BigDecimal getValorCarro() {
        return valorCarro;
    }

    public void setValorCarro(@NotNull(message = "O campo valorDiaria não pode ser nulo!") @Digits(integer = 20, fraction = 2) BigDecimal valorCarro) {
        this.valorCarro = valorCarro;
    }

    public int getGaragem() {
        return garagem;
    }

    public void setGaragem(int garagem) {
        this.garagem = garagem;
    }

    public String getRazaoSocialGaragem() {
        return razaoSocialGaragem;
    }

    public void setRazaoSocialGaragem(String razaoSocialGaragem) {
        this.razaoSocialGaragem = razaoSocialGaragem;
    }

    public int getConservacao() {
        return conservacao;
    }

    public void setConservacao(int conservacao) {
        this.conservacao = conservacao;
    }
}
