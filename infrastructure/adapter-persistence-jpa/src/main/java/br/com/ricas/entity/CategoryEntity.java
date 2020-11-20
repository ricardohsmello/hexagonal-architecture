package br.com.ricas.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long categoryId;
    private String description;
}
