package ma.mundia.springbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.mundia.springbackend.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
