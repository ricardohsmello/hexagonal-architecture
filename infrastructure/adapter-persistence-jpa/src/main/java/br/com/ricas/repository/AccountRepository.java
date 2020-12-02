package br.com.ricas.repository;

import br.com.ricas.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author ricardo.mello
 *
 */
public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {
}
