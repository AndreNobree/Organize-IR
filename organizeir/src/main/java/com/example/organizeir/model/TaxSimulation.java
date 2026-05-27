package com.example.organizeir.model;


import com.example.organizeir.model.enums.SimulationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

//cálculos do IR, comparação entre regimes, restituição, imposto devido, histórico de simulações

@Entity
@Table(
        name = "tax_simulations",
        indexes = {
                @Index(name = "idx_simulation_tax_year", columnList = "tax_year_id"),
                @Index(name = "idx_simulation_type", columnList = "simulation_type")
        }
)
@Getter
@Setter
public class TaxSimulation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_year_id", nullable = false)
    private TaxYear taxYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "simulation_type", nullable = false)
    private SimulationType simulationType;

    @Column(name = "total_income", nullable = false, precision = 15, scale = 2)
    private BigDecimal totalIncome; //salario, dividendo, pj ...

    @Column(name = "total_expenses", nullable = false, precision = 15, scale = 2)
    private BigDecimal totalExpenses; //despesas gerais

    @Column(name = "total_deductions", nullable = false, precision = 15, scale = 2)
    private BigDecimal totalDeductions; // total de dedução

    @Column(name = "taxable_income", nullable = false, precision = 15, scale = 2)
    private BigDecimal taxableIncome; //base tributavel

    @Column(name = "effective_rate", precision = 5, scale = 2)
    private BigDecimal effectiveRate; //aliquota efetiva

    @Column(name = "tax_due", nullable = false, precision = 15, scale = 2)
    private BigDecimal taxDue; //imposto devido

    @Column(name = "refund_amount", precision = 15, scale = 2)
    private BigDecimal refundAmount; //retribuição estimada

    @Column(name = "generated_by_ai")
    private boolean generatedByAi = false;

    @Column(name = "calculation_details", columnDefinition = "TEXT")
    private String calculationDetails;

    @CreationTimestamp
    @Column(name = "generated_at", nullable = false, updatable = false)
    private LocalDateTime generatedAt;
}