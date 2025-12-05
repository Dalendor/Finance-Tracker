package com.projecten.finance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class AlertThreshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int percentage;
    private String message = "Waarschuwing: %d%% van je budget bereikt";

    @ManyToOne
    @JoinColumn(name = "budget_id", nullable = false)
    private Budget budget;
}