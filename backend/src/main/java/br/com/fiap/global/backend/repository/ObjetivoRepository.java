package br.com.fiap.global.backend.repository;

import br.com.fiap.global.backend.model.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Long> {
}
