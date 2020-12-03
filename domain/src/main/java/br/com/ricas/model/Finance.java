package br.com.ricas.model;

import br.com.ricas.exceptions.FieldException;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@ToString
@Slf4j
public class Finance {

    private String UUID;
    private String description;
    private double value;
    private LocalDateTime dateTime;
    private Category category;
    private Account account;

    public void validate() throws FieldException {
        log();

        if (validate(this.getDescription())) {
            throw new FieldException("property description can't be null or blank");
        }

        if (this.getValue() <= 0) {
            throw new FieldException("property value must be greater than zero");
        }

//        if (!validate(this.getCategory().getUUID())) {
//            if (!CheckUUID.isValidUUID(this.getCategory().getUUID())) {
//                throw new FinanceException("property category.uuid is not a valid uuid");
//            }
//        }

        if (validate(this.getCategory().getName())) {
            throw new FieldException("property category.uuid can't be null");
        }


        if (validate(this.getAccount().getUUID())) {
            throw new FieldException("property category.uuid can't be null");
        }
    }

    private boolean validate(String property) {
        return property == null || property.isEmpty();
    }

    private void log() {
        log.info("Initializing finance validations");
        log.info(this.toString());
        log.info(this.getCategory().toString());
    }
}
