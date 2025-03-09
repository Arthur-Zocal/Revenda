package com.garagem.domains.dtos;

import com.garagem.domains.Garagem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GaragemDTO {

    private Integer idGaragem;

    @NotNull(message = "O campo cnpj não pode ser nulo!")
    @NotBlank(message = "O campo cnpj não pode ser vazio!")
    private String cnpj;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message="O campo carrosLivres não pode ser nulo!")
    private int carrosLivres;

    public GaragemDTO() {
    }

    public GaragemDTO(Garagem garagem) {
        this.idGaragem = garagem.getIdGaragem();
        this.cnpj = garagem.getCnpj();
        this.nome = garagem.getNome();
        this.carrosLivres = garagem.getCarros() != null ? garagem.getCarros().size() : 0;
    }

    public Integer getIdGaragem() {
        return idGaragem;
    }

    public void setIdGaragem(Integer idGaragem) {
        this.idGaragem = idGaragem;
    }

    public @NotNull(message = "O campo cnpj não pode ser nulo!") @NotBlank(message = "O campo cnpj não pode ser vazio!") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo cnpj não pode ser nulo!") @NotBlank(message = "O campo cnpj não pode ser vazio!") String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String nome) {
        this.nome = nome;
    }

    @NotNull(message = "O campo carrosLivres não pode ser nulo!")
    public int getCarrosLivres() {
        return carrosLivres;
    }

    public void setCarrosLivres(@NotNull(message = "O campo carrosLivres não pode ser nulo!") int carrosLivres) {
        this.carrosLivres = carrosLivres;
    }
}
