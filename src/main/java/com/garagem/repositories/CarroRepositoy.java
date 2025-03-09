package com.garagem.repositories;

import com.garagem.domains.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarroRepositoy extends JpaRepository<Carro, Integer> {

    Optional<Carro> findByPlaca(String placa);

}
