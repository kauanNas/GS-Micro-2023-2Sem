package br.com.fiap.global.backend.repository;

import br.com.fiap.global.backend.model.Indicador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicadorRepository extends JpaRepository<Indicador, Long> {
}
