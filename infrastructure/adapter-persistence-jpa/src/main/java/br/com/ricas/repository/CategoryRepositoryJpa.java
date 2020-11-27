package br.com.ricas.repository;

import br.com.ricas.entity.CategoryEntity;
import br.com.ricas.entity.FinanceEntity;
import br.com.ricas.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author ricardo.mello
 *
 */
public interface CategoryRepositoryJpa extends JpaRepository<CategoryEntity, UUID> {
    Optional<Category> findByName(String name);
}