package br.com.ricas.controller.finance.dto;

import br.com.ricas.enums.FinanceType;
import br.com.ricas.model.Category;
import br.com.ricas.model.Finance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CreateFinanceRequest {

    String uuid;
    String description;
    double value;
    LocalDateTime dateTime;
    Category category;

    public Finance transformToObject() {

        return Finance.builder()
                .description(description)
                .value(value)
                .dateTime(dateTime)
                .category(category)
                .build();
    }
}
