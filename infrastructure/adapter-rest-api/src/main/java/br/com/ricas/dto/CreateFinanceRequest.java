package br.com.ricas.dto;

import br.com.ricas.enums.FinanceType;
import br.com.ricas.model.Category;
import br.com.ricas.model.Finance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFinanceRequest {

    private String description;

    public Finance transformToObject() {
        Finance finance = new Finance();
        finance.setDescription(description);
        return finance;
    }
}
