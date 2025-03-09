package com.garagem.repositories;

import com.garagem.domains.Garagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GaragemRepository extends JpaRepository<Garagem, Integer> {

    Optional<Garagem> findByCnpj(String cnpj);
}
