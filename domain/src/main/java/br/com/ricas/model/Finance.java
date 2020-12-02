package br.com.ricas.model;

import br.com.ricas.exceptions.FinanceException;
import br.com.ricas.util.CheckUUID;
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

    public void isInvalid() throws FinanceException {
        log();

        if (isInvalid(this.getDescription())) {
            throw new FinanceException("property description can't be null or blank");
        }

        if (this.getValue() <= 0) {
            throw new FinanceException("property value must be greater than zero");
        }

        if (!isInvalid(this.getCategory().getUUID())) {
            if (!CheckUUID.isUUID(this.getCategory().getUUID())) {
                throw new FinanceException("property category.uuid is not a valid uuid");
            }
        }

        if (isInvalid(this.getCategory().getName())) {
            throw new FinanceException("property category.uuid can't be null");
        }
    }

    private boolean isInvalid(String property) {
        return property == null || property.isEmpty();
    }

    private void log() {
        log.info("Initializing finance validations");
        log.info(this.toString());
        log.info(this.getCategory().toString());
    }
}
