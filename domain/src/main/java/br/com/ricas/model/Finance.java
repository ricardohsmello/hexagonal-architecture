package br.com.ricas.model;

import br.com.ricas.exceptions.FieldException;
import br.com.ricas.util.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Finance extends BaseModel<Finance> {

    private String UUID;
    private String description;
    private Double value;
    private LocalDateTime dateTime;
    private Category category;
    private Account account;


    public static class Builder {

        Finance finance;

        public Builder() {
            finance = new Finance();
        }

        public Finance.Builder UUID(String UUID) {
            this.finance.setUUID(UUID);
            return this;
        }

        public Finance.Builder description(String description) {
            this.finance.setDescription(description);
            return this;
        }

        public Finance.Builder value(Double value) {
            if (value == null)
                return this;

            if (value < 0) {
                throw new FieldException("value must be greater than zero");
            }

            this.finance.setValue(value);
            return this;
        }

        public Finance.Builder dateTime(LocalDateTime dateTime) {
            this.finance.setDateTime(dateTime);
            return this;
        }

        public Finance.Builder category(Category category) {
            this.finance.setCategory(category);
            return this;
        }

        public Finance.Builder account(Account account) {
            this.finance.setAccount(account);
            return this;
        }

        public Finance build() {
            Finance finance = new Finance(this.finance.getUUID(),
                    this.finance.getDescription(),
                    this.finance.getValue(),
                    this.finance.getDateTime(),
                    this.finance.getCategory(),
                    this.finance.getAccount());

            finance.validateProperties(finance);
            return finance;
        }
    }

}
