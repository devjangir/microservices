package com.jangir.accountservice.service;

import com.jangir.accountservice.dtos.AccountDto;
import com.jangir.accountservice.dtos.CustomerDto;

public interface IAccountService {
    void createAccount(CustomerDto customerDto);

    CustomerDto getCustomer(String mobileNumber);
}
