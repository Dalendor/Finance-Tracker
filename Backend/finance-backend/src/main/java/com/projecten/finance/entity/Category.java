package com.projecten.finance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String color = "#3f51b5"; // default Material color

    @ManyToOne
    @JoinColumn(name = "budget_id", nullable = false)
    private Budget budget;
}