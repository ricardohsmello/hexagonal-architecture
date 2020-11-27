package br.com.ricas.controller.finance;

import br.com.ricas.controller.finance.dto.CreateFinanceRequest;
import br.com.ricas.controller.finance.dto.CreateFinanceResponse;
import br.com.ricas.exceptions.FinanceException;
import br.com.ricas.model.Finance;
import br.com.ricas.usecase.FinanceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author ricardo.mello
 */
@RestController
@RequestMapping("api/finances")
@AllArgsConstructor
public class FinanceController {

    FinanceUseCase createExpenseUseCase;

    @RequestMapping(value = "/finance", method = RequestMethod.POST)
    public ResponseEntity<CreateFinanceResponse> add(@RequestBody CreateFinanceRequest createFinanceRequest) {
        try {
            Optional<Finance> finance = createExpenseUseCase.execute(createFinanceRequest.transformToObject());

            CreateFinanceResponse financeResponse = CreateFinanceResponse
                    .builder()
                    .uuid(finance.get().getUUID())
                    .description(finance.get().getDescription())
                    .build();

            return new ResponseEntity<>(financeResponse, HttpStatus.CREATED);
        } catch (FinanceException e) {
            throw new FinanceException(e.getMessage());
        }
    }
}