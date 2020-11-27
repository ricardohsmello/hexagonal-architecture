package br.com.ricas.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder(toBuilder = true)
@Table(name = "FINANCE")
public class FinanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "finance_uuid_seq", sequenceName = "finance_uuid_seq", allocationSize = 1)
    @Column(name = "uuid")
    private UUID UUID;
    private String description;
    private double value;
    private LocalDateTime dateTime;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_uuid")
    private CategoryEntity category;
}
