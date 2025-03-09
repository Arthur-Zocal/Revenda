package com.garagem.domains.enums;

public enum Status {
    APROVADO(0,"APROVADO"), EMANALISE(1,"EM ANALISE"),REPROVADO(2,"REPROVADO");

    private Integer id;
    private String status;

    Status(){

    }

    Status(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Status toEnum(Integer id) {
        if (id == null) return null;
        for (Status x : Status.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status invalido!");
    }
}