package me.dio.credit.application.system.dto

import java.math.BigDecimal
import java.time.LocalDate
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Max

data class CreditDto (
    @field:NotNull(message = "Credit value must be informed") val creditValue: BigDecimal,
    @field:Future(message = "Installment date must be future") val dayFirstOfInstallment: LocalDate,
    @field:Max(value = 48, message = "Number of installments must be up to 48 months") val numberOfInstallments: Int,
    @field:NotNull(message = "Customer id must be informed") val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
        
    )
}