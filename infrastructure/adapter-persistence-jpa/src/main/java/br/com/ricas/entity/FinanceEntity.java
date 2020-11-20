package br.com.ricas.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder(toBuilder = true)
@Table(name = "FINANCE")
public class FinanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long financeId;
    private String description;
    private double value;
}
