package me.dio.credit.application.system.service.impl

import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.repository.CustomerRepository
import me.dio.credit.application.system.service.ICustomerService
import me.dio.credit.application.system.exception.BusinessException
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {
    override fun save(customer: Customer): Customer
        = customerRepository.save(customer)

    override fun findById(id: Long): Customer
        = customerRepository.findById(id).orElseThrow{throw BusinessException("Id $id not found")}

    override fun delete(id: Long)
        = customerRepository.deleteById(id)

}

