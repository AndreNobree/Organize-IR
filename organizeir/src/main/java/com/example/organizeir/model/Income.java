package com.example.organizeir.model;

import com.example.organizeir.model.enums.IncomeCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

// RENDIMENTOS (DE ONDE O DINHEIRO VEM)

@Entity
@Table(
        name = "incomes",
        indexes = {
                @Index(name = "idx_income_tax_year", columnList = "tax_year_id"),
                @Index(name = "idx_income_category", columnList = "category")
        }
)
@Getter
@Setter
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_year_id", nullable = false)
    private TaxYear taxYear;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncomeCategory category;

    @Column(nullable = false)
    private String sourceName;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate incomeDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
