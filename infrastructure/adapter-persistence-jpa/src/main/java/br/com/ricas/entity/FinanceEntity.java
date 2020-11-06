package br.com.ricas.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "FINANCE")
public class FinanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long financeId;
    private String description;
    private double value;
}
