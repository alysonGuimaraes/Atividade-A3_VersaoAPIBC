package com.bca3.valoresareceber.repository;

import com.bca3.valoresareceber.models.Proponente;
import com.bca3.valoresareceber.models.ValoresReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ValoresReceberRepository extends JpaRepository<ValoresReceber, UUID> {
    List<ValoresReceber> findByProponenteId(UUID prop_id);
}
