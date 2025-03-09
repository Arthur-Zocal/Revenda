package com.garagem.services;

import com.garagem.domains.Carro;
import com.garagem.domains.Garagem;
import com.garagem.domains.enums.Conservacao;
import com.garagem.repositories.CarroRepositoy;
import com.garagem.repositories.GaragemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class DBService {

    @Autowired
    private CarroRepositoy carroRepo;

    @Autowired
    private GaragemRepository garagemRepo;


    public void initDB(){
        Garagem garagem1 = new Garagem(null, "Arthur Cars", "CNPJ01",5);
        Garagem garagem2 = new Garagem(null, "Filial", " CNPJ02",5);

        Carro carro1 = new Carro(null, "III0000", "Omega", "CD", "VERDE", 2005, new BigDecimal("45000"), garagem1, Conservacao.OTIMO);
        Carro carro2 = new Carro(null, "OOO0000", "Celta", "GT", "PRETO", 2010, new BigDecimal("23000"), garagem2, Conservacao.OTIMO);
        Carro carro3 = new Carro(null, "UUU0000", "Fusca", "1300", "BRANCO", 1888, new BigDecimal("1000"), garagem1, Conservacao.REFORMA);

        garagemRepo.save(garagem1);
        garagemRepo.save(garagem2);
        carroRepo.save(carro1);
        carroRepo.save(carro2);
        carroRepo.save(carro3);
    }
}
