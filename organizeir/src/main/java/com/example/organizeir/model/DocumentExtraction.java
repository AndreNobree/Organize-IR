package com.example.organizeir.model;

import com.example.organizeir.model.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(
        name = "document_extractions",
        indexes = {
                @Index(name = "idx_extraction_document", columnList = "document_id"),
                @Index(name = "idx_extraction_status", columnList = "status")
        }
)
@Getter
@Setter
public class DocumentExtraction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "extracted_name")
    private String extractedName;

    @Column(name = "extracted_cpf_cnpj")
    private String extractedCpfCnpj;

    @Column(name = "extracted_amount", precision = 15, scale = 2)
    private BigDecimal extractedAmount;

    @Column(name = "extracted_date")
    private LocalDateTime extractedDate;

    @Column(name = "raw_text", columnDefinition = "TEXT")
    private String rawText;

    @Column(name = "confidence_score")
    private Double confidenceScore;

    @Column(name = "engine_name")
    private String engineName;

    @Column(name = "processing_time_ms")
    private Long processingTimeMs;

    @Column(name = "error_message", columnDefinition = "TEXT")
    private String errorMessage;

    @CreationTimestamp
    @Column(name = "processed_at", nullable = false, updatable = false)
    private LocalDateTime processedAt;
}

