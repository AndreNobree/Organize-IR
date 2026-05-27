package com.example.organizeir.model;

import com.example.organizeir.model.enums.Status;
import com.example.organizeir.model.enums.ReportType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

// guarda relatorios

@Entity
@Table(
        name = "reports",
        indexes = {
                @Index(name = "idx_report_tax_year", columnList = "tax_year_id"),
                @Index(name = "idx_report_type", columnList = "report_type"),
                @Index(name = "idx_report_status", columnList = "status")
        }
)
@Getter
@Setter
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_year_id", nullable = false)
    private TaxYear taxYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generated_by", nullable = false)
    private User generatedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_type", nullable = false)
    private ReportType reportType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "storage_path", nullable = false, columnDefinition = "TEXT")
    private String storagePath;

    @Column(name = "mime_type", nullable = false)
    private String mimeType;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "generation_time_ms")
    private Long generationTimeMs;

    @Column(name = "error_message", columnDefinition = "TEXT")
    private String errorMessage;

    @CreationTimestamp
    @Column(name = "generated_at", nullable = false, updatable = false)
    private LocalDateTime generatedAt;
}