package com.example.organizeir.model;

import com.example.organizeir.model.enums.DeductionCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

// DEDUÇÕES DE IR

@Entity
@Table(
        name = "deductions",
        indexes = {
                @Index(name = "idx_deduction_tax_year", columnList = "tax_year_id"),
                @Index(name = "idx_deduction_category", columnList = "category")
        }
)
@Getter
@Setter
public class Deduction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_year_id", nullable = false)
    private TaxYear taxYear;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeductionCategory category;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "deduction_date", nullable = false)
    private LocalDate deductionDate;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "issuer_name")
    private String issuerName;

    @Column(name = "issuer_document")
    private String issuerDocument;
}