package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Credit

import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDate

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallments: Int,
) {
    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        dayFirstOfInstallment = credit.dayFirstInstallment,
        numberOfInstallments = credit.numberOfInstallments


    )
}