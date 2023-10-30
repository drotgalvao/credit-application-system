package me.dio.credit.application.system.dto

import me.dio.credit.application.system.enummeration.Status
import me.dio.credit.application.system.entity.Credit

import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDate

data class CreditView (
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallments: Int,
    val status : Status,
    val emailCustomer: String?,
    val inconeCustomer: BigDecimal?
) {
    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        dayFirstOfInstallment = credit.dayFirstInstallment,
        numberOfInstallments = credit.numberOfInstallments,
        status = credit.status,
        emailCustomer = credit.customer?.email,
        inconeCustomer = credit.customer?.income
        
    )
}