package br.com.ricas.repository;

import br.com.ricas.entity.FinanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ricardo.mello
 *
 */
public interface FinanceRepositoryJpa extends JpaRepository<FinanceEntity, Long> {
}
