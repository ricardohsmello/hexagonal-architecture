package br.com.ricas.controller.finance.dto;

import br.com.ricas.model.Account;
import br.com.ricas.model.Category;
import br.com.ricas.model.Finance;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FinanceRequest {

    String uuid;
    String description;
    Double value;
    LocalDateTime dateTime;
    Category category;
    Account account;

    public Finance transformToObject() {
        Finance build = new Finance.Builder()
                .description(description)
                .value(value)
                .dateTime(dateTime)
                .category(category)
                .account(account)
                .build();

        return build;
    }
}
