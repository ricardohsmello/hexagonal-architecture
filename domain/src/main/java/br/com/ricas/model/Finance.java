package br.com.ricas.model;

import br.com.ricas.exceptions.FieldException;
import br.com.ricas.util.BaseModel;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Finance extends BaseModel<Finance> {

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

        public Finance.Builder description(String description) {
            this.finance.setDescription(description);
            return this;
        }

        public Finance.Builder value(Double value) {

//            if (value == null)
//                return this;
//
//            if (value < 0) {
//                throw new FieldException("value must be greater than zero");
//            }

//            this.finance.setValue(value);
            this.finance.setValue(Optional.ofNullable(value).filter(p -> p > 0).orElseThrow(() -> new FieldException("value must be greater than zero")));
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
            return new Finance(
                    this.finance.getDescription(),
                    this.finance.getValue(),
                    this.finance.getDateTime(),
                    this.finance.getCategory(),
                    this.finance.getAccount());
        }
    }
}
