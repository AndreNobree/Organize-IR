package com.example.organizeir.model;

import com.example.organizeir.model.enums.TaxYearStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// STATUS DE DECLARAÇÃO DE IR DO ANO (2026 - NÃO DECLARADO, 2025 - DECLARADO)

@Entity
@Table(
        name = "tax_years",
        indexes = {
                @Index(name = "idx_tax_year_user", columnList = "user_id"),
                @Index(name = "idx_tax_year_year", columnList = "year")
        }
)
@Getter
@Setter
public class TaxYear {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer year;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaxYearStatus status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "taxYear")
    private List<Income> incomes;

    @OneToMany(
            mappedBy = "taxYear",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Expense> expenses = new ArrayList<>();

    @OneToMany(
            mappedBy = "taxYear",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Deduction> deductions = new ArrayList<>();

    @OneToMany(
            mappedBy = "taxYear",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Document> documents = new ArrayList<>();

    @OneToMany(
            mappedBy = "taxYear",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TaxSimulation> simulations = new ArrayList<>();

    @OneToMany(
            mappedBy = "taxYear",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Report> reports = new ArrayList<>();
}