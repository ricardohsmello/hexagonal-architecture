package br.com.ricas.repository.finance;

import br.com.ricas.entity.FinanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

/**
 * @author ricardo.mello
 */
public interface FinanceRepository extends JpaRepository<FinanceEntity, UUID> {

    @Query("SELECT f FROM FinanceEntity f, CategoryEntity c WHERE f.category = c.UUID and c.type = :type")
    List<FinanceEntity> findAllByType(@Param("type") Integer type);

    @Override
    List<FinanceEntity> findAll();
}
