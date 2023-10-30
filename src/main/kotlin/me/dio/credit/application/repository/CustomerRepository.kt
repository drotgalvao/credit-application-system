package me.dio.credit.application.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import me.dio.credit.application.system.entity.Customer

@Repository
interface CustomerRepository: JpaRepository<Customer, Long>