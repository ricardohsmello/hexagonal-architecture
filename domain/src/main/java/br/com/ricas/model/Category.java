package br.com.ricas.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Category {

    private String UUID;
    private String name;
    private int type;

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + UUID +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
