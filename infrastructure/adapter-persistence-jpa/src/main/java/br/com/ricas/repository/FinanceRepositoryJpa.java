package br.com.ricas.repository;

import br.com.ricas.entity.FinanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author ricardo.mello
 *
 */
public interface FinanceRepositoryJpa extends JpaRepository<FinanceEntity, UUID> {
}
