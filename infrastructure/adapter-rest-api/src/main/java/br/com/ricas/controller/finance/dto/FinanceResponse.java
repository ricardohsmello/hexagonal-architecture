package br.com.ricas.controller.finance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class FinanceResponse {

    private UUID UUID;
    private String description;

}
