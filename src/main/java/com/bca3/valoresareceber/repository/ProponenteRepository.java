package com.bca3.valoresareceber.repository;

import com.bca3.valoresareceber.models.Proponente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProponenteRepository extends JpaRepository<Proponente, UUID> {
    Optional<Proponente> findByCpf(String cpf);
}
