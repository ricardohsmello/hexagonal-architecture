package br.com.ricas.controller.finance;

import br.com.ricas.controller.finance.dto.CreateFinanceRequest;
import br.com.ricas.controller.finance.dto.CreateFinanceResponse;
import br.com.ricas.enums.FinanceType;
import br.com.ricas.exceptions.FinanceException;
import br.com.ricas.model.Finance;
import br.com.ricas.usecase.FinanceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author ricardo.mello
 */
@RestController
@RequestMapping("api/finances")
@AllArgsConstructor
public class FinanceController {

    FinanceUseCase financeUseCase;

    @RequestMapping(value = "/finance", method = RequestMethod.POST)
    public ResponseEntity<CreateFinanceResponse> add(@RequestBody CreateFinanceRequest createFinanceRequest) {
        try {
            Optional<Finance> finance = financeUseCase.save(createFinanceRequest.transformToObject());

            if (finance.isEmpty())
                throw new FinanceException("Finance was not created");

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

    @RequestMapping(value = "/finance", method = RequestMethod.GET)
    public ResponseEntity<Optional<List<Finance>>> findAll() {
        return new ResponseEntity<>(financeUseCase.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/finance/findAllByType/{type}", method = RequestMethod.GET)
    public ResponseEntity<Optional<List<Finance>>> findAllByType(@PathVariable("type") String type) {
        return new ResponseEntity<>(financeUseCase.findAllByType(FinanceType.valueOf(type)), HttpStatus.OK);
    }
}