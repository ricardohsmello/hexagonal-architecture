package br.com.ricas.model;

import br.com.ricas.enums.FinanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Finance {

    private String description;
    private double value;
    private FinanceType type;
    private Category category;

    public static class Builder {

        private Finance finance;

        public Builder() {
            this.finance = new Finance();
        }

        public Builder type(FinanceType financeType) {
            this.finance.setType(financeType);
            return this;
        }

        public Builder category(Category category) {
            this.finance.setCategory(category);
            return this;
        }

        public Builder description(String description) {
            this.finance.setDescription(description);
            return this;
        }

        public Builder value(double value) {
            this.finance.setValue(value);
            return this;
        }

        public Finance build() {
            return this.finance;
        }
    }
}
