package br.com.ricas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "FINANCE")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FinanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "FinanceEntity_uuid_seq", sequenceName = "FinanceEntity_uuid_seq", allocationSize = 1)
    @Column(name = "uuid")
    private UUID UUID;
    private String description;
    private Double value;
    private LocalDateTime dateTime;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_uuid")
    private CategoryEntity category;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "account_uuid")
    private AccountEntity account;
}
