package me.dio.credit.application.system.entity

import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDate
import me.dio.credit.application.system.enummeration.Status
import jakarta.persistence.Table
import jakarta.persistence.Entity
import jakarta.persistence.GenerationType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Enumerated
import jakarta.persistence.Column

@Entity
@Table(name = "Credit")
data class Credit(
    @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallment: LocalDate,
    @Column(nullable = false) val numberOfInstallments: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne val customer: Customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)

