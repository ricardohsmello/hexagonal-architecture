package br.com.ricas.controller.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class CreateAccountResponse {

    private UUID UUID;
    private String name;

}
