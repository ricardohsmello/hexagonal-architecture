package br.com.ricas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Account {

    private String UUID;
    private String name;
    private double balance;

}
