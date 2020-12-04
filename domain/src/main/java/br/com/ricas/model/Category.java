package br.com.ricas.model;

import br.com.ricas.exceptions.FieldException;
import br.com.ricas.util.BaseModel;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category extends BaseModel<Category> {
    private String UUID;
    private String name;
    private Integer type;

    public static class Builder {

        Category category;

        public Builder() {
            category = new Category();
        }
        public Builder name(String name) {
            this.category.setName(name);
            return this;
        }

        public Builder type(Integer type) {
            if (type==null) return this;

             if (type >=0 && type <=1) {
                this.category.setType(type);
                return this;
            }

            throw new FieldException("type must be 0 or 1");
        }

        public Category build() {
            Category category = new Category(this.category.getUUID(),
                    this.category.getName(),
                    this.category.getType());

            category.validateProperties(category);
            return category;
        }
    }
}
