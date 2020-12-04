package br.com.ricas.controller.category;

import br.com.ricas.controller.category.dto.CategoryRequest;
import br.com.ricas.controller.category.dto.CategoryResponse;
 import br.com.ricas.exceptions.CategoryException;
import br.com.ricas.model.Category;
import br.com.ricas.usecase.CategoryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author ricardo.mello
 */
@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryController {

    CategoryUseCase categoryUseCase;

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity<CategoryResponse> add(@RequestBody CategoryRequest categoryRequest) {
        try {
            Optional<Category> category = categoryUseCase.save(categoryRequest.transformToObject());

            if (category.isEmpty())
                throw new CategoryException("Category was not created");

            CategoryResponse categoryResponse = CategoryResponse
                    .builder()
                    .UUID(UUID.fromString(category.get().getUUID()))
                    .name(category.get().getName())
                    .build();

            return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
        } catch (CategoryException e) {
            throw new CategoryException(e.getMessage());
        }
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<Optional<List<Category>>> findAll() {
        return new ResponseEntity<>(categoryUseCase.findAll(), HttpStatus.OK);
    }
}