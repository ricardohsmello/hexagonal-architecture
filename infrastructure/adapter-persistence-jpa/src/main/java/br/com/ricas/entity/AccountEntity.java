package br.com.ricas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder(toBuilder = true)
@Table(name = "ACCOUNT")
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "account_uuid_seq", sequenceName = "account_uuid_seq", allocationSize = 1)
    @Column(name = "uuid")
    private UUID UUID;
    private String name;
    private double balance;
}
