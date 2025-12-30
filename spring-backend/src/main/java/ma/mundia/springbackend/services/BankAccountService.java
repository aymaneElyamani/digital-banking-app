package ma.mundia.springbackend.services;

import java.util.List;

import ma.mundia.springbackend.dtos.AccountHistoryDTO;
import ma.mundia.springbackend.dtos.AccountOperationDTO;
import ma.mundia.springbackend.dtos.BankAccountDTO;
import ma.mundia.springbackend.dtos.CurrentBankAccountDTO;
import ma.mundia.springbackend.dtos.CustomerDTO;
import ma.mundia.springbackend.dtos.SavingBankAccountDTO;
import ma.mundia.springbackend.exceptions.BalanceNotSufficientException;
import ma.mundia.springbackend.exceptions.BankAccountNotFoundException;
import ma.mundia.springbackend.exceptions.CustomerNotFoundException;
public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}
