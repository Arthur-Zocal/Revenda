package com.garagem.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.garagem.domains.dtos.GaragemDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="garagem")
public class Garagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_garagem")
    private Integer idGaragem;

    @NotNull
    @NotBlank
    private String cnpj;

    @NotNull
    @NotBlank
    private String razaoSocial;

    @NotNull
    @Digits(integer = 10, fraction = 0)
    private int carrosLivres;

    @JsonIgnore
    @OneToMany(mappedBy = "garagem")
    private List<Carro> carros = new ArrayList<>();

    public Garagem() {
    }

    public Garagem(Integer idGaragem, String cnpj, String razaoSocial, int carrosLivres) {
        this.idGaragem = idGaragem;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.carrosLivres = carrosLivres;
    }

    public Garagem(GaragemDTO dto) {
        this.idGaragem = dto.getIdGaragem();
        this.cnpj = dto.getCnpj();
        this.razaoSocial = dto.getRazaoSocial();
        this.carrosLivres = dto.getCarrosLivres();
    }

    public Integer getIdGaragem() {
        return idGaragem;
    }

    public void setIdGaragem(Integer idGaragem) {
        this.idGaragem = idGaragem;
    }

    public @NotNull @NotBlank String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull @NotBlank String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull @NotBlank String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull @NotBlank String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @NotNull
    @Digits(integer = 10, fraction = 0)
    public int getCarrosLivres() {
        return carrosLivres;
    }

    public void setCarrosLivres(@NotNull @Digits(integer = 10, fraction = 0) int carrosLivres) {
        this.carrosLivres = carrosLivres;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garagem garagem = (Garagem) o;
        return Objects.equals(idGaragem, garagem.idGaragem) && Objects.equals(cnpj, garagem.cnpj) && Objects.equals(razaoSocial, garagem.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGaragem, cnpj, razaoSocial);
    }
}