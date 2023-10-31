package me.dio.credit.application.system.dto

import java.math.BigDecimal
import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.entity.Address
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Email
import org.hibernate.validator.constraints.br.CPF

data class CustomerDto(
        @field:NotEmpty(message = "First name is required") val firstName: String,
        @field:NotEmpty(message = "Last name is required") val lastName: String,
        @field:CPF(message = "Invalid CPF format") val cpf: String,
        @field:Email(message = "Invalid email format") val email: String,
        @field:NotNull(message = "Income is required") val income: BigDecimal,
        @field:NotEmpty(message = "Password is required") val password: String,
        @field:NotEmpty(message = "Zip code is required") val zipCode: String,
        @field:NotEmpty(message = "Street is required") val street: String
) {

    fun toEntity(): Customer =
            Customer(
                    firstName = this.firstName,
                    lastName = this.lastName,
                    cpf = this.cpf,
                    email = this.email,
                    income = this.income,
                    password = this.password,
                    address = Address(
                            zipCode = this.zipCode,
                            street = this.street
                    )
            )
}
