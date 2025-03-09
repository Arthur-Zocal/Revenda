package com.garagem.domains.enums;

public enum Conservacao {
    BOM(0,"BOM"), OTIMO(1,"OTIMO"), REFORMA(2,"REFORMA"), PARADO(3,"PARADO");
    private Integer id;
    private String estado;

    Conservacao(){

    }

    Conservacao(Integer id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConservacao() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static Conservacao toEnum(Integer id){
        if(id==null) return null;
        for(Conservacao x : Conservacao.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Estado de conservacao de veiculo inválido!");
    }
}
