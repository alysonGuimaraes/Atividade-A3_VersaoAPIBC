package com.bca3.valoresareceber.repository;

import com.bca3.valoresareceber.models.LogConsulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LogConsultaRepository extends JpaRepository<LogConsulta, UUID> {
}
