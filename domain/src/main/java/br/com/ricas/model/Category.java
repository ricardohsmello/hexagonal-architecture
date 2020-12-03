package br.com.ricas.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString
public class Category {

    private String UUID;
    private String name;
    private int type;
}
