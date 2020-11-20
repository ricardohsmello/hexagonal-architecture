package br.com.ricas.controller.finance;

import br.com.ricas.dto.CreateFinanceRequest;
import br.com.ricas.dto.CreateFinanceResponse;
import br.com.ricas.model.Finance;
import br.com.ricas.port.PersistentFinancePort;
import br.com.ricas.usecase.CreateExpenseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @author ricardo.mello
 *
 */
@RestController
@RequestMapping("api/finances")
@AllArgsConstructor
public class FinanceController {

    CreateExpenseUseCase createExpenseUseCase;

    @RequestMapping(value = "/finance", method = RequestMethod.POST)
    public ResponseEntity<CreateFinanceResponse> add(@RequestBody CreateFinanceRequest createFinanceRequest) throws Exception {
        Finance finance = createExpenseUseCase.execute(createFinanceRequest.transformToObject());
        CreateFinanceResponse financeResponse = new CreateFinanceResponse();
        financeResponse.setDescription(finance.getDescription());
        return new ResponseEntity<>(financeResponse, HttpStatus.CREATED);
    }
}
