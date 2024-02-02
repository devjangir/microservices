package com.jangir.accountservice.service;

import com.jangir.accountservice.constants.AccountConstants;
import com.jangir.accountservice.dtos.AccountDto;
import com.jangir.accountservice.dtos.CustomerDto;
import com.jangir.accountservice.entity.Account;
import com.jangir.accountservice.entity.Customer;
import com.jangir.accountservice.exception.CustomerAlreadyExistException;
import com.jangir.accountservice.exception.ResourceNotFoundException;
import com.jangir.accountservice.mapper.AccountMapper;
import com.jangir.accountservice.mapper.CustomerMapper;
import com.jangir.accountservice.repository.AccountRepository;
import com.jangir.accountservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(customerOptional.isPresent()){
            throw new CustomerAlreadyExistException("Customer already exist with mobile number: "+customerDto.getMobileNumber());
        }
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
//        customer.setCreatedAt(LocalDateTime.now());
//        customer.setCreatedBy("SYSTEM");
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createAccount(savedCustomer));
    }

    private Account createAccount(Customer savedCustomer) {
        Account account = new Account();
        account.setCustomerId(savedCustomer.getCustomerId());
        long accountNumber = 10000000000L + new Random().nextInt(1000000000);
        account.setAccountNumber(accountNumber);
        account.setAccountType(AccountConstants.SAVINGS);
        account.setBranchAddress(AccountConstants.ADDRESS);
//        account.setCreatedAt(LocalDateTime.now());
//        account.setCreatedBy("SYSTEM");
        return account;
    }

    @Override
    public CustomerDto getCustomer(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found with mobile number: "+mobileNumber)
        );
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account not found with customer id: "+customer.getCustomerId())
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountDto(AccountMapper.mapToAccountDto(account, new AccountDto()));
        return customerDto;
    }


}
